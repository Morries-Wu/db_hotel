package Controller.Admin;

import Bean.Menu;
import Bean.Role;
import Service.EmployeeService;
import Service.MenuService;
import Service.RoleService;
import Utils.DataGridViewResult;
import Utils.SystemConstant;
import Utils.TreeNode;
import Vo.RoleVo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/list")
    public DataGridViewResult list(RoleVo roleVo) {
        //设置分页信息
        PageHelper.startPage(roleVo.getPage(), roleVo.getLimit());
        //调用查询角色列表的方法
        List<Role> roleList = roleService.findRoleList(roleVo);
        //创建分页信息对象
        PageInfo<Role> pageInfo = new PageInfo<Role>(roleList);
        //返回数据(参数1：总数量，参数2：角色列表)
        return new DataGridViewResult(pageInfo.getTotal(), pageInfo.getList());
    }

    /**
     * 添加角色
     *
     * @param role
     * @return
     */
    @RequestMapping("/addRole")
    public String addDept(Role role) {
        Map<String, Object> map = new HashMap<>();
        //调用添加角色的方法
        if (roleService.addRole(role) > 0) {
            map.put(SystemConstant.SUCCESS, true);//成功
            map.put(SystemConstant.MESSAGE, "添加成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);//失敗
            map.put(SystemConstant.MESSAGE, "添加失败");
        }
        //将map集合以JSON格式返回
        return JSON.toJSONString(map);
    }


    /**
     * 修改角色信息
     *
     * @param role
     * @return
     */
    @RequestMapping("/updateRole")
    public String updateRole(Role role) {
        Map<String, Object> map = new HashMap<>();
        //调用修改角色的方法
        if (roleService.updateRole(role) > 0) {
            map.put(SystemConstant.SUCCESS, true);
            map.put(SystemConstant.MESSAGE, "修改成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);
            map.put(SystemConstant.MESSAGE, "修改失敗");
        }
        //将map集合以JSON格式返回
        return JSON.toJSONString(map);
    }


    /**
     * 查询该角色下是否存在员工信息
     *
     * @param id
     * @return
     */
    @RequestMapping("/checkRoleHashEmployee")
    public String checkRoleHashEmployee(Integer id) {
        Map<String, Object> map = new HashMap<>();
        if (employeeService.getEmployeeCountByRoleId(id) > 0) {
            map.put(SystemConstant.EXIST, true);//存在
            map.put(SystemConstant.MESSAGE, "该角色存在员工信息,无法删除");
        } else {
            map.put(SystemConstant.EXIST, false);//不存在
        }
        return JSON.toJSONString(map);
    }

    /**
     * 删除角色
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteById")
    public String deleteById(Integer id) {
        Map<String, Object> map = new HashMap<>();
        //调用删除角色的方法
        if (roleService.deleteById(id) > 0) {
            map.put(SystemConstant.SUCCESS, true);//成功
            map.put(SystemConstant.MESSAGE, "删除成功");
        } else {
            map.put(SystemConstant.SUCCESS, false);//失败
            map.put(SystemConstant.MESSAGE, "删除失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 根据角色ID查询角色拥有的菜单
     *
     * @param roleId 角色ID
     * @return
     */
    @RequestMapping("/initMenuTree")
    public DataGridViewResult initMenuTree(Integer roleId) {
        //调用查询菜单列表的方法
        List<Menu> menuList = menuService.findMenuList();
        //根据|角色ID|查询该角色已经拥有的|菜单ID|的方法
        List<Integer> currentRoleMenuIds = menuService.findMenuIdListByRoleId(roleId);//1,2,3,4,5
        //定义集合,保存菜单信息
        List<Menu> currentMenus = new ArrayList<>();
        //判断集合是否存在数据
        if (currentRoleMenuIds != null && currentRoleMenuIds.size() > 0) {
            //根据菜单IDc查询菜单的信息
            currentMenus = menuService.findMenuByMenuId(currentRoleMenuIds);
        }

        //创建集合保存树节点信息
        List<TreeNode> treeNodes = new ArrayList<TreeNode>();
        //循环遍历所有菜单
        for (Menu menu : menuList) {
            //定义变量,标识是否选中
            String checkArr = "0";//0表示复选框不选中,1表示选中复选框
            /**
             * 内层循环遍历当前角色拥有的权限菜单
             * 循环比较的原因:比较两个集合的数据是否有相同的,有相同的表示当前角色拥有这个权限
             */
            for (Menu currentMenu : currentMenus) {
                //如果id相等,表示当前角色有这个菜单,有这个菜单则需要将复选框选中
                if (menu.getId() == currentMenu.getId()) {
                    checkArr = "1";//选中
                    break;
                }
            }
            //定义变量，表示菜单是否展开
            Boolean spread = (menu.getSpread() == null || menu.getSpread() == 1) ? true : false;
            treeNodes.add(new TreeNode(menu.getId(), menu.getPid(), menu.getTitle(), spread, checkArr));
        }
        //将数据返回到页面
        return new DataGridViewResult(treeNodes);
    }


    /**
     * 保存分配菜单
     *
     * @param ids
     * @param roleId
     * @return
     */
    @RequestMapping("/saveRoleMenu")
    public String saveRoleMenu(String ids, Integer roleId) {
        Map<String, Object> map = new HashMap<>();
        //调用保存角色菜单关系的fang'fa
        if (roleService.saveRoleMenu(ids, roleId) > 0) {
            map.put(SystemConstant.MESSAGE, "分配菜单成功");
        } else {
            map.put(SystemConstant.MESSAGE, "分配菜单失败");
        }
        return JSON.toJSONString(map);
    }

    /**
     * 根据员工ID查询该员工拥有的角色列表
     *
     * @param id
     * @return
     */
    @RequestMapping("/initRoleListByEmpId")
    public DataGridViewResult initRoleListByEmpId(int id) {
        //调用查询所有角色列表的方法
        List<Map<String, Object>> roleList = roleService.findRoleListByMap();
        //调用根据Id查询该员工拥有的角色列表的方法
        List<Integer> roleIds = roleService.findEmployeeRoleByEmployeeId(id);
        //循环比较两个集合中的角色ID值是否相等,相等则选中该角色
        for (Map<String, Object> map : roleList) {
            //定义变量,标识是否选中
            boolean flag = false;//不选中
            //获取每一个角色ID
            int rid = (int) map.get("id");//id是主键,以主键作为map集合中key
            //内层循环遍历该员工拥有的角色列表
            for (Integer roleId : roleIds) {
                //判断两个集合是否存在角色ID相同
                if (rid == roleId) {
                    flag = true;//选中
                    break;
                }
            }
            //将状态保存在roleList集合中
            map.put("LAY_CHECKED", flag);//Key必须是LAY_CHECKED
        }
        return new DataGridViewResult(Long.valueOf(roleList.size()), roleList);
    }


}
