package Service.impl;

import Bean.Floor;
import Dao.FloorMapper;
import Service.FloorService;
import Vo.FloorVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorServiceimpl implements FloorService {
    @Autowired
    private FloorMapper floorMapper;


    /**
     * 查询楼层列表
     *
     * @param floorVo
     * @return
     */
    @Override
    public List<Floor> findFloorList(FloorVo floorVo) {
        return floorMapper.findFloorList(floorVo);
    }

    @Override
    public int addFloor(Floor floor) {
        return floorMapper.addFloor(floor);
    }

    @Override
    public int updateFloor(Floor floor) {
        return floorMapper.updateFloor(floor);
    }
}
