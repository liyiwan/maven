package com.woyo.dao;

import com.woyo.common.page.hibernate.IBaseHibernateTemplateDAO;
import com.woyo.model.Admin;

/**
 * @author Administrator
 *
 */
public interface AdminDAO extends IBaseHibernateTemplateDAO {

    void save(Admin admin);

    Admin findById(int id);

    void delete(int id);

    void update(Admin admin);

    Admin findByName(String name);

}
