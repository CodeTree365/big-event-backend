package com.itheima.pojo;


import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDateTime;

/**
 * @author Shujie Liu
 */
@Data
public class Article {
    //主键ID
    private Integer id;
    //文章标题
    @NotEmpty
    @Pattern(regexp = "^\\S{1,10}$")
    private String title;
    //文章内容
    @NotEmpty
    private String content;
    @NotEmpty
    @URL
    //封面图像
    private String coverImg;
    //发布状态 已发布|草稿
    @NotNull
    private String state;
    //文章分类id
    private Integer categoryId;
    //创建人ID
    private Integer createUser;
    //创建时间
    private LocalDateTime createTime;
    //更新时间
    private LocalDateTime updateTime;
}
