package com.woyo.dao.impl;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import com.woyo.common.page.PageInfo;
import com.woyo.dao.GroupDAO;
import com.woyo.model.Group;

/**
 * @author Administrator
 *
 */
public class GroupDAOImpl extends BaseDAO implements GroupDAO {

    public void delete(int id) {
        Group group = this.findById(id);
        this.getHibernateTemplate().delete(group);

    }

    public PageInfo findAll(int pageNo, int pageSize) {
        String hql = "from Group g order by g.id desc";
        return this.findPageInfoByHql(pageNo, pageSize, hql);
    }

    public Group findById(int id) {
        return (Group) this.getHibernateTemplate().get(Group.class, id);
    }

    public Group findByName(String name) {
        Session session = null;
        Group group = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            session.beginTransaction();
            group = (Group) session.createQuery("From Group  u where u.name=?").setString(0, name).uniqueResult();
            session.getTransaction().commit();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return group;
    }

    public void save(Group group) {
        this.getHibernateTemplate().save(group);

    }

    public void update(Group group) {
        this.getHibernateTemplate().update(group);
    }

}
