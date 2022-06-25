package Service;

import Bean.Checkin;
import Vo.CheckinVo;

import java.util.List;

public interface CheckinService {

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
}
