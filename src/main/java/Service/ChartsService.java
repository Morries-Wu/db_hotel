package Service;

import java.util.List;
import java.util.Map;

public interface ChartsService {

    /**
     * 查询每个年度总营业额
     * @return
     */
    List<Map> getTotalPriceByYear();
}
