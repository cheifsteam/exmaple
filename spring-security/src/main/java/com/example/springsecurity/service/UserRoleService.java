package com.example.springsecurity.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springsecurity.domain.UserRole;
import com.example.springsecurity.mapper.UserRoleMapper;
import com.example.springsecurity.service.impl.IUserRoleServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 屈燃希
 * @version 1.0
 * @project
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UserRoleService extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleServiceImpl {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteUserRolesByRoleId(List<String> roleIds) {
        baseMapper.delete(new QueryWrapper<UserRole>().lambda().in(UserRole::getRoleId,roleIds));
    }

    @Override
    public void deleteUserRolesByUserId(List<String> userIds) {
        baseMapper.delete(new QueryWrapper<UserRole>().lambda().in(UserRole::getUserId,userIds));

    }

    @Override
    public Set<Long> findUserIdByRoleId(Long roleId) {
        List<UserRole> userRoles = baseMapper.selectList(new QueryWrapper<UserRole>().lambda()
                .eq(UserRole::getRoleId, roleId));
        if (CollectionUtils.isNotEmpty(userRoles)) {
            return userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
        }
        return null;
    }

    @Override
    public Set<Long> findUserIdByRoleIds(List<String> roleIds) {
        List<UserRole> userRoles =baseMapper.selectList(new QueryWrapper<UserRole>().lambda().in(UserRole::getRoleId,roleIds));
        if (CollectionUtils.isNotEmpty(userRoles)) {
            return userRoles.stream().map(UserRole::getUserId).collect(Collectors.toSet());
        }
        return null;
    }
}
