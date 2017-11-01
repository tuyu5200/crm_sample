package com.tuyu.dao.support.impl;

import com.tuyu.dao.support.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author walker tu
 * @date 2017/10/31
 * @description：
 */
@SuppressWarnings("all")
public abstract class BaseDaoImpl<T> implements BaseDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Class<?> clazz;

    public BaseDaoImpl() {
        //获取泛型模板的类型信息
        ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
        Type[] types = type.getActualTypeArguments();
        //这里有一个泛型参数
        if (types.length != 1) {
            throw new IllegalArgumentException("泛型参数不正确");
        }
        this.clazz = (Class<?>) types[0];
    }

    protected Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T t) {
        this.getSession().save(t);
    }

    @Override
    public void delete(Integer id) {
        this.delete(this.queryById(id));
    }

    @Override
    public void delete(T t) {
        this.getSession().delete(t);
    }

    @Override
    public void update(T t) {
        this.getSession().update(t);
    }

    @Override
    public List<T> queryAll() {
        return this.getSession().createCriteria(this.clazz).list();
    }

    @Override
    public T queryById(Integer id) {
        return (T) this.getSession().get(this.clazz, id);
    }

    @Override
    public List<T> queryByIds(List<Integer> ids) {
        return this.getSession().createCriteria(this.clazz).add(Restrictions.in("id", ids)).list();
    }
}
