package com.klasnic.pos.process;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Date;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.klasnic.pos.model.catalogs.Banco;
import com.klasnic.pos.model.catalogs.Catalogo;
import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.DatosFiscalesPPL;
import com.klasnic.pos.model.catalogs.EstadoCivil;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;
import com.klasnic.pos.model.catalogs.PPL;
import com.klasnic.pos.model.catalogs.Parentesco;
import com.klasnic.pos.model.catalogs.ReferenciaPPL;
import com.klasnic.pos.model.catalogs.TipoIngresoPPL;
import com.klasnic.pos.model.catalogs.TipoPerfilPPL;
import com.klasnic.pos.model.data.DataException;
import com.klasnic.pos.model.services.CatalogoService;
import com.klasnic.pos.model.services.CentroFederalService;
import com.klasnic.pos.model.services.ModuloCentroFederalService;
import com.klasnic.pos.model.services.PPLService;

@Service
public class PPLLoadFromFile {

	private static final Logger logger = LoggerFactory.getLogger(PPLLoadFromFile.class);

	@Autowired
	CatalogoService<Banco> bancoService;

	@Autowired
	CatalogoService<EstadoCivil> estadoCivilService;

	@Autowired
	CatalogoService<TipoIngresoPPL> tipoIngresoPPLService;

	@Autowired
	CatalogoService<TipoPerfilPPL> tipoPerfilPPLService;

	@Autowired
	CatalogoService<Parentesco> parentescoService;

	@Autowired
	CentroFederalService centroFederalService;

	@Autowired
	ModuloCentroFederalService moduloCentroFederalService;

	@Autowired
	PPLService pplService;

	public PPLLoadFromFile() {
		// TODO Auto-generated constructor stub
	}

	/*
	 * private Double getColumnValueN(Row dataRow, int column) { Cell cell =
	 * dataRow.getCell(column); if (cell == null) return null; return
	 * cell.getNumericCellValue(); }
	 */

	private String getColumnValueS(Row dataRow, int column) {
		Cell cell = dataRow.getCell(column);
		if (cell == null) {
			return null;
		} else {
			try {
				return cell.getStringCellValue();
			} catch (Exception ex) {
				throw new DataException("No se puede leer valor de columna # " + column + 1, ex);
			}
		}
	}

	private Date getColumnValueD(Row dataRow, int column) {
		Cell cell = dataRow.getCell(column);
		if (cell == null) {
			return null;
		} else {
			return cell.getDateCellValue();
		}
	}

	CentroFederal findCentroFederal(String clave) {
		CentroFederal centroFederal = centroFederalService.findByClave(clave);
		if (centroFederal == null) {
			throw new DataException("No se encontro el centro federal con la clave " + clave);
		}
		return centroFederal;
	}

	ModuloCentroFederal findModuloCentroFederal(String clave) {
		ModuloCentroFederal moduloCentroFederal = moduloCentroFederalService.findByClave(clave);
		if (moduloCentroFederal == null) {
			throw new DataException("No se encontro el modulo centro federal con la clave " + clave);
		}
		return moduloCentroFederal;
	}

	<T extends Catalogo> T findItem(CatalogoService<T> service, String clave, boolean required) {
		T item = service.findByClave(clave);
		if (item == null && required) {
			ParameterizedType parameterizedType = (ParameterizedType) service.getClass().getGenericSuperclass();
			Type[] types = parameterizedType.getActualTypeArguments();
			Class<T> classType = (Class<T>) types[0];
			String tipoCatalogo = classType.getSimpleName();

			throw new DataException(
					String.format("No se encontro el elemento con la clave %s para %s", clave, tipoCatalogo));
		}

		return item;
	}

