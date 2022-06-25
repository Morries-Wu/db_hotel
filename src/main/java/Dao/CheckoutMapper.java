package Dao;

import Bean.Checkin;
import Bean.Checkout;
import Vo.CheckinVo;

import java.util.List;

public interface CheckoutMapper {

    /**
     * 添加退房的记录
     * @param checkout
     * @return
     */
    int addCheckout(Checkout checkout);

}
