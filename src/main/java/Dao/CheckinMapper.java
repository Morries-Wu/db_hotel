package Dao;

import Bean.Checkin;
import Vo.CheckinVo;

import java.util.List;

public interface CheckinMapper {

    /**
     * 查询入住的列表
     * @param checkinVo
     * @return
     */
    List<Checkin> findCheckinList(CheckinVo checkinVo);

    /**
     * 添加入住信息
     * @param checkin
     * @return
     */
    int addCheckin(Checkin checkin);

    /**
     * 修改入户信息的方法
     * @param checkin
     */
    int updateCheckin(Checkin checkin);

    /**
     * 根据主键查询入住信息
     * @param checkInId
     * @return
     */
    Checkin findById(Integer checkInId);
}
