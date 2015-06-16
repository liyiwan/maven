package com.woyo.dao.impl;

import org.hibernate.Session;
import org.springframework.dao.DataAccessException;

import com.woyo.common.page.PageInfo;
import com.woyo.dao.PersonDAO;
import com.woyo.model.Person;

/**
 * @author Administrator
 *
 */
public class PersonDAOImpl extends BaseDAO implements PersonDAO {

    /**
     * ��id����ɾ��
     */
    public void delete(int id) {
        this.getHibernateTemplate().delete(this.findById(id));
    }

    /**
     * ��ѯ����һ��pageinfo���󣬽��з�ҳ
     */
    public PageInfo findAll(int pageNo, int pageSize) {
        String hql = "from Person p ";
        return this.findPageInfoByHql(pageNo, pageSize, hql);
    }

    /**
     * ��id��ѯ
     */
    public Person findById(int id) {

        return (Person) this.getHibernateTemplate().get(Person.class, id);

    }

    /**
     * ����Person����
     */
    public void save(Person person) {
        this.getHibernateTemplate().save(person);

    }

    /**
     * ����Person����
     */
    public void update(Person person) {
        this.getHibernateTemplate().update(person);

    }

    /**
     * �����ֲ�ѯ
     */
    public Person findByName(String name) {
        Session session = null;
        Person person = null;
        try {
            session = this.getHibernateTemplate().getSessionFactory().openSession();
            session.beginTransaction();
            person = (Person) session.createQuery("From Person  u where u.name=?").setString(0, name).uniqueResult();
            session.getTransaction().commit();
        } catch (DataAccessException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return person;
    }

}
