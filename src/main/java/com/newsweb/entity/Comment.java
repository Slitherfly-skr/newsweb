package com.newsweb.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import java.util.Date;

public class Comment {
    private Integer commentID;
    private String commentContent;
    private String commentUserID;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date commentDate;
    @Column(insertable = false,updatable = false)
    private String userName;
    public Integer getCommentID() {
        return commentID;
    }

    public void setCommentID(Integer commentID) {
        this.commentID = commentID;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public String getCommentUserID() {
        return commentUserID;
    }

    public void setCommentUserID(String commentUserID) {
        this.commentUserID = commentUserID;
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentID=" + commentID +
                ", commentContent='" + commentContent + '\'' +
                ", commentUserID='" + commentUserID + '\'' +
                ", commentDate=" + commentDate +
                ", userName='" + userName + '\'' +
                '}';
    }
}
