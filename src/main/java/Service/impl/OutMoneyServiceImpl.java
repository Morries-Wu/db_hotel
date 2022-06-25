package Service.impl;

import Bean.Checkin;
import Bean.OutMoney;
import Dao.OutMoneyMapper;
import Service.OutMoneyService;
import Vo.CheckinVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OutMoneyServiceImpl implements OutMoneyService {
    @Autowired
    private OutMoneyMapper outMoneyMapper;


    /*查询退房id*/
    @Override
    public int selectOutId(int id) {
        return outMoneyMapper.selectOutId(id);
    }

    /*关联退房*/
    @Override
    public int addCheckoutMoney(int id,Double myprice) {
        OutMoney outMoney = new OutMoney();
        outMoney.setCreateDate(new Date());
        outMoney.setOutId(id);
        outMoney.setOutPrice(myprice);
        return outMoneyMapper.addCheckoutMoney(outMoney);
    }


    @Override
    public List<Checkin> findCheckOutList(CheckinVo checkinVo) {
        return outMoneyMapper.findCheckOutList(checkinVo);
    }

}
