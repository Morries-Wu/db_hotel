package Service;

import Bean.Room;
import Vo.RoomVo;

import java.util.List;

public interface RoomService {
    /**
     * 查询房间列表
     *
     * @param roomVo
     * @return
     */
    List<Room> findRoomListByPage(RoomVo roomVo);

    /**
     * 查询房间列表
     *
     * @param room
     * @return
     */
    int addRoom(Room room);

    /**
     * 修改房间
     *
     * @param room
     * @return
     */
    int updateRoom(Room room);

    /**
     * 删除房间
     *
     * @param id
     * @return
     */
    int deleteById(int id);

    /**
     * 根据楼层查询房间的列表
     *
     * @return
     */
    List<Room> findRoomListByFloorId();

    /**
     * 查看房间详情
     * @param id
     * @return
     */
    Room findById(Integer id);
}
