package ltd.ygao.oneblog;

import ltd.ygao.oneblog.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class OneblogApplicationTests {
@Autowired
    ArticleService articleService;

    void article(){
    System.out.println(articleService.FindAllArticle());
}


}
