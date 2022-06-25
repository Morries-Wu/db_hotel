package Service.impl;

import Bean.Role;
import Dao.RoleMapper;
import Service.RoleService;
import Vo.RoleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    /**
     * 查询角色列表
     *
     * @param roleVo
     * @return
     */
    @Override
    public List<Role> findRoleList(RoleVo roleVo) {
        return roleMapper.findRoleList(roleVo);
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @Override
    public int addRole(Role role) {
        return roleMapper.addRole(role);
    }

    /**
     * 修改角色
     *
     * @param role
     * @return
     */
    @Override
    public int updateRole(Role role) {
        return roleMapper.updateRole(role);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        return roleMapper.deleteById(id);
    }

    /**
     * 保存角色菜单关系
     *
     * @param ids
     * @param roleId
     * @return
     */
    @Override
    public int saveRoleMenu(String ids, Integer roleId) {
        try {
            //删除原有的关系
            roleMapper.deleteRoleMenu(roleId);//根据角色Id删除
            //将ids拆分成数组
            String idsStr[] = ids.split(",");
            //循环调用
            for (int i = 0; i < idsStr.length; i++) {
                //调用保存菜单角色关系的方法
                roleMapper.addroleMenu(roleId, idsStr[i]);
            }
            return 1;//成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;//失败
    }

    @Override
    public List<Map<String, Object>> findRoleListByMap() {
        return roleMapper.findRoleListByMap();
    }

    @Override
    public List<Integer> findEmployeeRoleByEmployeeId(Integer employeeId) {
        return roleMapper.findEmployeeRoleByEmployeeId(employeeId);
    }


}
