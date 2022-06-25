package Service.impl;

import Bean.Orders;
import Bean.Room;
import Bean.RoomType;
import Dao.OrdersMapper;
import Dao.RoomMapper;
import Dao.RoomTypeMapper;
import Service.OrdersService;
import Utils.UUIDUitls;
import Vo.OrdersVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class OrdersServiceImpl implements OrdersService {
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomMapper roomMapper;
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public int addOrders(Orders orders) {
        orders.setStatus(1);//1-待确认
        orders.setOrdersno(UUIDUitls.randomUUID());
        orders.setReservedate(new Date());//预定时间为当前系统时间
        int count = ordersMapper.addOrders(orders);
        //判断订单是否添加成功,添加成功操作房间及房型
        if (count > 0) {
            //修改房间状态为已预定(状态码为1)
            //查询房间信息
            Room room = roomMapper.findById(orders.getRoomid());
            room.setStatus(1);//修改房间状态为已预定(编号为1)
            //调用修改房间信息的方法
            roomMapper.updateRoom(room);
            //修改房型(可用房间数-1,已预定数量+1)
            RoomType roomType = roomTypeMapper.findById(orders.getRoomtypeid());
            //修改可用房间数量
            roomType.setAvilablenum(roomType.getAvilablenum() - 1);
            //修改已预定数量
            roomType.setReservednum(roomType.getReservednum() + 1);
            //调用修改房型的方法
            roomTypeMapper.updateRoomType(roomType);
        }
        return count;
    }

    @Override
    public List<Orders> findOrdersList(OrdersVo ordersVo) {
        return ordersMapper.findOrdersList(ordersVo);
    }

    @Override
    public int updateOrders(Orders orders) {
        return ordersMapper.updateOrders(orders);
    }

}
