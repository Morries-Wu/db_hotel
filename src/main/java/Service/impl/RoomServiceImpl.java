package Service.impl;

import Bean.Room;
import Dao.RoomMapper;
import Dao.RoomTypeMapper;
import Service.RoomService;
import Vo.RoomVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;

    @Override
    public List<Room> findRoomListByPage(RoomVo roomVo) {
        return roomMapper.findRoomListByPage(roomVo);
    }

    @Override
    public int addRoom(Room room) {
        return roomMapper.addRoom(room);
    }

    @Override
    public int updateRoom(Room room) {
        return roomMapper.updateRoom(room);
    }

    @Override
    public int deleteById(int id) {
        return roomMapper.deleteById(id);
    }

    @Override
    public List<Room> findRoomListByFloorId() {
        return roomMapper.findRoomListByFloorId();
    }

    @Override
    public Room findById(Integer id) {
        return roomMapper.findById(id);
    }
}
