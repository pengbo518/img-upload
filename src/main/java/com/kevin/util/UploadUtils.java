package com.kevin.util;

import java.io.File;

public class UploadUtils {

    // 项目根路径下的目录 SpringBoot static
    public final static String IMG_PATH_PREFIX = "/upload/images/";



    /**
     * 上传文件的存放 "文件夹" 路径
     * @return
     */
    public static File getImgDirFile(){
        String fileDirPath = "src/main/resources/static/" + IMG_PATH_PREFIX;
        File fileDir = new File(fileDirPath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        return fileDir;
    }

}
