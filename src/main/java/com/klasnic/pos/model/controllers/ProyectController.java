package com.klasnic.pos.model.controllers;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

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
import com.klasnic.pos.model.repositories.ProyectRepository;
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
	
	@Autowired
    private ProyectRepository proyectService;
	
	@GetMapping("user/{id}")
	public List<Proyect> proyectsByUser(@PathVariable("id") String id) {
		return proyectService.findByIdUser(id);
	}
	
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
			directorio=new File("/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+url+"/"+id); 
		}else {
			directorio=new File("/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+id); 
		}
		directorio.mkdir(); 
	    return "Directorio Creado";
	}
	
	
	
	@PostMapping("sonar/file")
	 public String sonarArchivo(@RequestParam("key") String key,@RequestParam("name") String name,
			 					@RequestParam("version") String version,@RequestParam("path") String path) throws IOException {
		String ruta = "/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+key+"/sonar-project.properties";
		File archivo = new File(ruta);
		BufferedWriter bw;
		if(archivo.exists()) {
		      bw = new BufferedWriter(new FileWriter(archivo));
		      bw.write("sonar.projectKey="+key+"\n" + 
		      		  "sonar.projectName="+name+"\n"+
		      		  "sonar.projectVersion="+version+"\n" + 
		      		  "sonar.sources=/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+key+"\n" + 
		      		  "sonar.sourceEncoding=UTF-8" 
		    		      );
			  bw.close();		
			  return "Archivo Modificado";
		} else {
		      bw = new BufferedWriter(new FileWriter(archivo));
		      bw.write("sonar.projectKey="+key+"\n" + 
		      		  "sonar.projectName="+name+"\n"+
		      		  "sonar.projectVersion="+version+"\n" + 
		      		  "sonar.sources=/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+key+"\n" + 
		      		  "sonar.sourceEncoding=UTF-8" 
		    		      );			  
		      bw.close();		
			  return "Archivo Creado";
		}
	}
	
	

	@PostMapping("sonar/command")
	 public String sonarComando(@RequestParam("comando") String comando) {
		String response = executeCommand(comando);
		System.out.println(comando);
	    return response + " comando:"+comando;
	}
	
	@GetMapping("sonar/scanea/{id}")
	 public String sonarScanea(@PathVariable("id") String id) {
		String response = "";
		if(id!=null) {
			String comando = "/usr/local/Cellar/sonar-scanner/3.1.0.1141/bin/sonar-scanner -Dproject.settings=/Users/angel/Desktop/Respaldo_de_COdio/Klasnic_web_server/pos-server/src/main/resources/files/"+id+"/sonar-project.properties";
			System.out.println("Estes es el comando:"+comando);
			response = executeCommand(comando) + " Comando:" + comando ;
		} else {
			executeCommand("Proyecto no encontrado");
			response = "Archivo no encontrado";
		}
		return response;	
	}
	
	private String executeCommand(String command) {
		StringBuffer output = new StringBuffer();
		Process p;
		try {
			p = Runtime.getRuntime().exec(command);
			p.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
             String line = "";			
			while ((line = reader.readLine())!= null) {
				output.append(line + "\n");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return output.toString();
	}
	
	
	@GetMapping("sonar/metricas/{id}")
	 public String sonarPeticion(@PathVariable("id") String id) {
        URL url;
		try {
            String path = "http://localhost:9000/api/measures/component?componentKey="+id+"&metricKeys=alert_status%2Cquality_gate_details%2Cbugs%2Cnew_bugs%2Creliability_rating%2Cnew_reliability_rating%2Cvulnerabilities%2Cnew_vulnerabilities%2Csecurity_rating%2Cnew_security_rating%2Ccode_smells%2Cnew_code_smells%2Csqale_rating%2Cnew_maintainability_rating%2Csqale_index%2Cnew_technical_debt%2Ccoverage%2Cnew_coverage%2Cnew_lines_to_cover%2Ctests%2Cduplicated_lines_density%2Cnew_duplicated_lines_density%2Cduplicated_blocks%2Cncloc%2Cncloc_language_distribution%2Cprojects%2Cnew_lines";
            url = new URL(path);			
            URLConnection con = url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    con.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
               return linea;
            }
        } catch (IOException e) {
    			return e.getMessage();

        }
		return null;
	}
	
	@GetMapping("sonar/medidas/{id}")
	 public String sonarPeticionMedidas(@PathVariable("id") String id) {
       URL url;
		try {
           String path = "http://localhost:9000/api/measures/component?additionalFields=periods&componentKey="+id+"&metricKeys=new_technical_debt%2Cblocker_violations%2Cbugs%2Cburned_budget%2Cbusiness_value%2Cclasses%2Ccode_smells%2Ccognitive_complexity%2Ccomment_lines%2Ccomment_lines_density%2Cbranch_coverage%2Cnew_branch_coverage%2Cconditions_to_cover%2Cnew_conditions_to_cover%2Cconfirmed_issues%2Ccoverage%2Cnew_coverage%2Ccritical_violations%2Ccomplexity%2Cdirectories%2Cduplicated_blocks%2Cnew_duplicated_blocks%2Cduplicated_files%2Cduplicated_lines%2Cduplicated_lines_density%2Cnew_duplicated_lines%2Cnew_duplicated_lines_density%2Ceffort_to_reach_maintainability_rating_a%2Cfalse_positive_issues%2Cfiles%2Cfunctions%2Cgenerated_lines%2Cgenerated_ncloc%2Cinfo_violations%2Cviolations%2Cline_coverage%2Cnew_line_coverage%2Clines%2Cncloc%2Clines_to_cover%2Cnew_lines_to_cover%2Csqale_rating%2Cnew_maintainability_rating%2Cmajor_violations%2Cminor_violations%2Cnew_blocker_violations%2Cnew_bugs%2Cnew_code_smells%2Cnew_critical_violations%2Cnew_info_violations%2Cnew_violations%2Cnew_lines%2Cnew_major_violations%2Cnew_minor_violations%2Cnew_vulnerabilities%2Copen_issues%2Cprojects%2Calert_status%2Creliability_rating%2Cnew_reliability_rating%2Creliability_remediation_effort%2Cnew_reliability_remediation_effort%2Creopened_issues%2Csecurity_rating%2Cnew_security_rating%2Csecurity_remediation_effort%2Cnew_security_remediation_effort%2Cskipped_tests%2Cstatements%2Cteam_size%2Csqale_index%2Csqale_debt_ratio%2Cnew_sqale_debt_ratio%2Cuncovered_conditions%2Cnew_uncovered_conditions%2Cuncovered_lines%2Cnew_uncovered_lines%2Ctest_execution_time%2Ctest_errors%2Ctest_failures%2Ctest_success_density%2Ctests%2Cvulnerabilities%2Cwont_fix_issues";
           url = new URL(path);			
           URLConnection con = url.openConnection();
           BufferedReader in = new BufferedReader(new InputStreamReader(
                   con.getInputStream()));
           String linea;
           while ((linea = in.readLine()) != null) {
              return linea;
           }
       } catch (IOException e) {
   			return e.getMessage();

       }
		return null;
	}
	
	@GetMapping("sonar/folders/{id}")
	 public String sonarPeticionFolders(@PathVariable("id") String id) {
      URL url;
		try {
          String path = "http://localhost:9000/api/measures/component_tree?ps=100&s=qualifier%2Cname&baseComponentKey="+id+"&metricKeys=ncloc%2Ccode_smells%2Cbugs%2Cvulnerabilities%2Ccoverage%2Cduplicated_lines_density%2Calert_status&strategy=children";
          url = new URL(path);			
          URLConnection con = url.openConnection();
          BufferedReader in = new BufferedReader(new InputStreamReader(
                  con.getInputStream()));
          String linea;
          while ((linea = in.readLine()) != null) {
             return linea;
          }
      } catch (IOException e) {
  			return e.getMessage();

      }
		return null;
	}
	
	@GetMapping("sonar/issues/{id}")
	 public String sonarPeticionIssues(@PathVariable("id") String id) {
     URL url;
		try {
         String path = "http://localhost:9000/api/issues/search?componentKeys="+id+"&s=FILE_LINE&resolved=false&ps=100&facets=severities%2Ctypes&additionalFields=_all";
         url = new URL(path);			
         URLConnection con = url.openConnection();
         BufferedReader in = new BufferedReader(new InputStreamReader(
                 con.getInputStream()));
         String linea;
         while ((linea = in.readLine()) != null) {
            return linea;
         }
     } catch (IOException e) {
 			return e.getMessage();

     }
		return null;
	}
	
	
}