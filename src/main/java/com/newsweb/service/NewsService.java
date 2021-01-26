package com.newsweb.service;

import com.newsweb.entity.News;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface NewsService {

    public List<News> getAll();
    public News getNewsById(int newsID);
    public boolean addNews(News news);
    public boolean delNews(int newsID);
    public boolean updateNews(News news);
}
