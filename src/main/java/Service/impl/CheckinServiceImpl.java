package Service.impl;

import Bean.Checkin;
import Bean.Orders;
import Bean.RoomType;
import Dao.CheckinMapper;
import Dao.OrdersMapper;
import Dao.RoomTypeMapper;
import Service.CheckinService;
import Vo.CheckinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinMapper checkinMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomTypeMapper roomTypeMapper;

    @Override
    public List<Checkin> findCheckinList(CheckinVo checkinVo) {
        return checkinMapper.findCheckinList(checkinVo);
    }


    @Transactional(rollbackFor = RuntimeException.class)
    public int addCheckin(Checkin checkin) {
        //入住状态
        checkin.setStatus(1);//1.表示已入住
        checkin.setCreatedate(new Date());//创建时间
        //1.添加入住信息
        int count = checkinMapper.addCheckin(checkin);
        if (count > 0) {
            //2.修改预订订单的状态(t_orders表中的status列,值修改成3(已入住))
            Orders orders = new Orders();
            orders.setId(checkin.getOrdersid());//预订订单ID主键
            orders.setStatus(3);//已入住
            //调用修改订单方法
            ordersMapper.updateOrders(orders);
            /**
             * 3.修改房型表中的已入住数量(t_room_type表中的livednum列,值+1)
             * 3.1:查询原有的房型信息
             */
            RoomType roomType = roomTypeMapper.findById(checkin.getRoomtypeid());
            roomType.setLivednum(roomType.getLivednum() + 1);
            //3.2:调用修改房型的方法
            roomTypeMapper.updateRoomType(roomType);
        }
        return count;
    }
}
