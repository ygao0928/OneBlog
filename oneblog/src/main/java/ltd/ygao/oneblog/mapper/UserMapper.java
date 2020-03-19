package ltd.ygao.oneblog.mapper;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/15 20:58
 */

@Mapper
@Repository
public interface UserMapper {

    /*查询所有用户*/
    List<User> findAll();

    /**
     *
     * @param userName
     * @return
     */
    List<User> checkUserByName(@Param("userName")String userName);
}
