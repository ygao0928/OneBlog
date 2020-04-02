package ltd.ygao.oneblog.service;

import ltd.ygao.oneblog.pojo.User;
import ltd.ygao.oneblog.utils.ResponseObject;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/17 10:37
 */
public interface UserService {
    /**
     * 查找所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 检查用户名
     * @param userName
     * @return
     */
    ResponseObject checkUserByName(String userName);

    /**
     * 查
     * @return
     */
    List<User> findAllUser();

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    Integer updateUser(User user);

}
