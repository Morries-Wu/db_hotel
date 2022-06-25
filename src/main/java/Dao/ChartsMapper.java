package Dao;

import java.util.List;
import java.util.Map;

public interface ChartsMapper {

    /**
     * 查询每个年度总营业额
     * @return
     */
    List<Map> getTotalPriceByYear();

}
