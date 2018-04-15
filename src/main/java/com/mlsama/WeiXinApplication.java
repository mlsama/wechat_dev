package com.mlsama;

import com.mlsama.configurer.SpringConfiguration;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

/**
 * 描述:层启动类
 *
 * @Author:mlsama 2018/4/13 18:57
 */
//@ImportResource(locations={"classpath:applicationContext-dubbo.xml"})
@SpringBootApplication(scanBasePackages={"com.mlsama"})
//引入配置类
@Import(SpringConfiguration.class)
public class WeiXinApplication {

    public static void main(String[] args) {
        /** 创建SpringApplication对象 */
        SpringApplication springApplication =
                new SpringApplication(WeiXinApplication.class);
        /** 设置横幅关闭 */
        springApplication.setBannerMode(Mode.OFF);
        /** 运行 */
        springApplication.run(args);
    }
}
