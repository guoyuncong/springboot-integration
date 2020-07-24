package com.springboot.upload.upload;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
public class FileUploadController {

    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");

    @PostMapping("/upload")
    public String upload(MultipartFile uploadFile, HttpServletRequest request) throws IOException {
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        String format = simpleDateFormat.format(new Date());
        File folder = new File(realPath + format);
        if (!folder.isDirectory()) {
            folder.mkdirs();
        }
        String oldName = uploadFile.getOriginalFilename();
        String newName = UUID.randomUUID().toString() + oldName.substring(oldName.lastIndexOf("."));
        uploadFile.transferTo(new File(folder, newName));
        String filePath = request.getScheme() +"://" + request.getServerName() + ":" +
                request.getServerPort() + "/uploadFile/" + format + newName;
        return filePath;
    }
}
