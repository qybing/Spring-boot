package com.tiye.IntelligentClass.service;

import com.tiye.IntelligentClass.common.APIResult;
import com.tiye.IntelligentClass.pcController.AssetsConfigController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class UpfileService {
    private static final Logger log= LoggerFactory.getLogger(UpfileService.class);

    @Value("${mypros.uploadPath}")
    private static String uploadPath;

    @Autowired
    private Environment env;
    public String upFile(MultipartFile file) {
        String newFileName=null;
        try {
            String fileName = file.getOriginalFilename();// 获取文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 获取文件的后缀名
            newFileName = UUID.randomUUID().toString() + suffixName;
            String filePath = env.getProperty("mypros.uploadPath"); // 文件上传后的路径
            File dest = new File(filePath + newFileName);
            if (!dest.getParentFile().exists()) { //检测是否存在目录
            dest.getParentFile().mkdirs();
        }

            file.transferTo(dest);
        } catch (IllegalStateException e) {
            log.error(e.getMessage(),e);

        } catch (IOException e) {
            log.error(e.getMessage(),e);
        }
        return env.getProperty("mypros.filePrefix") + "/" + newFileName;
    }
}
