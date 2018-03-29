package com.klasnic.pos.server;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.klasnic.pos.model.catalogs.Banco;
import com.klasnic.pos.model.catalogs.CentroFederal;
import com.klasnic.pos.model.catalogs.DatosFiscalesPPL;
import com.klasnic.pos.model.catalogs.Empresa;
import com.klasnic.pos.model.catalogs.EstadoCivil;
import com.klasnic.pos.model.catalogs.GradoEstudios;
import com.klasnic.pos.model.catalogs.Linea;
import com.klasnic.pos.model.catalogs.Marca;
import com.klasnic.pos.model.catalogs.ModuloCentroFederal;
import com.klasnic.pos.model.catalogs.PPL;
import com.klasnic.pos.model.catalogs.Parentesco;
import com.klasnic.pos.model.catalogs.ReferenciaPPL;
import com.klasnic.pos.model.catalogs.Rol;
import com.klasnic.pos.model.catalogs.Roles;
import com.klasnic.pos.model.catalogs.Serie;
import com.klasnic.pos.model.catalogs.TipoContratacion;
import com.klasnic.pos.model.catalogs.TipoIngresoPPL;
import com.klasnic.pos.model.catalogs.TipoPerfilPPL;
import com.klasnic.pos.model.catalogs.Usuario;
import com.klasnic.pos.model.catalogs.Producto;
import com.klasnic.pos.model.services.CatalogoService;
import com.klasnic.pos.model.services.CentroFederalService;
import com.klasnic.pos.model.services.ModuloCentroFederalService;
import com.klasnic.pos.model.services.PPLService;
import com.klasnic.pos.model.services.RolService;
import com.klasnic.pos.model.services.UsuarioService;
import com.klasnic.pos.model.services.SerieService;
import com.klasnic.pos.model.services.ProductoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PosServerApplicationTests {

	@Autowired
	CatalogoService<EstadoCivil> estadoCivilService;

	@Autowired
	CatalogoService<GradoEstudios> gradoEstudiosService;

	@Autowired
	CatalogoService<TipoContratacion> tipoContratacionService;

	@Autowired
	CatalogoService<TipoIngresoPPL> tipoIngresoPPLService;

	@Autowired
	CatalogoService<TipoPerfilPPL> tipoPerfilPPLService;

	@Autowired
	CatalogoService<Parentesco> parentescoService;

	@Autowired
	ModuloCentroFederalService moduloCentroFederalService;

	@Autowired
	CatalogoService<Banco> bancoService;

	@Autowired
	CatalogoService<Empresa> empresaService;

	@Autowired
	CatalogoService<Linea> lineaService;

	@Autowired
	SerieService serieService;

	@Autowired
	ProductoService productoService;
	
	@Autowired
	CatalogoService<Marca> marcaService;
	
	@Autowired
	CentroFederalService centroFederalService;

	@Autowired
	RolService rolService;

	@Autowired
	UsuarioService usuarioService;

	public void test() {
		for (int i = 0; i < 100; i++) {
			Empresa empresa = new Empresa();
			empresa.setClave("EM" + i);
			empresa.setDescripcion("Empresa Desc" + i);
			empresaService.save(empresa);

			EstadoCivil estadoCivil = new EstadoCivil();
			estadoCivil.setClave("EC" + i);
			estadoCivil.setDescripcion("Estado Civil Desc" + i);
			estadoCivilService.save(estadoCivil);

			GradoEstudios gradoEstudios = new GradoEstudios();
			gradoEstudios.setClave("GE" + i);
			gradoEstudios.setDescripcion("Grado de Estudios Desc" + i);
			gradoEstudiosService.save(gradoEstudios);

			TipoContratacion tipoContratacion = new TipoContratacion();
			tipoContratacion.setClave("TC" + i);
			tipoContratacion.setDescripcion("Tipo de Contratación Desc" + i);
			tipoContratacionService.save(tipoContratacion);

			TipoIngresoPPL tipoIngresoPPL = new TipoIngresoPPL();
			tipoIngresoPPL.setClave("TI" + i);
			tipoIngresoPPL.setDescripcion("Tipo de Ingreso PPL Desc" + i);
			tipoIngresoPPLService.save(tipoIngresoPPL);

			TipoPerfilPPL tipoPerfilPPL = new TipoPerfilPPL();
			tipoPerfilPPL.setClave("TP" + i);
			tipoPerfilPPL.setDescripcion("Tipo de Perfil PPL Desc" + i);
			tipoPerfilPPLService.save(tipoPerfilPPL);

			Parentesco parentesco = new Parentesco();
			parentesco.setClave("P" + i);
			parentesco.setDescripcion("Parentesco Desc" + i);
			parentescoService.save(parentesco);

			Banco banco = new Banco();
			banco.setClave("BNC" + i);
			banco.setDescripcion("Banco Desc" + i);
			bancoService.save(banco);

			Linea linea = new Linea();
			linea.setClave("LN" + i);
			linea.setDescripcion("Linea Desc" + i);
			lineaService.save(linea);

			/*Serie serie = new Serie();
			serie.setClave("SR" + i);
			serie.setDescripcion("Serie Desc" + i);
			serieService.save(serie);*/

			Marca marca = new Marca();
			marca.setClave("MR" + i);
			marca.setDescripcion("Marca Desc" + i);
			marcaService.save(marca);

			CentroFederal centroFederal = new CentroFederal();
			centroFederal.setClave("clave" + i);
			centroFederal.setNombre("Centro Federal" + i);
			centroFederal.setZona("ZONA" + i);
			centroFederal.setCalle("calle" + i);
			centroFederal.setNumExterior("numExterior"+i);
			centroFederal.setNumInterior("numInterior"+i);
			centroFederal.setColonia("colonia"+i);
			centroFederal.setDelegacionMunicipio("delegacionMunicipio"+i);
			centroFederal.setLocalidad("localidad"+i);			
			centroFederal.setEstado("estado" + i);
			centroFederal.setPais("pais"+i);		
			centroFederal.setCodigoPostal(String.format("%05d", i));
			centroFederal.setCoordenadas("coords" + i);
			centroFederalService.save(centroFederal);

			for (int j = 0; j < 3; j++) {
				ModuloCentroFederal moduloCentroFederal = new ModuloCentroFederal();
				moduloCentroFederal.setCentroFederal(centroFederal);
				moduloCentroFederal.setClave("clave" + j + "-" + i);
				moduloCentroFederal.setDescripcion(centroFederal.getNombre() + " Modulo Desc" + j);
				moduloCentroFederalService.save(moduloCentroFederal);
			}

			Usuario usuario = new Usuario();
			usuario.setCentroFederal(centroFederal);
			usuario.setEstadoCivil(estadoCivil);
			usuario.setGradoEstudios(gradoEstudios);
			usuario.setTipoContratacion(tipoContratacion);
			usuario.setEmpresa(empresa);

			usuario.setNombre("Israel " + i);
			usuario.setApellidoPaterno("Anaya");
			usuario.setApellidoMaterno("Salazar");
			usuario.setPassword("XXX");
			usuario.setFechaNacimiento(new Date());
			usuario.setSexo('H');

			usuarioService.save(usuario);
		}

		for (Rol rol : Roles.getRoles()) {
			try {
				rolService.findOne(rol.getId());
			} catch (Exception ex) {
				rolService.save(rol);
			}
		}

	}

	@Autowired
	PPLService pplService;

	void ppls() {

		List<Parentesco> parentescos = parentescoService.findAll();
		List<CentroFederal> centros = centroFederalService.findAll();
		List<ModuloCentroFederal> modulos = moduloCentroFederalService.findByCentroFederal(centros.get(0));

		for (int i = 1; i < 100; i++) {
			PPL ppl = new PPL();
			ppl.setNombre("Joaquín Archivaldo " + i);
			ppl.setApellidoPaterno("Guzmán");
			ppl.setApellidoMaterno("Loera");
			ppl.setFechaNacimiento(new Date());
			ppl.setSexo('H');
			ppl.setCiPPL("ciPPL" + i);
			ppl.setApodo("CHAPO" + i);
			ppl.setFechaIngreso(new Date());
			ppl.setDormitorio("Ratonera A" + i);
			ppl.setCentroFederal(centros.get(0));
			ppl.setModulo(modulos.get(0));

			DatosFiscalesPPL datosFiscales = new DatosFiscalesPPL();
			datosFiscales.setRazonSocial("COCAINOMANOS S.A. DE C.V.");
			datosFiscales.setEmail("email" + i + "@na-at.com.mx");
			datosFiscales.setCalle("calle" + i);
			datosFiscales.setNumExterior("numExterior"+i);
			datosFiscales.setNumInterior("numInterior"+i);
			datosFiscales.setColonia("colonia"+i);
			datosFiscales.setDelegacionMunicipio("delegacionMunicipio"+i);
			datosFiscales.setLocalidad("localidad"+i);			
			datosFiscales.setEstado("estado" + i);
			datosFiscales.setPais("pais"+i);		
			datosFiscales.setCodigoPostal(String.format("%05d", i));
			ppl.setDatosFiscales(datosFiscales);

			ReferenciaPPL referencia = new ReferenciaPPL();
			referencia.setNombre("Kate " + i);
			referencia.setApellidoPaterno("Castillo-Negrete");
			referencia.setApellidoMaterno("Trillo");
			referencia.setFechaNacimiento(new Date());
			referencia.setParentesco(parentescos.get(0));
			referencia.setSexo('M');

			ppl.getReferencias().add(referencia);

			pplService.save(ppl);
		}
	}

	@Test
	public void contextLoads() {

		this.test();
		ppls();
	}

}
