package Controller.Admin;

import Utils.SystemConstant;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class SystemController {

    @RequestMapping("/login.html")
    public String login() {
        return "admin/login";
    }

    @RequestMapping("/home.html")
    public String home() {
        return "admin/home";
    }

    /**
     * @param session
     * @return
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute(SystemConstant.LOGINUSER);
        //重定向到登录页面
        return "redirect:/admin/login.html";
    }

    /**
     * 去到部门管理页面
     *
     * @return
     */
    @RequestMapping("/toDeptManager")
    public String toDeptManager() {
        return "admin/dept/deptManager";
    }

    /**
     * 去到角色管理页面
     *
     * @return
     */
    @RequestMapping("/toRoleManager")
    public String toRoleManager() {
        return "admin/role/roleManager";
    }

    /**
     * 去到员工管理页面
     *
     * @return
     */
    @RequestMapping("/toEmployeeManager")
    public String toEmployeeManager() {
        return "/admin/employee/employeeManger";
    }

    /**
     * 去到菜单管理页面
     *
     * @return
     */
    @RequestMapping("/toMenuManager")
    public String toMenuManager() {
        return "admin/menu/MenuManager";
    }

    /**
     * 去到楼层管理页面
     */
    @RequestMapping("/toFloorManager")
    public String toFloorManager() {
        return "admin/floor/floorManager";
    }

    /**
     * 去到房型管理页面
     *
     * @return
     */
    @RequestMapping("/toRoomTypeManager")
    public String toRoomTypeManager() {
        return "admin/roomType/roomTypeManager";
    }

    /**
     * 去到房间管理页面
     *
     * @return
     */
    @RequestMapping("/toRoomManager")
    public String toRoomManager() {
        return "admin/room/roomManager";
    }

    /**
     * 去到预定管理页面
     *
     * @return
     */
    @RequestMapping("/toOrdersManager")
    public String toOrdersManager() {
        return "admin/orders/ordersManager";
    }

    /**
     * 去到入住管理页面
     *
     * @return
     */
    @RequestMapping("/toCheckinManager")
    public String toCheckinManager() {
        return "/admin/checkin/checkinManager";
    }

    /**
     * 去到年度营业额报表统计分析页面
     *
     * @return
     */
    @RequestMapping("/toYearTotalPriceManager")
    public String toYearTotalPriceManager() {
        return "admin/charts/yearTotalPriceCharts";
    }

    /**
     * 去到月营业额报表统计分析页面
     *
     * @return
     */
    @RequestMapping("/toYearOfMonthCharts")
    public String toYearOfMonthCharts() {
        return "admin/charts/yearOfMonthCharts";
    }

    /**
     * 去到季度营业额报表统计分析页面
     *
     * @return
     */
    @RequestMapping("/toQuarterTotalPriceCharts")
    public String toQuarterTotalPriceCharts() {
        return "admin/charts/quarterTotalPriceCharts";
    }

    /**
     * 去到房型预订报表统计分析页面
     *
     * @return
     */
    @RequestMapping("/toRoomTypePieCharts")
    public String toRoomTypePieCharts() {
        return "admin/charts/roomTypePieCharts";
    }

    /**
     * 当日开房报表
     *
     * @return
     */
    @RequestMapping({"/toCurrentDateCheckinCharts"})
    public String toCurrentDateCheckinCharts() {
        return "admin/charts/currentDateCheckinCharts";
    }

    /*退款管理*/
    @RequestMapping("/toOutMoneyManage")
    public String toOutMoneyManage() {
        return "admin/checkin/outMoneyManage";
    }


}
