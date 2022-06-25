package Service.impl;

import Bean.*;
import Dao.*;
import Service.CheckoutService;
import Utils.UUIDUitls;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Service
@Transactional
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutMapper checkoutMapper;
    @Autowired
    private CheckinMapper checkinMapper;
    @Autowired
    private OrdersMapper ordersMapper;
    @Autowired
    private RoomTypeMapper roomTypeMapper;
    @Autowired
    private RoomMapper roomMapper;


    @Override
    public int addCheckout(Checkout checkout) {
        //1.新增一条退房记录,创建时间(什么时候操作了办理退房)
        checkout.setCreateDate(new Date());
        checkout.setCheckOutNumber(UUIDUitls.randomUUID());
        //调用新增退房记录的方法
        int count = checkoutMapper.addCheckout(checkout);
        if (count > 0) {
            //2.修改t_checkin中status状态,修改成2(已离店)
            Checkin checkin = checkinMapper.findById(checkout.getCheckInId());
            //已离店
            checkin.setStatus(2);
            //调用修改入住订单的方法
            checkinMapper.updateCheckin(checkin);
            //3.修改t_orders表中的status状态,修改成4(订单已完成)
            Orders orders = new Orders();
            orders.setStatus(4);//订单已完成
            orders.setId(checkin.getOrdersid());
            //调用修改订单的方法
            ordersMapper.updateOrders(orders);
            //4.修改t_room_type表中的可用房间数(+1),已入住房间数-1
            RoomType roomType = roomTypeMapper.findById(checkin.getRoomtypeid());
            //可用房间数+1
            roomType.setAvilablenum(roomType.getAvilablenum() + 1);
            //已入住房间数-1
            roomType.setLivednum(roomType.getLivednum() - 1);
            roomTypeMapper.updateRoomType(roomType);
            //注意:退房对象Checkout中,无法获取订单主键ID,也无法获取房型主键ID

            /*修改房间状态为可入住3*/
            Room room = new Room();
            room.setStatus(3);
            room.setId(checkin.getRoomid());
            roomMapper.updateRoom(room);
        }
        return count;

    }

    @Override
    public int updateCheckOut(Checkin checkin) {
        Checkout checkout = new Checkout();
        checkout.setCreateDate(new Date());
        checkout.setCheckOutNumber(UUIDUitls.randomUUID());
        //调用新增退房记录的方法
        int count = checkoutMapper.addCheckout(checkout);
        if (count > 0) {
            //2.修改t_checkin中status状态,修改成2(已离店)
            System.out.println(checkin);
            Checkin checkinCP = checkinMapper.findById(checkin.getOrdersid());
            checkin.setOrdersid(checkinCP.getOrdersid());
            //已离店
            checkin.setStatus(2);
            //调用修改入住订单的方法
            checkinMapper.updateCheckin(checkin);
            //3.修改t_orders表中的status状态,修改成4(订单已完成)
            Orders orders = new Orders();
            orders.setStatus(4);//订单已完成
            orders.setId(checkin.getOrdersid());
            //调用修改订单的方法
            ordersMapper.updateOrders(orders);
            //4.修改t_room_type表中的可用房间数(+1),已入住房间数-1
            RoomType roomType = roomTypeMapper.findById(checkin.getRoomtypeid());
            //可用房间数+1
            roomType.setAvilablenum(roomType.getAvilablenum() + 1);
            //已入住房间数-1
            roomType.setLivednum(roomType.getLivednum() - 1);
            roomTypeMapper.updateRoomType(roomType);
            //注意:退房对象Checkout中,无法获取订单主键ID,也无法获取房型主键ID

            /*修改房间状态为可入住3*/
            Room room = new Room();
            room.setStatus(3);
            room.setId(checkin.getRoomid());
            roomMapper.updateRoom(room);
        }
        return count;
    }


}
