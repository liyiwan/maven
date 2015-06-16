package com.woyo.bo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woyo.model.Admin;
import com.woyo.service.AdminService;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/context/applicationContext-config.xml", "/context/applicationContext-dataAccess.xml" })
public class AdminServiceTest {
    @Autowired
    private AdminService adminService;
    private Admin admin;

    @Before
    public void init() {
        admin = new Admin();
        admin.setName("frank");
        admin.setPassword("bill");
    }

    @Test
    public void testSave() {
        adminService.save(admin);

        assertNotNull(adminService.findByName("frank"));
    }

    @Test
    public void testUpdate() {
        Admin admin = adminService.findByName("frank");
        admin.setName("liuyu");
        adminService.update(admin);

        assertFalse("frank".equals(admin.getName()));
        assertEquals("liuyu", admin.getName());
    }

    @Test
    public void testFindByName() {
        Admin admin = adminService.findByName("liuyu");
        assertNotNull(admin);
        assertEquals("liuyu", admin.getName());

    }

    @Test
    public void testDelete() {
        Admin admin = adminService.findByName("liuyu");
        adminService.delete(admin.getId());
        assertNull(adminService.findByName("liuyu"));
    }
}
