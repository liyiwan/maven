package com.woyo.service;

import com.woyo.common.page.PageInfo;
import com.woyo.dao.GroupDAO;
import com.woyo.model.Group;
import com.woyo.util.Constants;

/**
 * @author Administrator
 *
 */
public class GroupService {
    private GroupDAO groupDao;

    public GroupDAO getGroupDao() {
        return groupDao;
    }

    public void setGroupDao(GroupDAO groupDao) {
        this.groupDao = groupDao;
    }

    public void save(Group group) {
        groupDao.save(group);
    }

    public Group findById(int id) {
        return groupDao.findById(id);
    }

    public void delete(int id) {
        groupDao.delete(id);
    }

    public void update(Group group) {
        groupDao.update(group);
    }

    public Group findByName(String name) {
        return groupDao.findByName(name);
    }

    public PageInfo findAll(int pageNo) {
        return groupDao.findAll(pageNo, Constants.MAX_PAGE_SIZE);
    }
}
