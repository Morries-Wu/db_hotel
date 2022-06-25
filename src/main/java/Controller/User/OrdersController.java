package Controller.User;

import Bean.Orders;
import Service.OrdersService;
import Utils.SystemConstant;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    /**
     * 添加订单
     *
     * @param orders
     * @return
     */
    @RequestMapping("/addOrders")
    @ResponseBody
    public String addOrders(Orders orders) {
        Map<String, Object> map = new HashMap<>();
        //调用添加订单的方法
        if(ordersService.addOrders(orders)>0){
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "酒店添加成功");
        }else{
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "酒店添加失败");
        }
        return JSON.toJSONString(map);

    }


}
