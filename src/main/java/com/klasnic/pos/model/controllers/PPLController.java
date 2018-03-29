package com.klasnic.pos.model.controllers;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klasnic.pos.model.catalogs.PPL;
import com.klasnic.pos.model.services.PPLService;
import com.klasnic.pos.process.PPLLoadFromFile;

@RestController
@RequestMapping("/services/cat/ppl")
@CrossOrigin(origins = "*")
public class PPLController extends ActivableController<PPLService, PPL> {

	private static final Logger logger = LoggerFactory.getLogger(PPLController.class);

	@Autowired
	PPLLoadFromFile pplLoadFromFile;

	public PPLController(PPLService service) {
		super(service);

	}

	@Override
	protected List<String> getIgnorePropertiesForUpdate() {
		List<String> ignoreProperties = super.getIgnorePropertiesForUpdate();
		// ignoreProperties.add("password");
		return ignoreProperties;
	}

	@RequestMapping(value = URL_BASE + "uploadfile", method = RequestMethod.POST)
	public ResponseEntity<Resource> uploadFileHandler(@RequestPart("file") MultipartFile file)
			throws IOException {

		
		logger.info("File received: " + file.getOriginalFilename());

		ByteArrayOutputStream errorOutputStream = new ByteArrayOutputStream();
		pplLoadFromFile.load(file, errorOutputStream);
		
		// Pruebas para local en caso de tener problemas para generar el download
		/*FileOutputStream fileErrors = new FileOutputStream("C:\\TEMP\\errores.xlsx");
		fileErrors.write(errorOutputStream.toByteArray());
		fileErrors.flush();
		fileErrors.close();*/
				
        ByteArrayResource resource = new ByteArrayResource(errorOutputStream.toByteArray());

        return ResponseEntity.ok()
                .contentLength(errorOutputStream.size())
                .header("Content-Disposition", "attachment; filename=PPLsErrores.xlsx")
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"))
                .body(resource);
        
		
		
	}
}
