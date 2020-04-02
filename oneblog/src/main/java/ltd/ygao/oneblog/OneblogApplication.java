package ltd.ygao.oneblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan(basePackages = "ltd.ygao.oneblog.mapper")
@EnableCaching//开启redis
public class OneblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneblogApplication.class, args);
    }

}
