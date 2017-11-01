package com.tuyu.dao.support;

import java.util.List;

/**
 * @author walker tu
 * @date 2017/10/31
 * @description： 提供dao接口的一些通用方法
 */
public interface BaseDao<T> {

    /**
     * 保存对象
     *
     * @param t
     */
    void save(T t);

    /**
     * 删除对象
     *
     * @param id 给定对象的id
     */
    void delete(Integer id);

    /**
     * 删除对象
     *
     * @param t 给定对象
     */
    void delete(T t);

    /**
     * 更新对象
     *
     * @param t 要更新的对象
     */
    void update(T t);

    /**
     * 查询全部
     *
     * @return List集合
     */
    List<T> queryAll();

    /**
     * 通过提供id查询单个对象
     *
     * @param id 对象id
     * @return
     */
    T queryById(Integer id);

    /**
     * 通过提供一个id集合查询所有的对象
     *
     * @param ids 要查询的所有对象的id集合
     * @return List集合
     */
    List<T> queryByIds(List<Integer> ids);
}
