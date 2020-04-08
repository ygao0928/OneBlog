package ltd.ygao.oneblog.mapper;

import ltd.ygao.oneblog.pojo.User;
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
    /**
     *
     * @param userName
     * @return
     */
    List<User> checkUserByName(@Param("userName")String userName);

    /**
     *
     * @return
     */
    List<User> findAllUser();

    /**
     *
     * @param user
     * @return
     */
    Integer updateUser(User user);

    /**
     *
     * @param user
     * @return
     */
    Integer insertUser(User user);
}
