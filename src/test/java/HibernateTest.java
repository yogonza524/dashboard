/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.core.entities.User;
import com.core.hibernate.HibernateUtil;
import java.util.Iterator;
import java.util.List;
import org.hibernate.Session;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author gonza
 */
public class HibernateTest {
    
    public HibernateTest() {
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
     @Ignore
     public void listAllUsersTest() {
         Session s = HibernateUtil.getSessionFactory().openSession();
         List<User> users = s.createCriteria(User.class).list();
         assertNotNull(users); 
         Iterator<User> i = users.iterator();
         while(i.hasNext()){
             User u = (User)i.next();
             System.out.println("username: " + u.getUsername());
         }
     }
}
