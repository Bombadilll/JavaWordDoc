package ProgramMetersDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author стационар
 */
import ProgramMetersDB.MySql;
import org.junit.Test;
import static junit.framework.Assert.*;


public class Test_MySql {
    @Test
     public void  test_sqlConection() throws Exception
    {
      MySql mySql= new MySql();
        
      assertNotNull("Conect ok",mySql.sqlConection("","",""));
    
    
    }
     
    
}
