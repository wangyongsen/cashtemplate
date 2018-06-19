package com.yinghuo.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 
 * 
 * @author pzl
 * @version $Id: BaseJunit4Test.java, v 0.1 2018年1月15日 下午1:59:42 pzl Exp $
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:conf/applicationContext.xml")
public abstract class BaseTest extends AbstractJUnit4SpringContextTests {
    
    
}
