/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yinghuo.util;

import java.io.InputStream;
import java.util.Properties;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import redis.clients.jedis.Jedis;


//import com.yinghuo.util.JLock;

/**
 *
 * @author huang
 */
public class JLockTest {
    
    public JLockTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void testJLock() {
         try {
             InputStream inStream = JLockTest.class.getClassLoader().getResourceAsStream("conf/dev/sysConf.properties");
             Properties prop = new Properties();
             prop.load(inStream);
             String key = prop.getProperty("redis.server");
             Jedis jedis = new Jedis(key, 6379);
             assertTrue(JLock.tryGetDistributedLock(jedis, "123", "234", 10000));
             assertTrue(JLock.tryGetDistributedLock(jedis, "321", "432", 10000));
             assertTrue(JLock.releaseDistributedLock(jedis, "123", "234"));
             assertFalse(JLock.releaseDistributedLock(jedis, "123", "432"));
         } catch (Exception ex) {
             System.out.println(ex);
             assertTrue(false);
         }
         
     }
}
