package com.itheima.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author Shujie Liu
 */
@Data
public class Category {
    //主键ID
    @NotNull(groups = Category.Update.class)
    private Integer id;
    //分类名称
    @NotEmpty(groups = {Add.class, Update.class})
    private String categoryName;
    //分类别名
    @NotEmpty(groups = {Add.class, Update.class})
    private String categoryAlias;
    //创建人ID
    private Integer createUser;
    //创建时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime createTime;
    //更新时间
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime updateTime;

    // 如果某个校验项没有指定分组，默认属于Default分组
    // 分组可以继承， A extends B 那么A中拥有中所有的校验项

    public interface Add extends Default {

    }

    public interface Update extends Default {

    }
}
