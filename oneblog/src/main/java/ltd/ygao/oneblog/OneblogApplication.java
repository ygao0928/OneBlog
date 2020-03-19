package ltd.ygao.oneblog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "ltd.ygao.oneblog.mapper")
public class OneblogApplication {

    public static void main(String[] args) {
        SpringApplication.run(OneblogApplication.class, args);
    }

}
