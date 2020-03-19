package ltd.ygao.oneblog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import ltd.ygao.oneblog.service.UserService;
import ltd.ygao.oneblog.utils.ResponseObject;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/15 19:35
 */
@Controller
@RequestMapping(value = "/admin", produces = {"application/json;charset=UTF-8"})
@CrossOrigin
@ResponseBody
@Api(value = "后台", tags = "")
public class AdminController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping("/login")
    @ApiOperation(value = "'登录'", httpMethod = "POST")
    public ResponseObject<Object> adminIndex(@ApiParam(value = "用户名", required = true)
                                             @RequestParam(value = "username") String username, @ApiParam(value = "密码", required = true)
                                             @RequestParam(value = "password") String password) {
        List<User> ul = userService.checkUserByName(username);
        return new ResponseObject<>(ul);
    }
}
