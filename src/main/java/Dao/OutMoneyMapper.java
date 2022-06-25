package Dao;

import Bean.Checkin;
import Bean.OutMoney;
import Vo.CheckinVo;

import java.util.List;

public interface OutMoneyMapper {
    /*查询退房id*/
    int selectOutId(int outid);

    /*关联退房id*/
    int addCheckoutMoney(OutMoney outMoney);

    List<Checkin> findCheckOutList(CheckinVo checkinVo);
}
