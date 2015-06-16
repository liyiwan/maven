package com.woyo.service;

import com.woyo.dao.AdminDAO;
import com.woyo.model.Admin;

/**
 * @author Administrator
 *
 */
public class AdminService {
    private AdminDAO adminDao;

    public AdminDAO getAdminDao() {
        return adminDao;
    }

    public void setAdminDao(AdminDAO adminDao) {
        this.adminDao = adminDao;
    }

    public void save(Admin admin) {
        adminDao.save(admin);
    }

    public Admin findById(int id) {
        return adminDao.findById(id);
    }

    public void delete(int id) {
        adminDao.delete(id);
    }

    public void update(Admin admin) {
        adminDao.update(admin);
    }

    public Admin findByName(String name) {
        return adminDao.findByName(name);
    }
}
