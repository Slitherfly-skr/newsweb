package com.newsweb.service.impl;

import com.newsweb.entity.Admin;
import com.newsweb.mapper.AdminMapper;
import com.newsweb.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) {
        List<Admin> list = adminMapper.getByUsername(admin.getAdminName());
        if(list==null || list.size()<=0) return null;

        if(list.size()>1) return null;

        Admin u = list.get(0);

        if(u.getAdminPassword().equals(admin.getAdminPassword())) return u;

        return null;
    }


}
