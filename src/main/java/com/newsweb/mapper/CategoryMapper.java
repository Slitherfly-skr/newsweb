package com.newsweb.mapper;

import com.newsweb.entity.Category;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryMapper {
    //查询新闻类别列表
    @Select("SELECT * FROM category")
    public List<Category> getAll();

    //通过ID查找栏目名字
    @Select("SELECT * FROM category where categoryID=#{categoryID} ")
    public Category getCategoryById(int categoryID);

    //增加新闻类别
    @Insert("INSERT INTO category (categoryName) VALUES (#{categoryName})")
    public boolean addCategory(Category category);

    //删除新闻类别
    //@Delete("Delete category,news from category,news where category.categoryID=news.newsCategoryID and categoryID=#{categoryID}")
    @Delete("Delete from category where categoryID=#{categoryID}")
    public boolean delCategory(int categoryId);

    //修改新闻类别
    @Update("update category set categoryName= #{categoryName} where categoryID = #{categoryID} ")
    //@Update("update category set categoryName= '777' where categoryID = '9'")
    public boolean updateCategory(Category category);
}
