package com.klasnic.pos.model.controllers;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.klasnic.pos.model.catalogs.Proyect;
import com.klasnic.pos.model.services.ProyectService;
import com.klasnic.pos.model.services.UploadFileService;

@RestController
@RequestMapping("/api/proyects")
@CrossOrigin(origins = "*")
public class ProyectController extends ActivableController<ProyectService, Proyect> {

	public ProyectController(ProyectService service) {
		super(service);
	}
	
	@Autowired
    private UploadFileService uploadFileService;
	
	@PostMapping("upload/file")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file,@RequestParam("url") String url) {
        if (file.isEmpty()) {
            return new ResponseEntity<Object>("Seleccionar un archivo", HttpStatus.OK);
        }
        try {
            uploadFileService.saveFile(file,url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ResponseEntity<Object>("Archivo subido correctamente", HttpStatus.OK);
    }
	
	@GetMapping("upload/file/{folder}/{name}")
	public ResponseEntity<Resource> download(@PathVariable("folder") String folder,@PathVariable("name") String name) throws IOException {
		File archivo = uploadFileService.readFile(folder,name);
	    InputStreamResource resource = new InputStreamResource(new FileInputStream(archivo));
	    String extension="";
	    String mimeType="";
	    String nombreArchivo=archivo.getName();
	    if(archivo.getName().lastIndexOf(".") != -1 && archivo.getName().lastIndexOf(".") != 0) {
    			extension = archivo.getName().substring(archivo.getName().lastIndexOf("."));
	    		if(extension.indexOf(".sql") != -1) {
	    			mimeType = "application/sql";
	    		}
	    }	    
	    InputStream is = new BufferedInputStream(new FileInputStream(archivo));
	    mimeType = URLConnection.guessContentTypeFromStream(is);
	    if(mimeType==null) {
	    		mimeType = "application/octet-stream";
	    }
	    HttpHeaders headers = new HttpHeaders(); 
	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+nombreArchivo);
	    return ResponseEntity.ok()
	            .headers(headers)
	            .contentLength(archivo.length())
	            .contentType(MediaType.parseMediaType(mimeType))
	            .body(resource);
	}
	
	
	@PostMapping("upload/folder/{id}")
	 public String uploadFolder(@PathVariable("id") String id,@RequestParam("url") String url) {
		File directorio=null;
		if(url.length()>0) {
			directorio=new File("/Users/angel/Desktop/Respaldo de COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+url+"/"+id); 
		}else {
			directorio=new File("/Users/angel/Desktop/Respaldo de COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+id); 
		}
		directorio.mkdir(); 
	    return "Directorio Creado";
	}
	
}