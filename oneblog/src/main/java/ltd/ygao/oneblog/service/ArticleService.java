package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.Article;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:16
 */
public interface ArticleService {
    /**
     *
     * @param article
     * @return
     */
    Integer addArticle(Article article);
}
