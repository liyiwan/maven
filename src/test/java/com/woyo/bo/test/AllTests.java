package com.woyo.bo.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Administrator
 *
 */
@RunWith(Suite.class)
@SuiteClasses( { AdminServiceTest.class, GroupServiceTest.class, PersonServiceTest.class })
public class AllTests {

}