	protected PPL readRow(Row dataRow) {
		PPL ppl = new PPL();

		String nombre = getColumnValueS(dataRow, LayoutField.NOMBRE);
		String apellidoPaterno = getColumnValueS(dataRow, LayoutField.APATERNO);
		String apellidoMaterno = getColumnValueS(dataRow, LayoutField.AMATERNO);
		Date fechaNacimiento = getColumnValueD(dataRow, LayoutField.FECHA_NACIMIENTO);
		String telefono = getColumnValueS(dataRow, LayoutField.TELEFONO);
		String email = getColumnValueS(dataRow, LayoutField.EMAIL);
		String sexo = getColumnValueS(dataRow, LayoutField.SEXO);
		String estadoCivil = getColumnValueS(dataRow, LayoutField.ESTADO_CIVIL);

		String centroFederal = getColumnValueS(dataRow, LayoutField.CENTRO_FEDERAL);
		String modulo = getColumnValueS(dataRow, LayoutField.MODULO_CF);
		String dormitorio = getColumnValueS(dataRow, LayoutField.DORMITORIO);
		String cippl = getColumnValueS(dataRow, LayoutField.CI_PPL);
		String apodo = getColumnValueS(dataRow, LayoutField.APODO);

		Date fechaIngreso = getColumnValueD(dataRow, LayoutField.FECHA_NACIMIENTO);

		String tipoIngreso = getColumnValueS(dataRow, LayoutField.TIPO_INGRESO);
		String tipoPerfil = getColumnValueS(dataRow, LayoutField.TIPO_PERFIL_PPL);
		String banco = getColumnValueS(dataRow, LayoutField.BANCO);
		String clabe = getColumnValueS(dataRow, LayoutField.CLABE);
		String folioExpediente = getColumnValueS(dataRow, LayoutField.FOLIO_EXPEDIENTE);

		String razonSocial = getColumnValueS(dataRow, LayoutField.RAZON_SOCIAL);
		String rfc = getColumnValueS(dataRow, LayoutField.RFC);
		String emailfISCAL = getColumnValueS(dataRow, LayoutField.EMAIL_FISCAL);
		String calle = getColumnValueS(dataRow, LayoutField.CALLE);
		String numExterior = getColumnValueS(dataRow, LayoutField.NUM_EXT);
		String numInterior = getColumnValueS(dataRow, LayoutField.NUM_INT);
		String colonia = getColumnValueS(dataRow, LayoutField.COLONIA);
		String localidad = getColumnValueS(dataRow, LayoutField.LOCALIDAD);
		String delegacionMunicipio = getColumnValueS(dataRow, LayoutField.DELEGACION_MUNICIO);
		String estado = getColumnValueS(dataRow, LayoutField.ESTADO);
		String pais = getColumnValueS(dataRow, LayoutField.PAIS);
		String codigoPostal = getColumnValueS(dataRow, LayoutField.CODIGO_POSTAL);

		// Refrencia 1
		String refnombre = getColumnValueS(dataRow, LayoutField.REF_NOMBRE);
		String refapellidoPaterno = getColumnValueS(dataRow, LayoutField.REF_APATERNO);
		String refapellidoMaterno = getColumnValueS(dataRow, LayoutField.REF_AMATERNO);
		Date reffechaNacimiento = getColumnValueD(dataRow, LayoutField.REF_FECHA_NACIMIENTO);
		String reftelefono = getColumnValueS(dataRow, LayoutField.REF_TELEFONO);
		String refemail = getColumnValueS(dataRow, LayoutField.REF_EMAIL);
		String refsexo = getColumnValueS(dataRow, LayoutField.REF_SEXO);
		String refestadoCivil = getColumnValueS(dataRow, LayoutField.REF_ESTADO_CIVIL);

		// Set de los datos al POJO

		ppl.setNombre(nombre);
		ppl.setApellidoPaterno(apellidoPaterno);
		ppl.setApellidoMaterno(apellidoMaterno);
		ppl.setFechaNacimiento(fechaNacimiento);
		ppl.setTelefono(telefono);
		ppl.setEmail(email);
		if (sexo != null && !sexo.isEmpty())
			ppl.setSexo(sexo.toCharArray()[0]);
		ppl.setEstadoCivil(findItem(estadoCivilService, estadoCivil, true));

		ppl.setCentroFederal(findCentroFederal(centroFederal));
		ppl.setModulo(findModuloCentroFederal(modulo));
		ppl.setDormitorio(dormitorio);
		ppl.setCiPPL(cippl);
		ppl.setApodo(apodo);
		ppl.setFechaIngreso(fechaIngreso);
		ppl.setTipoIngreso(findItem(tipoIngresoPPLService, tipoIngreso, false));
		ppl.setTipoPerfil(findItem(tipoPerfilPPLService, tipoPerfil, true));
		ppl.setBanco(findItem(bancoService, banco, true));
		ppl.setClabe(clabe);
		ppl.setFolioExpediente(folioExpediente);

		// Datos fiscales
		DatosFiscalesPPL datosFiscales = new DatosFiscalesPPL();
		ppl.setDatosFiscales(datosFiscales);

		datosFiscales.setRazonSocial(razonSocial);
		datosFiscales.setRfc(rfc);
		datosFiscales.setEmail(emailfISCAL);
		datosFiscales.setCalle(calle);
		datosFiscales.setNumExterior(numExterior);
		datosFiscales.setNumInterior(numInterior);
		datosFiscales.setColonia(colonia);
		datosFiscales.setLocalidad(localidad);
		datosFiscales.setDelegacionMunicipio(delegacionMunicipio);
		datosFiscales.setEstado(estado);
		datosFiscales.setPais(pais);
		datosFiscales.setCodigoPostal(codigoPostal);

		// Referencia, solo si se detecta nombre incorpora
		if (refnombre != null && !refnombre.isEmpty()) {
			ReferenciaPPL referenciaPPL = new ReferenciaPPL();
			ppl.getReferencias().add(referenciaPPL);

			referenciaPPL.setNombre(refnombre);
			referenciaPPL.setApellidoPaterno(refapellidoPaterno);
			referenciaPPL.setApellidoMaterno(refapellidoMaterno);
			referenciaPPL.setFechaNacimiento(reffechaNacimiento);
			referenciaPPL.setTelefono(reftelefono);
			referenciaPPL.setEmail(refemail);
			if (refsexo != null && !refsexo.isEmpty())
				referenciaPPL.setSexo(refsexo.toCharArray()[0]);
			referenciaPPL.setEstadoCivil(findItem(estadoCivilService, refestadoCivil, true));
		}

		return ppl;
	}

