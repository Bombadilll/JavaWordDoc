package ProgramMetersDB;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;

public class WriteExel {
public static final String DATA_PROTOCOL = "ДатаПротокола";
public static final String POTREBITEL = "Потребитель";
public static final String ZAVODSK_NUBBER = "Заводской№";
public static final String TIP_COUNTER = "Тип_счетчика";
public static final String ZNAC_COUNTER = "Значность";
public static final String YEAR_COUNTER = "Год_счетчика";
public static final String PLACE = "Место_установки";
public static final String SEAL = "Пломба";
public static final String ANNATATION= "Примечание";

/*
 * Генерируем xls  и отдаём его 
 * в байтовый поток записи
 */
public static void generateXls( HashMap findDataMap,String exelRezPath) {
    try {
         HSSFWorkbook wb;
                File yourFile = new File(exelRezPath);//проверка на наличие файла
                  if(!yourFile.exists()) {
                              Workbook wb1 = new HSSFWorkbook();//создаем файл если нет
                                     try (FileOutputStream fileOut = new FileOutputStream(exelRezPath)) {
                                               wb1.createSheet();
                                                wb1.write(fileOut);
                                          }
                    }
      try (InputStream is = new FileInputStream(exelRezPath)) {
            wb = new HSSFWorkbook(is); //Создаём новый документ
            HSSFSheet sheet = wb.getSheetAt(0); //Создаём страницу
            //Объявляем переменные для строки и ячейки
            HSSFRow row;
            HSSFCell cell;
            //Создаём "шапку" таблицы
            row = sheet.createRow(0);
            cell = row.createCell(0, Cell.CELL_TYPE_STRING);
            cell.setCellValue(DATA_PROTOCOL);
            cell = row.createCell(1, Cell.CELL_TYPE_STRING);
            cell.setCellValue(POTREBITEL); 
            cell = row.createCell(2, Cell.CELL_TYPE_STRING);
            cell.setCellValue(ZAVODSK_NUBBER); 
            cell = row.createCell(3, Cell.CELL_TYPE_STRING);
            cell.setCellValue(TIP_COUNTER); 
            cell = row.createCell(4, Cell.CELL_TYPE_STRING);
            cell.setCellValue(ZNAC_COUNTER);  
            cell = row.createCell(5, Cell.CELL_TYPE_STRING);
            cell.setCellValue(YEAR_COUNTER);  
            cell = row.createCell(6, Cell.CELL_TYPE_STRING);
            cell.setCellValue(PLACE);  
            cell = row.createCell(7, Cell.CELL_TYPE_STRING);
            cell.setCellValue(SEAL);
            cell = row.createCell(8, Cell.CELL_TYPE_STRING);
            cell.setCellValue(ANNATATION);  
            
            if(findDataMap!= null){
                // проверка на наличие пломбы в поле документа
                String plomb=(String)findDataMap.get("Пломба");
                boolean flag2=true;
             //  if (plomb.startsWith("не")){flag2=false;}// для отчета по пломбам
                //Записываем содержимое в ячейки
                
                if( findDataMap.size() > 0&&flag2){
                    
                    int rowIndex = sheet.getLastRowNum()+1; //Нулевой столбец - "шапка" таблицы
                    row = sheet.createRow(rowIndex); // Создаём новую строку
                    
                    cell = row.createCell(0, Cell.CELL_TYPE_STRING);
                     //cell.setCellValue("ПП від "+(String)findData.get("ДатаПротокола"));//для пломб
                     cell.setCellValue((String)findDataMap.get("ДатаПротокола"));
                     
                    cell = row.createCell(1, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Потребитель")); //
                    
                    cell = row.createCell(2, Cell.CELL_TYPE_STRING);
                    //cell.setCellValue("ліч.№"+(String)findData.get("Заводской№")+" оптопорт");//для пломб
                     cell.setCellValue((String)findDataMap.get("Заводской№"));
                     
                    cell = row.createCell(3, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Тип")); //

                    cell = row.createCell(4, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Знаки")); //
                    
                    cell = row.createCell(5, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Год_випуска")); //
                    
                    cell = row.createCell(6, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Место_уст")); //
                    
                    cell = row.createCell(7, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Пломба")); //
                    
                    cell = row.createCell(8, Cell.CELL_TYPE_STRING);
                    cell.setCellValue((String)findDataMap.get("Примечание")); //
                }
           }
        } 
        try (OutputStream f2 = new FileOutputStream(exelRezPath) ) { wb.write(f2);} // запись в файл 
      } catch (Exception e) { System.out.println(e);}
    }
}
