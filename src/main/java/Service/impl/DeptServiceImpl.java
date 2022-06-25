package Service.impl;

import Bean.Dept;
import Dao.DeptMapper;
import Service.DeptService;
import Vo.DeptVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findDeptListByPage(DeptVo deptVo) {
        List<Dept> list = deptMapper.findDeptListByPage(deptVo);
        return list;

    }

    @Override
    public int addDept(Dept dept) {
        //保存创建事件
        dept.setCreateDate(new Date());
        return deptMapper.addDept(dept);
    }

    @Override
    public int updateDept(Dept dept) {
        return deptMapper.updateDept(dept);
    }

    @Override
    public int deleteById(Integer id) {
        return deptMapper.deleteById(id);
    }

    @Override
    public List<Dept> findDeptList() {
        return deptMapper.findDeptList();
    }
}
