package com.itheima.mapper;

import com.itheima.pojo.Article;
import org.apache.ibatis.annotations.Insert;

import java.util.List;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/11/3
 */
public interface ArticleMapper {
    // 新增
    @Insert("insert into article(title, content, cover_img, state, category_id, create_user, create_time, update_time)" +
            "values(#{title}, #{content}, #{coverImg}, #{state}, #{categoryId}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Article article);

    // 查询文章列表
    List<Article> list(Integer userId, Integer categoryId, String state);
}
