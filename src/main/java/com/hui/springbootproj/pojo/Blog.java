package com.hui.springbootproj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Blog {

    private Long id;

    private String title;

    private String headImageAddress;

    private String content;

    // flags  shareStatement // 装载声明是否开启

    private Integer commentCount;
    /**  浏览次数 **/
    private Integer readCount;

    private boolean openComment;

    /** 是否打开文章下方的版权信息 */
    private boolean openCopyRight;
    /**  赞赏是否开启 **/
    private boolean openAppreciation;
    /**  是否发布 **/
    private boolean published;
    /**  是否推荐 **/
    private boolean recommend;
    /** 文章下方版权信息 */
    private String copyRight;

    private Date createTime;

    private Date lastUpdateTime;

    private Type type;

    private User user;

    private Long typeId;

    private Long userId;

    private List<Comment> comments = new ArrayList<>();
    private List<Tag> tags = new ArrayList<>();

}
