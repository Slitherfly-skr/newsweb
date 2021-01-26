package com.newsweb.service.impl;

import com.newsweb.entity.Category;
import com.newsweb.mapper.CategoryMapper;
import com.newsweb.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public List<Category> getAll() {
        return categoryMapper.getAll();
    }

    @Override
    public Category getCategoryById(int categoryID){
        return categoryMapper.getCategoryById(categoryID);
    }
    @Override
    public boolean addCategory(Category category) {
        categoryMapper.addCategory(category);
        return true;
    }

    @Override
    public boolean delCategory(int categoryID) {
        return categoryMapper.delCategory(categoryID);
    }

    @Override
    public boolean updateCategory(Category category) {
        return categoryMapper.updateCategory(category);
    }
}
