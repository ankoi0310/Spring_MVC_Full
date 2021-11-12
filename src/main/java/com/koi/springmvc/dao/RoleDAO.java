package com.koi.springmvc.dao;

import com.koi.springmvc.entity.Role;

public interface RoleDAO {
    public Role findRoleByName(String theRoleName);
}
