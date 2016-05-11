/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramMetersDB;

import java.sql.*;
import java.util.HashMap;
import java.util.TreeMap;

//import com.microsoft.sqlserver.jdbc.*;

    public class MySql {
        public static final String DATA_TABLE = "promgram_meters";
        // Connect to your database.
        // Replace server name, username, and password with your credentials
   
        public static Connection sqlConection(String pathServer,String user, String pass) throws SQLException{
                Connection connection = null;
            if (pathServer.isEmpty()){
                 pathServer ="jdbc:mysql://localhost:3307/test";
                    user="root";
                      pass="root";}
                        connection = DriverManager.getConnection(pathServer,user,pass);
       return connection;
        }
    
        
        
        public static TreeMap sqlRead( Connection connect) throws SQLException {
            
            Statement statement = null; 
            ResultSet resultSet = null;
            String selectSql=null;
            boolean flagNewTable=false;
            TreeMap<Integer,HashMap> rezultReadRow= new TreeMap<Integer,HashMap>();
                HashMap<Integer,String> resultReadColum= new HashMap<Integer,String>();
            try {
                statement = connect.createStatement();
                     // проверяем на наличие таблицы в БД
                   DatabaseMetaData md = connect.getMetaData();
                    ResultSet rs = md.getTables(null, null, "%", null);
                        while (rs.next()) {
                            String serchTable=rs.getString(3);
                             if (serchTable.equals(DATA_TABLE)){// если находим делаем вывод
                                  selectSql="SELECT*FROM "+DATA_TABLE+"";
                               
                                ResultSet rs1 =  statement.executeQuery(selectSql);
                                   while(rs1.next()){
                                            resultReadColum.put(1,rs1.getString(WriteExel.DATA_PROTOCOL));
                                            resultReadColum.put(2, rs1.getString(WriteExel.POTREBITEL));
                                            resultReadColum.put(3, rs1.getString(WriteExel.ZAVODSK_NUBBER));
                                            resultReadColum.put(4, rs1.getString(WriteExel.TIP_COUNTER));
                                            resultReadColum.put(5, rs1.getString(WriteExel.ZNAC_COUNTER));
                                            resultReadColum.put(6, rs1.getString(WriteExel.YEAR_COUNTER));
                                            resultReadColum.put(7, rs1.getString(WriteExel.PLACE));
                                            resultReadColum.put(8, rs1.getString(WriteExel.SEAL));
                                            resultReadColum.put(9, rs1.getString(WriteExel.ANNATATION));
                                            rezultReadRow.put(rs1.getInt("id"), resultReadColum);
                                      }
                                flagNewTable=true;
                                return rezultReadRow;
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
                if (connect != null) try { connect.close(); } catch(Exception e) {}
            }
        return rezultReadRow;
        }

    
    
    }
