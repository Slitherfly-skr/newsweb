package com.newsweb.service;

import com.newsweb.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommentService {

    public List<Comment> getAll();

    public boolean delComment(int commentID);

    public boolean delUserComment(int commentUserID);
}
