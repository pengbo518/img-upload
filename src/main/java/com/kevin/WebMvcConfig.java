package com.kevin;

import com.kevin.util.UploadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    /**
     * 解决上传图片到项目路径下不能实时访问，需要重启项目BUG；
     * 服务器的保护措施导致的，服务器不能对外部暴露真实的资源路径，
     * 需要配置虚拟路径映射访问。
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 获取文件的真实路径 img-upload 代表项目工程名，需要更改
        String path = System.getProperty("user.dir")+"\\src\\main\\resources\\static" + UploadUtils.IMG_PATH_PREFIX;
        String os = System.getProperty("os.name");
        if (os.toLowerCase().startsWith("win")) {
            registry.addResourceHandler("/upload/images/**")
                    .addResourceLocations("file:" + path);
        }else{
            // linux 和 mac 系统
            registry.addResourceHandler("/upload/images/**")
                    .addResourceLocations("file:" + path);
        }
        super.addResourceHandlers(registry);
    }

}
