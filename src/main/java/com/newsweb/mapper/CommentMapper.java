package com.newsweb.mapper;

import com.newsweb.entity.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {

    @Select("Select c.*, u.userName from comment c inner join user u on u.userID=c.commentUserID  ")
    public List<Comment> getAll();

    @Delete("Delete from comment where commentID=#{commentID}")
    public boolean delComment(int commentID);

    @Delete("Delete from comment where commentUserID=#{commentUserID}")
    public boolean delUserComment(int commentUserID);
}
