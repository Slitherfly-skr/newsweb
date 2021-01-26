package com.newsweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

public class News {
    private Integer newsID;
    private String newsTitle;
    private String newsContent;
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//    private Date newsDate;
    private String newsDate;


    private String newsCategoryID;
    private String newsPicture;
    @Column(insertable = false,updatable = false)
    private String categoryName;

    public Integer getNewsID() {
        return newsID;
    }

    public void setNewsID(Integer newsID) {
        this.newsID = newsID;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsDate() { return newsDate; }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsCategoryID() {
        return newsCategoryID;
    }

    public void setNewsCategoryID(String newsCategoryID) {
        this.newsCategoryID = newsCategoryID;
    }

    public String getNewsPicture() {
        return newsPicture;
    }

    public void setNewsPicture(String newsPicture) {
        this.newsPicture = newsPicture;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "News{" +
                "newsID=" + newsID +
                ", newsTitle='" + newsTitle + '\'' +
                ", newsContent='" + newsContent + '\'' +
                ", newsDate='" + newsDate + '\'' +
                ", newsCategoryID='" + newsCategoryID + '\'' +
                ", newsPicture='" + newsPicture + '\'' +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
