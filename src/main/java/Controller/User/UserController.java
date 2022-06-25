package Controller.User;

import Bean.User;
import Service.UserService;
import Utils.SystemConstant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping("/register")
    public String register(User user) {
        //创建Map集合,保存结果信息
        Map<String, Object> map = new HashMap<>();
        //调用注册的方法
        if (userService.addUser(user) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "恭喜你注册成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "注册失败");
        }
        return JSON.toJSONString(map);
    }


    /**
     * 检查用户名是否存在
     *
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/checkName")
    public String checkName(String loginName) {
        //创建Map集合,保存结果信息
        Map<String, Object> map = new HashMap<>();
        //调用根据用户查询用户信息的方法
        if (userService.findUserByName(loginName) != null) {
            map.put(SystemConstant.EXIST, true);
            map.put(SystemConstant.MESSAGE, "用户名已被使用请重新输入");
        } else {
            map.put(SystemConstant.EXIST, false);
        }
        return JSON.toJSONString(map);
    }


    /**
     * 登录
     *
     * @param loginName
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public String login(String loginName, String password, HttpSession session) {
        //创建Map集合,保存结果信息
        Map<String, Object> map = new HashMap<>();
        //调用登录方法
        User loginUser = userService.login(loginName, password);
        //判断对象是否为空
        if (loginUser != null) {
            map.put(SystemConstant.SUCCESS, true);
            loginUser.setPassword(null);//清空
            //保存用户信息到会话中
            session.setAttribute(SystemConstant.FRONT_LOGIN_USER, loginUser);
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE,"用户名或密码错误请重新输入!");
        }
        return JSON.toJSONString(map);
    }


}
