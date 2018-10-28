package com.kitabxana_sb;

import com.kitabxana_sb.rsclient.Result;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    static final String URL_HOSPITAL = "http://localhost:8080/Hospital-master/Rs/resource/list";

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) {
        RestTemplate template = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        ResponseEntity<Result> response = template.getForEntity(URL_HOSPITAL, Result.class);
        List<Result> list = (List<Result>) response.getBody().getList();
        list.forEach((rt) -> {
            System.out.println("result = " + rt.getHosp_name());
        });
        SpringApplication.run(Application.class, args);

    }
}
