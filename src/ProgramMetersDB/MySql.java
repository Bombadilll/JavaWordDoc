/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramMetersDB;

import java.sql.*;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;


    public class MySql {
        public static final String DATA_TABLE = "promgram_meters";
        // Connect to your database.
          
        public static Connection sqlConection(String pathServer,String user, String pass) {
            Connection connection = null;
            try {
                  if (pathServer.isEmpty()){
                    pathServer ="jdbc:mysql://localhost:3307/test";
                    user="root";
                    pass="root";}
                connection = DriverManager.getConnection(pathServer,user,pass);
               return connection;
            } catch (SQLException ex) {
                Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
            }finally{ return connection;}
        }
    
        public static TreeMap sqlRead( Connection connect) throws SQLException {
            Integer counterRow=0;
            Statement statement = null; 
            ResultSet resultSet = null;
            String selectSql=null;
            boolean flagNewTable=false;
            TreeMap<Integer,HashMap> rezultReadRow= new TreeMap<Integer,HashMap>();
                
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
                                       HashMap<Integer,String> resultReadColum= new HashMap<Integer,String>();// обязательно обявляем тут.
                                            resultReadColum.put(0,rs1.getString(WriteExel.DATA_PROTOCOL));
                                            resultReadColum.put(1, rs1.getString(WriteExel.POTREBITEL));
                                            resultReadColum.put(2, rs1.getString(WriteExel.ZAVODSK_NUBBER));
                                            resultReadColum.put(3, rs1.getString(WriteExel.TIP_COUNTER));
                                            resultReadColum.put(4, rs1.getString(WriteExel.ZNAC_COUNTER));
                                            resultReadColum.put(5, rs1.getString(WriteExel.YEAR_COUNTER));
                                            resultReadColum.put(6, rs1.getString(WriteExel.PLACE));
                                            resultReadColum.put(7, rs1.getString(WriteExel.SEAL));
                                            resultReadColum.put(8, rs1.getString(WriteExel.ANNATATION));
                                          rezultReadRow.put(counterRow++, resultReadColum);
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
