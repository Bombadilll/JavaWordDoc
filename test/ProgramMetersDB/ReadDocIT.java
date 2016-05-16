/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramMetersDB;

import java.util.HashMap;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author стационар
 */
public class ReadDocIT {
    
    public ReadDocIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of clearString method, of class ReadDoc.
     */
    @Test
    public void testClearString() {
        System.out.println("clearString");
        String rezStr = "";
        String expResult = "";
        String result = ReadDoc.clearString(rezStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rez method, of class ReadDoc.
     */
    @Test
    public void testRez() throws Exception {
        System.out.println("rez");
        String putProtocol = "d:\\work\\test_fail.doc";
        HashMap expResult = null;
        HashMap result = ReadDoc.rez(putProtocol);
        assertNotNull("ok", result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of rezx method, of class ReadDoc.
     */
    @Test
    public void testRezx() throws Exception {
        System.out.println("rezx");
        String putProtocol = "d:\\work\\test_fail.doc";
        HashMap expResult = null;
        HashMap result = ReadDoc.rezx(putProtocol);
        assertNotNull("ok", result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
