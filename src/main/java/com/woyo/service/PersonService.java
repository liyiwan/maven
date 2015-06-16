package com.woyo.service;

import com.woyo.common.page.PageInfo;
import com.woyo.dao.PersonDAO;
import com.woyo.model.Person;
import com.woyo.util.Constants;

/**
 * @author Administrator
 *
 */
public class PersonService {
    private PersonDAO personDao;

    public PersonDAO getPersonDao() {
        return personDao;
    }

    public void setPersonDao(PersonDAO personDao) {
        this.personDao = personDao;
    }

    public void save(Person person) {
        personDao.save(person);
    }

    public Person findById(int id) {
        return personDao.findById(id);
    }

    public PageInfo findAll(int pageNo) {
        return personDao.findAll(pageNo, Constants.MAX_PAGE_SIZE);
    }

    public void delete(int id) {
        personDao.delete(id);
    }

    public void update(Person person) {
        personDao.update(person);
    }

    public Person findByName(String name) {
        return personDao.findByName(name);
    }
}
