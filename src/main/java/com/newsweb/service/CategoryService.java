package com.newsweb.service;

import com.newsweb.entity.Category;

import java.util.List;

public interface CategoryService {

    public List<Category> getAll();
    public Category getCategoryById(int categoryID);
    public boolean addCategory(Category category);
    public boolean delCategory(int categoryId);
    public boolean updateCategory(Category category);
}
