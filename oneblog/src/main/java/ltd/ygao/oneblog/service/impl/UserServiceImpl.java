package ltd.ygao.oneblog.service.impl;


import ltd.ygao.oneblog.mapper.UserMapper;
import ltd.ygao.oneblog.pojo.User;
import ltd.ygao.oneblog.service.UserService;
import ltd.ygao.oneblog.utils.RedisUtils;
import ltd.ygao.oneblog.utils.ResponseObject;

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
    @Autowired
    RedisUtils redisUtils;

    /**
     * 查出所有的用户
     *
     * @return
     */

    @Override
    public ResponseObject checkUserByName(String userName) {
        ResponseObject resp = new ResponseObject();
        if (redisUtils.get(userName) != null) {
            System.out.println("在redis里面找到");
            resp.setData(redisUtils.get("userName"));
        } else {
            System.out.println("到数据库里找");
            List<User> ul = userMapper.checkUserByName(userName);
            resp.setData(ul);
            redisUtils.set(userName, ul, 10);
        }
        return resp;
    }

    @Override
    public List<ltd.ygao.oneblog.pojo.User> findAllUser() {
        return userMapper.findAllUser();
    }

    @Override
    public Integer updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public Integer insertUser(User user) {
        return userMapper.insertUser(user);
    }


}
