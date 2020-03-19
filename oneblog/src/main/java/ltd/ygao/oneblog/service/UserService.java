package ltd.ygao.oneblog.service;

import org.apache.catalina.User;

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
    List<User>  checkUserByName(String userName);

}
