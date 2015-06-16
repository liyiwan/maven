package com.woyo.bo.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woyo.common.page.PageInfo;
import com.woyo.model.Group;
import com.woyo.service.GroupService;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/context/applicationContext-config.xml", "/context/applicationContext-dataAccess.xml" })
public class GroupServiceTest {
    @Autowired
    private GroupService groupService;
    private Group group;

    @Before
    public void init() {
        group = new Group();
        group.setName("C++");
    }

    @Test
    public void testSave() {
        groupService.save(group);

        assertNotNull(groupService.findByName("C++"));
    }

    @Test
    public void testFindAll() {
        PageInfo groups = groupService.findAll(1);
        List<Group> results = (List<Group>) groups.getPageData();

        for (Group p : results) {
            assertEquals("C++", group.getName());
        }
    }

    @Test
    public void testUpdate() {
        Group group = groupService.findByName("C++");
        group.setName("C##");

        groupService.update(group);

        assertFalse("C++".equals(group.getName()));
        assertEquals("C##", group.getName());
    }

    @Test
    public void testFindByName() {
        Group group = groupService.findByName("C##");

        assertNotNull(group);
        assertEquals("C##", group.getName());
    }

    @Test
    public void testDelete() {
        Group group = groupService.findByName("C##");
        groupService.delete(group.getId());

        assertNull(groupService.findByName("C##"));
    }
}
