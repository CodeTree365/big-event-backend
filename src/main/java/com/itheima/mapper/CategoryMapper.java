package com.itheima.mapper;

import com.itheima.pojo.Category;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author Shujie Liu
 * @project big-event
 * @date 2025/10/31
 */
public interface CategoryMapper {
    /**
     * 新增分类
     *
     * @param category
     */
    @Insert("insert into category(category_name, category_alias, create_user, create_time, update_time)" +
            "values(#{categoryName}, #{categoryAlias}, #{createUser}, #{createTime}, #{updateTime})")
    void add(Category category);

    /**
     * 查询分类列表
     *
     * @param id
     * @return
     */
    @Select("select * from category where create_user = #{userId}")
    List<Category> list(Integer id);

    /**
     * 根据id查询分类信息
     *
     * @param id
     * @return
     */
    @Select("select * from category where id = #{id}")
    Category findById(Integer id);

    /**
     * 更新分类
     *
     * @param category
     */
    @Update("update category set category_name = #{categoryName}, category_alias = #{categoryAlias}, update_time = #{updateTime} where id = #{id}")
    void update(Category category);
}
