package ltd.ygao.oneblog.controller;

import ltd.ygao.oneblog.service.impl.UserServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author Kevin
 * @version 1.0
 * @date 2020/3/11 23:01
 */
@Controller
public class HelloController {
    @Autowired
   private UserServiceImpl userService;
    @RequestMapping("/hello")
    @ResponseBody
    public String  hello(Model model){
       List<User> gg= userService.findAll();
       String dd=gg.toString();
        System.out.println(gg+"GG");
        model.addAttribute("login",gg);
        return  dd;
    }
}
