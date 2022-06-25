package Controller.User;

import Bean.Floor;
import Bean.Room;
import Bean.RoomType;
import Dao.FloorMapper;
import Service.RoomService;
import Service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private FloorMapper floorMapper;
    @Autowired
    private RoomService roomService;

    @RequestMapping({"/", "/index.html"})
    public String index(Model model) {
        //调用查询房型列表的方法
        List<RoomType> roomTypeList = roomTypeService.findRoomTypeList(null);
        //调用查询所有楼层列表的方法
        List<Floor> floorList = floorMapper.findFloorList(null);
        //调用查询每个楼层的房间列表
        List<Room> roomList = roomService.findRoomListByFloorId();

        //将数据放到模型中
        model.addAttribute("roomTypeList", roomTypeList);
        model.addAttribute("floorList", floorList);
        model.addAttribute("roomList", roomList);
        return "forward:/home.jsp";
    }

    @RequestMapping("/welcome.html")
    public String desktop() {
        return "/welcome";
    }




}
