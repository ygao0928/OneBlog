package ltd.ygao.oneblog.controller;

import io.swagger.annotations.Api;
import ltd.ygao.oneblog.pojo.User;
import ltd.ygao.oneblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/4/2 22:07
 */
@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
@Api(value = "用户管理")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/updateUser", method = {RequestMethod.POST})
    public void updateUser(@RequestBody Map<String, Object> reqMap) {
        User user = new User();
        user.setUserName(reqMap.get("name").toString());
        user.setPassWord(reqMap.get("passWard").toString());
        Integer flag = userService.updateUser(user);
        System.out.println(flag);
    }
}
