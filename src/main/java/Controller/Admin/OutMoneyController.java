package Controller.Admin;

import Bean.Checkin;
import Service.OutMoneyService;
import Utils.DataGridViewResult;
import Utils.SystemConstant;
import Vo.CheckinVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/outMoney")
public class OutMoneyController {
    @Autowired
    private OutMoneyService outMoneyService;

    @RequestMapping("/list")
    public DataGridViewResult list(CheckinVo checkinVo) {
        PageHelper.startPage(checkinVo.getPage(), checkinVo.getLimit());
        //调用查询入住列表方法
        List<Checkin> checkinList = outMoneyService.findCheckOutList(checkinVo);
        //创建分页对象
        PageInfo<Checkin> pageInfo = new PageInfo<>(checkinList);
        //返回数据
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    @RequestMapping("/addOutMoney")
    public String addCheckin(Checkin checkin) {
        Map<String, Object> map = new HashMap<String, Object>();
        int id = outMoneyService.selectOutId(checkin.getOrdersid());
        //调用添加入住信息的方法
        if (outMoneyService.addCheckoutMoney(id,checkin.getMyprice()) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "添加成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "添加失败");
        }
        return JSON.toJSONString(map);
    }

}
