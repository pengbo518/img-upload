package com.kevin.controller;

import com.kevin.util.UploadUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@Slf4j
public class UploadController {
    private String view_index = "index";

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("img") MultipartFile img) {
        if (img == null) {
            return null;
        }
        // 保存图片
        String originalFilename = img.getOriginalFilename();
        // 文件后缀名
        String prefix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = UUID.randomUUID().toString().replace("-", "") + "." + prefix;
        File fileUrl = UploadUtils.getImgDirFile();
        File destImage = new File(fileUrl.getAbsolutePath(), fileName);
        log.warn("图片保存地址为：" + destImage);
        try {
            img.transferTo(destImage);
            return UploadUtils.IMG_PATH_PREFIX + fileName;
        } catch (IOException e) {
            log.error("图片保存失败", e);
        }
        return null;
    }

    @GetMapping("/index")
    public String index(){
        return view_index;
    }

}
