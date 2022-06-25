package Service.impl;

import Bean.User;
import Dao.UserMapper;
import Service.UserService;
import Utils.PasswordUtil;
import Utils.SystemConstant;
import Utils.UUIDUitls;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int addUser(User user) {
        //自动生成盐值
        user.setSalt(UUIDUitls.randomUUID());//shiro安全验证框架
        //密码加密
        user.setPassword(PasswordUtil.md5(user.getPassword(), user.getSalt(), SystemConstant.PASSWORD_COUNT));
        return userMapper.addUser(user);
    }

    @Override
    public User findUserByName(String loginName) {
        return userMapper.findUserByName(loginName);
    }

    @Override
    public User login(String loginName, String password) {
        //调用查询用户信息的方法
        User loginUser = userMapper.findUserByName(loginName);
        //判断对象是否为空
        if (loginUser != null) {
            //密码加密
            String newPassword = PasswordUtil.md5(password, loginUser.getSalt(), SystemConstant.PASSWORD_COUNT);
            //比较密码是否相等
            if (loginUser.getPassword().equals(newPassword)) {
                return loginUser;
            }
        }
        return null;
    }
}
