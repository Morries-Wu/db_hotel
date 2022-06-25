package Controller.Admin;

import Bean.Checkin;
import Bean.Checkout;
import Bean.Employee;
import Service.CheckoutService;
import Utils.DataGridViewResult;
import Utils.SystemConstant;
import Vo.CheckinVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/admin/checkout")
public class CheckoutAdminController {
    @Autowired
    private CheckoutService checkoutService;

    /**
     * 办理退房
     *
     * @param checkout
     * @return
     */
    @RequestMapping("/addCheckout")
    public String addCheckin(Checkout checkout, HttpSession session) {
        Map<String, Object> map = new HashMap<String, Object>();
        //获取当前登录用户
        Employee employee = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        checkout.setCreatedBy(employee.getId());
        //调用添加入住信息的方法
        if (checkoutService.addCheckout(checkout) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "退房成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "退房失败");
        }
        return JSON.toJSONString(map);
    }

    /*添加退房*/
    @RequestMapping("/updateCheckin")
    public String updateCheckin(Checkin checkin, HttpSession session) {
        Map<String, Object> map = new HashMap<>();
        Employee employee = (Employee) session.getAttribute(SystemConstant.LOGINUSER);
        checkin.setCreatedby(employee.getId());
        if (checkoutService.updateCheckOut(checkin) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "退房成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "退房失败");
        }
        return JSON.toJSONString(map);
    }



}
