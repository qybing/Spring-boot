package com.jovan.controller;

import com.jovan.utils.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class UploadController {
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "C://Users//file//";

    @GetMapping("/")
    public String index() {
        return "login";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
//        System.out.println(file);
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
       /*     Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            File file1 = new File(String.valueOf(path),file.getOriginalFilename());
            file.transferTo(file1);
*/
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            System.out.println("具体的路径:"+path);
            System.out.println(Files.write(path, bytes));
            ExcelUtil excelUtil = new ExcelUtil();
            excelUtil.readfile(path.toString());
            redirectAttributes.addFlashAttribute("message",
                    "你已经成功上传'" + file.getOriginalFilename() + "'");

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {

        return "uploadStatus";
    }

}