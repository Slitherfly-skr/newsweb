package com.newsweb.service.impl;

import com.newsweb.entity.News;
import com.newsweb.mapper.NewsMapper;
import com.newsweb.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> getAll() {
        return newsMapper.getAll();
    }

    @Override
    public News getNewsById(int newsID) {
        return newsMapper.getNewsById(newsID);
    }

    @Override
    public boolean addNews(News news) {
        return newsMapper.addNews(news);
    }

    @Override
    public boolean delNews(int newsID) {
        return newsMapper.delNews(newsID);
    }

    @Override
    public boolean updateNews(News news) {
        return newsMapper.updateNews(news);
    }
}
