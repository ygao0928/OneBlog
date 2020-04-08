package ltd.ygao.oneblog.mapper;

import ltd.ygao.oneblog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/18 15:31
 */
@Mapper
@Repository
public interface ArticleMapper {
    /**
     *
     * @return
     */
    Integer addArticle(Article article);

    /**
     *
     * @param id
     * @return
     */
    Integer deleteArticleById(@Param("artId")int id);
    List<Article> selectArticleById(@Param("artId") int artId);
    List<Article> selectArticleByfromer(@Param("userId")int userId);
    List<Article> FindAllArticle();
    List<Article> selectPage();
    Integer updateArticle(Article article);
}
