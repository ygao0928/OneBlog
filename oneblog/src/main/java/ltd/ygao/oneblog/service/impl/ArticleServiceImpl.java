package ltd.ygao.oneblog.service.impl;

import ltd.ygao.oneblog.mapper.ArticleMapper;
import ltd.ygao.oneblog.pojo.Article;
import ltd.ygao.oneblog.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Callable;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:28
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Override
    public Integer addArticle(Article article) {

        return articleMapper.addArticle(article);
    }
}
class testthead implements Callable {

    @Override

       public Object call() throws Exception {
        return null;
    }
}
class testthread extends Thread{

}
