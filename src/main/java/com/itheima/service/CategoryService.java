package com.itheima.service;

import com.itheima.pojo.Category;

import java.util.List;

/**
 * @author HP
 * @project big-event
 * @date 2025/10/31
 */
public interface CategoryService {

    /**
     * 新增分类
     */
    void add(Category category);

    /**
     * 列表查询
     */
    List<Category> list();

    /**
     * 根据id查询分类信息
     *
     * @param id
     * @return
     */
    Category findById(Integer id);

    /**
     * 更新分类
     *
     * @param category
     */
    void update(Category category);
}
