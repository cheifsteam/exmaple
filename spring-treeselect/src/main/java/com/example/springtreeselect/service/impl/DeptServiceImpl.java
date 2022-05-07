package com.example.springtreeselect.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.example.springtreeselect.domain.Dept;
import com.example.springtreeselect.domain.TreeSelect;
import com.example.springtreeselect.mapper.DeptMapper;
import com.example.springtreeselect.service.IDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * 部门Service业务层处理
 *
 * @author ruoyi
 * @date 2022-04-25
 */
@Service
public class DeptServiceImpl implements IDeptService
{
    @Autowired
    private DeptMapper deptMapper;

    /**
     * 查询部门
     *
     * @param deptId 部门主键
     * @return 部门
     */
    @Override
    public Dept selectDeptByDeptId(Long deptId)
    {
        return deptMapper.selectDeptByDeptId(deptId);
    }

    /**
     * 查询部门列表
     *
     * @param dept 部门
     * @return 部门
     */
    @Override
    public List<Dept> selectDeptList(Dept dept)
    {
        final List<Dept> depts = deptMapper.selectDeptList(dept);
        System.out.println("sb"+depts);
        return depts;
    }

    /**
     * 新增部门
     *
     * @param dept 部门
     * @return 结果
     */
    @Override
    public int insertDept(Dept dept)
    {
        return deptMapper.insertDept(dept);
    }

    /**
     * 修改部门
     *
     * @param dept 部门
     * @return 结果
     */
    @Override
    public int updateDept(Dept dept)
    {
        return deptMapper.updateDept(dept);
    }

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的部门主键
     * @return 结果
     */
    @Override
    public int deleteDeptByDeptIds(Long[] deptIds)
    {
        return deptMapper.deleteDeptByDeptIds(deptIds);
    }

    /**
     * 删除部门信息
     *
     * @param deptId 部门主键
     * @return 结果
     */
    @Override
    public int deleteDeptByDeptId(Long deptId)
    {
        return deptMapper.deleteDeptByDeptId(deptId);
    }

    @Override
    public List<Dept> buildDeptTree(List<Dept> depts) {
        List<Dept> returnList = new ArrayList<>();
        List<Long> tempList =new ArrayList<>();
        for (Dept dept:depts) {
            tempList.add(dept.getDeptId());
        }
        //遍历所有节点
        for (Iterator<Dept> iterator = depts.iterator();iterator.hasNext();){
            Dept  dept = iterator.next();
            // 如果是根节点, 遍历该根节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()){
            returnList =depts;
        }
        return returnList;
    }

    /**
     * 递归查找所有的根节点和分支的节点下的子节点
     * @param list 所有部门
     * @param t 根节点或者分支节点
     */
    private void recursionFn(List<Dept> list,Dept t){
        List<Dept> childList =getChildList(list,t);
        t.setChildren(childList);
        for (Dept tChild:childList){
            if (hasChild(list,tChild)){//判断是否为分支节点
                recursionFn(list,tChild);//若为分支节点，继续查找节点
            }
        }
    }

    /**
     * 判断是否有子节点
     * @param list
     * @param tChild
     * @return
     */
    private boolean hasChild(List<Dept> list, Dept tChild) {
        return getChildList(list,tChild).size()>0;
    }

    /**
     * 得到t节点下的子节点的列表
     * @param list
     * @param t
     * @return
     */
    private List<Dept> getChildList(List<Dept> list, Dept t) {
        List<Dept> tList=new ArrayList<>();//t的子节点
        Iterator<Dept> it= list.iterator();
        while (it.hasNext()){
            Dept n=it.next();
            if (n.getParentId()!=null && t.getDeptId().longValue()==n.getParentId().longValue()){//判断该节点是否是当前传入的节点的孩子
                tList.add(n);//加入子节点列表
            }
        }
        return tList;
    }

    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<Dept> depts) {
        List<Dept> deptTrees=buildDeptTree(depts);
        return deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }
}
