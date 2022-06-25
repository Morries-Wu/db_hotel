package Controller.Admin;

import Service.ChartsService;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/Charts")
public class ChartsController {
    @Autowired
    private ChartsService chartsService;

    /**
     * 统计每年营业额
     * @return
     */
    @RequestMapping("/getYearCharts")
    public String getYearCharts(){
        //创建Map集合保存数据
        Map<String,Object> dataMap = new HashMap<String,Object>();
        //调用统计每个年度营业总额的方法
        List<Map> mapList = chartsService.getTotalPriceByYear();
        //创建两个List集合，分别保存年份及对应的营业额
        List<String> keyList = new ArrayList<String>();//年份
        List<Double> valueList = new ArrayList<Double>();//营业额
        //循环遍历每年营业额集合
        for (Map map : mapList) {
            keyList.add(map.get("years").toString());//年份
            valueList.add(Double.valueOf(map.get("money").toString()));//金额
        }
        dataMap.put("keyList",keyList);
        dataMap.put("valueList",valueList);
        //将Map集合以JSON格式返回
        return JSON.toJSONString(dataMap);
    }
}
