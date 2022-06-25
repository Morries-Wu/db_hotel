package Service.impl;

import Dao.ChartsMapper;
import Service.ChartsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ChartsServiceImpl implements ChartsService {
    @Autowired
    private ChartsMapper chartsMapper;

    @Override
    public List<Map> getTotalPriceByYear() {
        return chartsMapper.getTotalPriceByYear();
    }
}
