/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProgramMetersDB;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import org.apache.poi.hwpf.*;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.hwpf.usermodel.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;




public class ReadDoc {
    static  String clearString(String rezStr){
        String rezStr2=new String();
            String[] mas=rezStr.split(" ");
                       for (String ma : mas) {
                           rezStr2 = rezStr2.concat(ma);
                       }
        return rezStr2;
    }
    public static HashMap rez(String putProtocol)throws IOException{
       HashMap  rezultMap=new HashMap <>();
   try(FileInputStream ins=new FileInputStream(putProtocol);)
   {     HWPFDocument doc=new HWPFDocument(ins);
           
        
        Range range = doc.getRange();
for (int i = 0; i < range.numParagraphs(); i++) {
    Paragraph par = range.getParagraph(i);
   System.out.println("" + par.text());
    String str=par.text();
        str=str.trim();
      if (str.startsWith("Завод") ){
            rezultMap.put("Заводской№", str.substring(str.lastIndexOf("№")+1));
  }
        if (str.startsWith("Потребитель")||str.startsWith("Споживач")){
            rezultMap.put("Потребитель", str.substring(str.lastIndexOf(":")+1));
        
    }   if (str.startsWith("Примечание")||str.startsWith("Примітка")){
                    str=str.trim();
                    Paragraph par2 = range.getParagraph(i+1);
                       String str2=par2.text();
                       str2=str2.trim();
                       
                    if (str2.startsWith("Дата"))
                    {
                        rezultMap.put("Примечание", str.substring(str.lastIndexOf(":")+1));
                    } 
                    else
                    {
                     rezultMap.put("Примечание", str.substring(str.lastIndexOf(":")+1)+str2);
                    }    
            String seal= new String();
             if(str2.contains("№")) {
                 str2=str2.trim();
                 str2=clearString(str2);
             seal=(String)str2.subSequence(str2.lastIndexOf("№")+1,str2.lastIndexOf("№")+10);
             }
                            if(str.contains("№")) {
                                str=str.trim();
                                str=clearString(str);
                            seal=(String)str.subSequence(str.lastIndexOf("№")+1,str.lastIndexOf("№")+10);
                            }
            
            if (seal.isEmpty()){
                rezultMap.put("Пломба","не устонавлена");
            
                    } else  rezultMap.put("Пломба",(seal));  
           }
            
        if (str.startsWith("Дата «")){
            str=str.trim();
            
            str=clearString(str.substring(str.lastIndexOf("та")+2,str.lastIndexOf("та")+29));
          
            rezultMap.put("ДатаПротокола",str);
        } else {      
        }      
        
     
   
}
        }catch(IOException e){
            System.out.println("Произошла ошибка-"+ e );
        }  
   
 return rezultMap;  
    }
    public static HashMap rezx(String putProtocol)throws IOException, InvalidFormatException{
       HashMap  rezultMap=new HashMap <>();
   try(FileInputStream ins=new FileInputStream(putProtocol);)
   {    
             XWPFDocument doc=new XWPFDocument(OPCPackage.open(ins));
               List<XWPFParagraph> paragraphList =  doc.getParagraphs();
                
           for (Iterator<XWPFParagraph> it = paragraphList.iterator(); it.hasNext();) {
               XWPFParagraph par = it.next();
               boolean flag=true;
               String str=par.getText();
               str=str.trim();
               if (str.endsWith("типу:") ){
                   XWPFParagraph par3 = it.next();
                   String proverka=par3.getText();
                   if (proverka.isEmpty()){// проверка следующейс пустой строки
                        while(proverka.isEmpty()){
                                 XWPFParagraph par4 = it.next();
                                 String proverka2=par4.getText();
                                        if (!proverka2.isEmpty()){
                                             rezultMap.put("Тип",par4.getText());
                                             break;
                                             }
                   
                        }
                   }else rezultMap.put("Тип",par3.getText());                             
                   
               }
               if (str.startsWith("Завод") ){//заводской номер чтение
                   
                   rezultMap.put("Заводской№", str.substring(str.lastIndexOf("№")+1));
                   
                   
               }
                if (str.startsWith("Рік випуску") ){//заводской номер чтение
                   
                   rezultMap.put("Год_випуска", str.substring(str.lastIndexOf(":")+1));
                }
                
                   if (str.startsWith("Дата повірки") ){//заводской номер чтение
                   
                   rezultMap.put("Год_випуска",rezultMap.get("Год_випуска")+"/" +str.substring(str.lastIndexOf(":")+1));
                   }
            if (str.startsWith("Потребитель")||str.startsWith("Споживач")){// потребитель чтение
                   rezultMap.put("Потребитель", str.substring(str.lastIndexOf(":")+1));
                   
               }
                if (str.startsWith("Место")||str.startsWith("Місце")){// место установки чтение
                   rezultMap.put("Место_уст", str.substring(str.lastIndexOf(":")+1));
                }
                
                if (str.startsWith("значність лічильника")){// значность сч. чтение
                    str=str.trim();
                   rezultMap.put("Знаки", str.substring(str.lastIndexOf(":")+1));
                     }
                
                if (str.startsWith("клас напруги")){// напряжение сч. чтение
                
                }
              if (str.startsWith("Примечание")||str.startsWith("Примітка")){
                         str=str.trim();
                   
                        XWPFParagraph par2 = it.next();
                        String str2=par2.getText();
                      
                       str2=str2.trim();
                   if (str2.startsWith("Дата")){
                       
                        flag=false; 
                        rezultMap.put("Примечание", str.substring(str.indexOf(":")+1)); 
                        str2=str2.trim();
                       
                   str2=clearString(str2.substring(str2.lastIndexOf("та")+2,str2.lastIndexOf("та")+29));
                    
                   rezultMap.put("ДатаПротокола",str2);
                   
                    } else
                    {
                        rezultMap.put("Примечание", str.substring(str.indexOf(":")+1)+str2);
                   
                    }    
                            String seal= new String();
                             if(str2.contains("№")) {
                                 str2=str2.trim();
                                str2=clearString(str2);
                                
                              seal=str2.substring(str2.indexOf("№")+1,str2.indexOf("№")+10);
                             }
                              
                             if(str.contains("№")) {
                                 str=str.trim();
                                    str=clearString(str);
                                 seal=str.substring(str.indexOf("№")+1,str.indexOf("№")+10);
                             }
                             
                            if (seal.isEmpty()){
                                      rezultMap.put("Пломба","не устонавлена");
            
                                        } else  rezultMap.put("Пломба",(seal));  
               }
               if (str.startsWith("Дата «")&&flag){
                    
                   str=str.trim();
                                  
                   str=clearString(str.substring(str.lastIndexOf("та")+2,str.lastIndexOf("та")+29));
                   
                   rezultMap.put("ДатаПротокола",str);
               } 
            }
        }catch(IOException e){
            System.out.println("Произошла ошибка-"+ e );
        }  
   
 return rezultMap;  
    }
}
