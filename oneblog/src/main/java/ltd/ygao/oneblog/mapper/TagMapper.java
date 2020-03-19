package ltd.ygao.oneblog.mapper;

import ltd.ygao.oneblog.pojo.Tag;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/19 11:06
 */
@Mapper
public interface TagMapper {
List<Tag> findAll();
}
