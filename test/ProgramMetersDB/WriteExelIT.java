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
public class WriteExelIT {
    
    public WriteExelIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of generateXls method, of class WriteExel.
     */
    @Test
    public void testGenerateXls() {
        System.out.println("generateXls");
        HashMap findDataMap =null;
        String exelRezPath = "";
        WriteExel.generateXls(findDataMap, exelRezPath);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
