package com.example.springtreeselect.service;

import com.example.springtreeselect.domain.Dept;
import com.example.springtreeselect.domain.TreeSelect;

import java.util.List;

/**
 * 部门Service接口
 *
 * @author ruoyi
 * @date 2022-04-25
 */
public interface IDeptService
{
    /**
     * 查询部门
     *
     * @param deptId 部门主键
     * @return 部门
     */
    public Dept selectDeptByDeptId(Long deptId);

    /**
     * 查询部门列表
     *
     * @param dept 部门
     * @return 部门集合
     */
    public List<Dept> selectDeptList(Dept dept);

    /**
     * 新增部门
     *
     * @param dept 部门
     * @return 结果
     */
    public int insertDept(Dept dept);

    /**
     * 修改部门
     *
     * @param dept 部门
     * @return 结果
     */
    public int updateDept(Dept dept);

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的部门主键集合
     * @return 结果
     */
    public int deleteDeptByDeptIds(Long[] deptIds);

    /**
     * 删除部门信息
     *
     * @param deptId 部门主键
     * @return 结果
     */
    public int deleteDeptByDeptId(Long deptId);
    /**
     * 构建前端所需要树结构
     *
     * @param depts 部门列表
     * @return 树结构列表
     */
    public List<Dept> buildDeptTree(List<Dept> depts);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param depts 部门列表
     * @return 下拉树结构列表
     */
    public List<TreeSelect> buildDeptTreeSelect(List<Dept> depts);

}
