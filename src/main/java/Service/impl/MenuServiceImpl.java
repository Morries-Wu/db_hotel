package Service.impl;

import Bean.Menu;
import Dao.MenuMapper;
import Service.MenuService;
import Vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> findMenuList() {
        return menuMapper.findMenuList();
    }

    @Override
    public List<Integer> findMenuIdListByRoleId(int roleId) {
        return menuMapper.findMenuIdListByRoleId(roleId);
    }

    @Override
    public List<Menu> findMenuByMenuId(List<Integer> currentRoleMenuIds) {
        return menuMapper.findMenuByMenuId(currentRoleMenuIds);
    }

    @Override
    public List<Menu> findMenuListByPage(MenuVo menuVo) {
        return menuMapper.findMenuListByPage(menuVo);
    }

    @Override
    public int addMenu(Menu menu) {
        //如果没有选择父级菜单,默认设置父级菜单为0
        if (menu.getPid() == null) {
            menu.setPid(0);
        }
        menu.setTarget("_self");//设置打开方式,没有作用
        return menuMapper.addMenu(menu);
    }

    @Override
    public int updateMenu(Menu menu) {
        return menuMapper.updateMenu(menu);
    }

    @Override
    public int deleteById(int id) {
        return menuMapper.deleteById(id);
    }

    @Override
    public int getMenuCountByMenuId(Integer id) {
        return menuMapper.getMenuCountByMenuId(id);
    }

    @Override
    public List<Menu> findMenuListByEmployeeId(Integer employeeId) {
        return menuMapper.findMenuListByEmployeeId(employeeId);
    }
}
