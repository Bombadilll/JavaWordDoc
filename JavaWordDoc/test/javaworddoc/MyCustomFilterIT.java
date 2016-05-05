/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaworddoc;

import java.io.File;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author стационар
 */
public class MyCustomFilterIT {
    
    public MyCustomFilterIT() {
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

    /**
     * Test of accept method, of class MyCustomFilter.
     */
    @Test
    public void testAccept() {
        System.out.println("accept");
        File file = null;
        MyCustomFilter instance = new MyCustomFilter();
        boolean expResult = false;
        boolean result = instance.accept(file);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class MyCustomFilter.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        MyCustomFilter instance = new MyCustomFilter();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
