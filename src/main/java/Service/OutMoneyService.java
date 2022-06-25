package Service;

import Bean.Checkin;
import Vo.CheckinVo;

import java.util.List;

public interface OutMoneyService {


    /*关联退房id*/
    int selectOutId(int id);

    int addCheckoutMoney(int id,Double myprice);

    List<Checkin> findCheckOutList(CheckinVo checkinVo);
}
