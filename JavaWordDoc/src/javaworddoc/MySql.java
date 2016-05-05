/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaworddoc;

import java.sql.*;
import java.util.Arrays;
//import com.microsoft.sqlserver.jdbc.*;

    public class MySql {
        public static final String DATA_TABLE = "promgram_meters";
        // Connect to your database.
        // Replace server name, username, and password with your credentials
        public static void sql(String pathServer,String user, String pass ) {
            if (pathServer==""){}
             pathServer ="jdbc:mysql://localhost:3307/test";
                user="root";
                pass="root";

            // Declare the JDBC objects.
            Connection connection = null;
            Statement statement = null; 
            ResultSet resultSet = null;
            String selectSql=null;
            boolean flagNewTable=false;

            try {
                connection = DriverManager.getConnection(pathServer,user,pass);
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
                                            int id  = rs1.getInt("id");
                                            int age = rs1.getInt("age2");
                                            String first = rs1.getString("first");
                                            String last = rs1.getString("last");

                                            //Display values
                                            System.out.print("ID: " + id);
                                            System.out.print(", Age: " + age);
                                            System.out.print(", First: " + first);
                                            System.out.println(", Last: " + last);
                                         }
                                flagNewTable=true;
                            }
                        }
                            if (flagNewTable==false){// СОЗДАЕМ НОВУЮ ТАБЛИЦУ ЕСЛИ НЕБЫЛО
                                 selectSql = "CREATE TABLE " +DATA_TABLE+
                                                        "(id INTEGER not NULL, " +
                                                        " first VARCHAR(255), " + 
                                                        " last VARCHAR(255), " + 
                                                        " age2 INTEGER, " + 
                                                        " PRIMARY KEY ( id ))"; 
                             statement.executeUpdate(selectSql);
                                System.out.println("ok create new table");
                            }
                        
                
                 // Create and execute a SELECT SQL statement.
                
               
                

                // Print results from select statement
                
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
    }
