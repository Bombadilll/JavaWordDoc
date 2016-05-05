
package javaworddoc;


import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class JavaWordDoc {

    
    public static void main(String[] args) throws IOException {
        try {
        //MySql.sql("sgeg","sgsg","hfdh");
        } catch (Exception ex) {
            Logger.getLogger(JavaWordDoc.class.getName()).log(Level.SEVERE, null, ex);
        }
     java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame().setVisible(true);
            }
     });
    }
}