	void copyRow(Row sourceRow, Row targetRow) {
		Iterator<Cell> cells = sourceRow.cellIterator();
		while (cells.hasNext()) {
			Cell sourceCell = cells.next();
			Cell targetCell = targetRow.createCell(sourceCell.getColumnIndex());

			targetCell.getCellStyle().cloneStyleFrom(sourceCell.getCellStyle());

			switch (sourceCell.getCellTypeEnum()) {
			case BLANK:
				targetCell.setCellValue(sourceCell.getStringCellValue());
				break;
			case BOOLEAN:
				targetCell.setCellValue(sourceCell.getBooleanCellValue());
				break;
			case ERROR:
				targetCell.setCellErrorValue(sourceCell.getErrorCellValue());
				break;
			case FORMULA:
				targetCell.setCellFormula(sourceCell.getCellFormula());
				break;
			case NUMERIC:
				targetCell.setCellValue(sourceCell.getNumericCellValue());
				break;
			case STRING:
				targetCell.setCellValue(sourceCell.getStringCellValue());
				break;
			default:
				break;
			}
		}
	}

	static final String INVALID_FILE = "Formato invalido de archivo";

	void validateFile(Sheet dataSheet) {
		Row row = dataSheet.getRow(1);
		if (row == null)
			throw new DataException(INVALID_FILE);

		for (int col = 0; col <= 39; col++) {
			Cell cell = row.getCell(col);
			if (cell == null)
				throw new DataException(INVALID_FILE);
		}

		Cell cell = row.getCell(0);
		if (!cell.getStringCellValue().equals("CI PPL")) {
			throw new DataException(INVALID_FILE);
		}
	}

	String buildMsgError(Throwable source) {
		String msg = source.getMessage();
		Throwable cause = source;
		while (cause.getCause() != null) {
			cause = cause.getCause();
		}

		if (cause != null && !cause.equals(source)) {
			msg = msg + " Causa: " + cause.getMessage();
		}

		return msg;
	}

	public void load(MultipartFile file, OutputStream errorOutputStream) throws IOException {

		Workbook workbook = new XSSFWorkbook(file.getInputStream());
		Sheet dataSheet = workbook.getSheetAt(0);
		Row headerRow = dataSheet.getRow(1);
		validateFile(dataSheet);

		Workbook errorWorkbook = new XSSFWorkbook();
		Sheet errorSheet = errorWorkbook.createSheet("PPLs con error");
		Row errorHeaderRow = errorSheet.createRow(0);
		errorHeaderRow.createCell(LayoutField.ERROR_INFO).setCellValue("Error detectado");
		copyRow(headerRow, errorHeaderRow);
		int errorCount = 1;
		int recordCount = 0;

		Iterator<Row> iterator = dataSheet.iterator();

		while (iterator.hasNext()) {
			Row currentRow = iterator.next();
			if (currentRow.getRowNum() > 1) {
				try {
					PPL ppl = this.readRow(currentRow);
					pplService.save(ppl);
					ppl = null;
					currentRow = null;
					
					recordCount++;
					if(recordCount > 100) {
						recordCount = 0;
						System.gc();
					}
					
				} catch (Exception ex) {
					String msg = buildMsgError(ex);
					//logger.info(msg);
					Row errorRow = errorSheet.createRow(errorCount++);
					copyRow(currentRow, errorRow);
					errorRow.createCell(LayoutField.ERROR_INFO).setCellValue(msg);
				}
			}
		}
		errorWorkbook.write(errorOutputStream);

		workbook.close();
		errorWorkbook.close();
	}
}
