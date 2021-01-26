package com.newsweb.mapper;

import com.newsweb.entity.News;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface NewsMapper {
    //查询新闻列表
    //@Select("SELECT * FROM news")
    @Select("select s.*,k.categoryName from news s inner join category k on s.newsCategoryID=k.categoryID")
    public List<News> getAll();

    //通过ID查找新闻信息
    //@Select("SELECT * FROM news where newsID=#{newsID} ")
    @Select("select s.*,k.categoryName from news s inner join category k on s.newsCategoryID=k.categoryID where newsID=#{newsID}")
    public News getNewsById(int newsID);

    //发布新闻
    @Insert("INSERT INTO news (newsTitle,newsContent,newsDate,newsCategoryID,newsPicture) VALUES (#{newsTitle},#{newsContent},#{newsDate},#{newsCategoryID},#{newsPicture})")
    public boolean addNews(News news);

    //删除新闻
    @Delete("Delete from news where newsID=#{newsID}")
    public boolean delNews(int newsID);

    //修改新闻
    @Update(" update news set newsTitle= #{newsTitle} ,newsContent= #{newsContent},newsDate= #{newsDate},newsCategoryID= #{newsCategoryID},newsPicture=#{newsPicture} where newsID = #{newsID} ")
    public boolean updateNews(News news);

    //select s.*,k.categoryName from news s inner join category k on s.newsCategoryID=k.categoryID where s.newsCategoryID='3'
}
