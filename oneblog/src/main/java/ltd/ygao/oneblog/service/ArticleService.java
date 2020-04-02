package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:16
 */
public interface ArticleService {
    /**
     *增
     * @param article
     * @return
     */
    Integer addArticle(Article article);

    /**
     * 删除
     * @param artId
     * @return
     */
    Integer deleteArticleById(@Param("artId")int artId);

    /**
     * 跟新
     * @param article
     * @return
     */
    Integer updateArticle(Article article);

    /**
     *查依据id查文章
     * @param artId
     * @return
     */
    List<Article> selectArticleById(@Param("artId")int artId);

    /**
     * 依据当前登录者查出所有的文案
     * @param userId
     * @return
     */
    List<Article> selectArticleByfromer(@Param("userId")int userId);


}
