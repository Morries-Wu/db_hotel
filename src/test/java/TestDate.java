import Dao.RoleMapper;
import Service.RoomService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TestDate {

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    RoomService roomService;

    @Test
    public void outmyDate() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        System.out.println(df.format(new Date()));
    }


    @Test
    public void TestMap() {
        List<Map<String, Object>> roleListByMap = roleMapper.findRoleListByMap();
        System.out.println(roleListByMap);
    }


}
