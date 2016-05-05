/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaworddoc;

import java.sql.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
//import com.microsoft.sqlserver.jdbc.*;

    public class MySql {
        public static final String DATA_TABLE = "promgram_meters";
        // Connect to your database.
        // Replace server name, username, and password with your credentials
        public static void sql(String pathServer,String user, String pass ) throws SQLException {
            if (pathServer.isEmpty()){
                 pathServer ="jdbc:mysql://localhost:3307/test";
                    user="root";
                      pass="root";}
       
            // Declare the JDBC objects.
            Connection connection = null;
            Statement statement = null; 
            ResultSet resultSet = null;
            String selectSql=null;
            boolean flagNewTable=false;
            
           
                connection = DriverManager.getConnection(pathServer,user,pass);
         

            try {
                
                     statement = connection.createStatement();
                     // проверяем на наличие таблицы в БД
                   DatabaseMetaData md = connection.getMetaData();
                    ResultSet rs = md.getTables(null, null, "%", null);
                        while (rs.next()) {
                            String serchTable=rs.getString(3);
                             if (serchTable.equals(DATA_TABLE)){// если находим делаем вывод
                                  selectSql="SELECT*FROM "+DATA_TABLE+"";
                               
                                ResultSet rs1 =  statement.executeQuery(selectSql);
                                   while(rs1.next()){
                                            //Retrieve by column name
                                            Integer id  = rs1.getInt("id");
                                            String cell_1 = rs1.getString(WriteExel.DATA_PROTOCOL);
                                            String cell_2 = rs1.getString(WriteExel.POTREBITEL);
                                            String cell_3 = rs1.getString(WriteExel.ZAVODSK_NUBBER);
                                            String cell_4 = rs1.getString(WriteExel.TIP_COUNTER);
                                            String cell_5 = rs1.getString(WriteExel.ZNAC_COUNTER);
                                            String cell_6 = rs1.getString(WriteExel.YEAR_COUNTER);
                                            String cell_7 = rs1.getString(WriteExel.PLACE);
                                            String cell_8 = rs1.getString(WriteExel.SEAL);
                                            String cell_9 = rs1.getString(WriteExel.ANNATATION);
        
                                            System.out.print(id);  
                                            System.out.println(cell_1+cell_2+cell_3+cell_4+cell_5+cell_6+cell_7+cell_8+cell_9);
                                         }
                                flagNewTable=true;
                            }
                        }
                            if (flagNewTable==false){// СОЗДАЕМ НОВУЮ ТАБЛИЦУ ЕСЛИ НЕБЫЛО
                                 selectSql = "CREATE TABLE " +DATA_TABLE+
                                                        "(id INTEGER AUTO_INCREMENT," +
                                                         WriteExel.DATA_PROTOCOL+ " VARCHAR(255), " + 
                                                         WriteExel.POTREBITEL+ " VARCHAR(255), " + 
                                                         WriteExel.ZAVODSK_NUBBER+ " VARCHAR(255), " + 
                                                         WriteExel.TIP_COUNTER+ " VARCHAR(255), " +
                                                         WriteExel.ZNAC_COUNTER+ " VARCHAR(255), " + 
                                                         WriteExel.YEAR_COUNTER+ " VARCHAR(255), " + 
                                                         WriteExel.PLACE+ " VARCHAR(255), " + 
                                                         WriteExel.SEAL+ " VARCHAR(255), " + 
                                                         WriteExel.ANNATATION+ " BLOB, " + 
                                                         " PRIMARY KEY ( id ))"; 
                             statement.executeUpdate(selectSql);
                                System.out.println("ok create new table");
                            }
          }
            catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                // Close the connections after the data has been handled.
                if (resultSet != null) try { resultSet.close(); } catch(Exception e) {}
                if (statement != null) try { statement.close(); } catch(Exception e) {}
                if (connection != null) try { connection.close(); } catch(Exception e) {}
            }
        }

    public MySql() {
    }
    }
