package com.newsweb.mapper;

import com.newsweb.entity.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AdminMapper {
    //管理员列表
    @Select("SELECT * FROM admin")
    public List<Admin> getAll();
    //管理员登录
    @Select("SELECT adminName,adminPassword FROM admin WHERE adminName=#{adminName} and adminPassword=#{adminPassword}")
    public Admin findAdminname(@Param("adminName") String adminName, @Param("adminPassword") String adminPassword);

    @Select("SELECT * FROM admin WHERE adminName=#{adminName} ")
    public List<Admin> getByUsername(String adminName);
}
