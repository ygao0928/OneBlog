package ltd.ygao.oneblog.mapper;

import ltd.ygao.oneblog.pojo.ArticleColumn;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/20 17:33
 */
@Mapper
public interface ArtColumnMapper {
List<ArticleColumn> findAll();
}
