package com.hui.springbootproj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Comment {
    private Long id;
    private String nickname;
    private String email;
    private String content;

    /** 头像**/
    private String avatar;
    private Date createTime;
    private boolean adminComment;//是否为管理员评论

    private List<Comment> replyCommentList;//该评论的回复列表

    private Comment parentComment;//父评论
}
