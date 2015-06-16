package com.woyo.dao;

import com.woyo.common.page.PageInfo;
import com.woyo.common.page.hibernate.IBaseHibernateTemplateDAO;
import com.woyo.model.Person;

/**
 * @author Administrator
 *
 */
public interface PersonDAO extends IBaseHibernateTemplateDAO {

    void save(Person person);

    Person findById(int id);

    PageInfo findAll(int pageNo, int pageSize);

    void delete(int id);

    void update(Person person);

    Person findByName(String name);

}
