package Dao;

import Bean.Dept;
import Vo.DeptVo;

import java.util.List;

public interface DeptMapper {
    /**
     * 查询部门列表
     *
     * @param deptVo
     * @return
     */
    List<Dept> findDeptListByPage(DeptVo deptVo);

    /**
     * 添加部门
     *
     * @param dept
     * @return
     */
    int addDept(Dept dept);

    /**
     * 修改部门
     */
    int updateDept(Dept dept);


    /**
     * 删除部门
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findDeptList();
}
