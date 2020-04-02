package ltd.ygao.oneblog.service.impl;


import ltd.ygao.oneblog.mapper.UserMapper;
import ltd.ygao.oneblog.service.UserService;
import ltd.ygao.oneblog.utils.RedisUtils;
import ltd.ygao.oneblog.utils.ResponseObject;
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
    @Autowired
    RedisUtils redisUtils;

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


}
