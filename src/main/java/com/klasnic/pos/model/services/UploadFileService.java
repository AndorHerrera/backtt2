package com.klasnic.pos.model.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service

public class UploadFileService {

    private String upload_folder = ".//src//main//resources//files//";

    public void saveFile(MultipartFile file,String url) throws IOException {
        if(!file.isEmpty()){
            byte[] bytes = file.getBytes();
            Path path = Paths.get(upload_folder + url + "//" + file.getOriginalFilename());
            Files.write(path,bytes);
        }
    }
   
    public File readFile(String folder,String nameFile) throws IOException {
    		File archivo = new File (upload_folder + folder + "//" + nameFile);
    		return archivo;
    }   
    
}
