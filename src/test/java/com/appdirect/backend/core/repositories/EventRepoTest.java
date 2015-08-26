/**
 * 
 */
package com.appdirect.backend.core.repositories;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author cweerasekera
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class EventRepoTest {
    
    @Autowired
    private EventRepo repo;
    
    @Test
    public void test(){
        
    }
}
