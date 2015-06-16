package com.woyo.dao;

import com.woyo.common.page.PageInfo;
import com.woyo.common.page.hibernate.IBaseHibernateTemplateDAO;
import com.woyo.model.Group;

/**
 * @author Administrator
 *
 */
public interface GroupDAO extends IBaseHibernateTemplateDAO {

    void save(Group group);

    Group findById(int id);

    void delete(int id);

    void update(Group group);

    Group findByName(String name);

    PageInfo findAll(int pageSize, int pageNo);

}
