package Service.impl;

import Bean.RoomType;
import Dao.RoomTypeMapper;
import Service.RoomTypeService;
import Vo.RoomTypeVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomTypeServiceimpl implements RoomTypeService {
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public List<RoomType> findRoomTypeList(RoomTypeVo roomTypeVo) {
        return roomTypeMapper.findRoomTypeList(roomTypeVo);
    }

    @Override
    public int addRoomType(RoomType roomType) {
        //可用房间数默认是全部的房间数量
        roomType.setAvilablenum(roomType.getRoomnum());
        roomType.setLivednum(0);//已入住房间数量
        return roomTypeMapper.addRoomType(roomType);
    }

    @Override
    public int updateRoomType(RoomType roomType) {
        //可用房间数默认是全部的房间数量
        roomType.setAvilablenum(roomType.getRoomnum());
        roomType.setLivednum(0);//已入住房间数量
        return roomTypeMapper.updateRoomType(roomType);
    }
}
