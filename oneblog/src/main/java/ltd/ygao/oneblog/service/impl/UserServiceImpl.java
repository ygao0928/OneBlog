package ltd.ygao.oneblog.service.impl;


import ltd.ygao.oneblog.mapper.UserMapper;
import ltd.ygao.oneblog.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/15 22:26
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    /**
     * 查出所有的用户
     *
     * @return
     */
    public List<User> findAll() {
        System.out.println(userMapper.findAll());
        return userMapper.findAll();
    }

    @Override
    public List<User> checkUserByName(String userName) {
        List<User> ul = userMapper.checkUserByName(userName);
        return ul;
    }


}
