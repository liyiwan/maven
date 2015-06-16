package com.woyo.dao.impl;

import java.util.List;

import com.woyo.dao.AdminDAO;
import com.woyo.model.Admin;

/**
 * @author Administrator
 *
 */
public class AdminDAOImpl extends BaseDAO implements AdminDAO {

    public void delete(int id) {
        Admin admin = this.findById(id);
        this.getHibernateTemplate().delete(admin);

    }

    public Admin findById(int id) {
        return (Admin) this.getHibernateTemplate().get(Admin.class, id);
    }

    public Admin findByName(String name) {
        String hql = "from Admin a where a.name=?";
        List list = this.findByHql(hql, name);

        Admin admin = null;
        if (list.size() != 0) {
            return (Admin) list.get(0);
        }
        return admin;
    }

    public void save(Admin admin) {
        this.getHibernateTemplate().save(admin);

    }

    public void update(Admin admin) {
        this.getHibernateTemplate().update(admin);

    }

}
