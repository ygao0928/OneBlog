package ltd.ygao.oneblog.mapper;

import ltd.ygao.oneblog.pojo.Article;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
}
