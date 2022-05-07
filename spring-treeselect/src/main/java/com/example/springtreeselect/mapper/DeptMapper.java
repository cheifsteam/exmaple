package com.example.springtreeselect.mapper;

import com.example.springtreeselect.domain.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 部门Mapper接口
 *
 * @author ruoyi
 * @date 2022-04-25
 */

public interface DeptMapper
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
     * 删除部门
     *
     * @param deptId 部门主键
     * @return 结果
     */
    public int deleteDeptByDeptId(Long deptId);

    /**
     * 批量删除部门
     *
     * @param deptIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDeptByDeptIds(Long[] deptIds);
}
