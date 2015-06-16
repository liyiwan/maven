package com.woyo.bo.test;

import java.util.List;

import junit.framework.TestCase;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.woyo.common.page.PageInfo;
import com.woyo.model.Group;
import com.woyo.model.Person;
import com.woyo.service.PersonService;

/**
 * @author Administrator
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration( { "/context/applicationContext-config.xml", "/context/applicationContext-dataAccess.xml" })
public class PersonServiceTest extends TestCase {
    @Autowired
    private PersonService personService;
    private Person person;
    private Group group;

    @Before
    public void init() {
        person = new Person();
        group = new Group();
        group.setName("C#");
        person.setName("aa");
        person.setPassword("aa");
        person.setGroup(group);
    }

    @Test
    public void testSave() {
        personService.save(person);

        Person p = personService.findByName("aa");
        assertNotNull(p);
        assertNotNull(p.getGroup());
        assertEquals("C#", p.getGroup().getName());
    }

    @Test
    public void testFindAll() {
        PageInfo persons = personService.findAll(1);
        List<Person> results = (List<Person>) persons.getPageData();

        for (Person p : results) {
            assertEquals("aa", p.getName());
        }
    }

    @Test
    public void testUpdate() {
        Person person = personService.findByName("aa");
        person.setName("bb");
        personService.update(person);

        assertFalse("aa".equals(person.getName()));
        assertEquals("bb", person.getName());
    }

    @Test
    public void testFindByName() {
        Person person = personService.findByName("bb");

        assertNotNull(person);
        assertEquals("bb", person.getName());
    }

    @Test
    public void testDelete() {
        Person person = personService.findByName("bb");
        personService.delete(person.getId());

        assertNull(personService.findByName("bb"));
    }
}
