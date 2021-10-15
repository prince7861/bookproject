package com.sampana.secondassign;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class JsonToExcel {
    public static void main(String[] args) throws IOException, ParseException {

        FileOutputStream fout=new FileOutputStream(new File("D:\\bookproject\\bookdata.xlsx"));





        Workbook wb=new XSSFWorkbook();
        Sheet sh=wb.createSheet("SheetOne");

        int cnt=0;
        Row row=sh.createRow(0);
        Cell cell=row.createCell(++cnt);

        cell=row.createCell(0);
        cell.setCellValue("Book ID");
        cell=row.createCell(1);
        cell.setCellValue("Book title");
        cell=row.createCell(2);
        cell.setCellValue("category");
        cell=row.createCell(3);
        cell.setCellValue("isbn");
        cell=row.createCell(4);
        cell.setCellValue("noofpages");
        cell=row.createCell(5);
        cell.setCellValue("year");
        cell=row.createCell(6);
        cell.setCellValue("auther");
        cell=row.createCell(7);
        cell.setCellValue("publisher");
        cell=row.createCell(8);
        cell.setCellValue("price");
        cell=row.createCell(9);
        cell.setCellValue("releasedate");


        Scanner sc=new Scanner(System.in);
        System.out.println("How many records you want to enter:");
        int no=sc.nextInt();
        JSONParser parser=new JSONParser();
        FileReader fread=new FileReader("D:\\bookproject\\response.json");
        Object obj=parser.parse(fread);
        JSONObject bookObject=(JSONObject)obj;
        Long bid= (Long) bookObject.get("bid");
        String title=(String)bookObject.get("btitle");
        String category=(String)bookObject.get("category");
        String isbn=(String) bookObject.get("isbn");
        Long noofpages=(Long) bookObject.get("noOfPages");
        Long year=(Long) bookObject.get("year");
        String auther=(String)bookObject.get("auther");
        String publisher=(String)bookObject.get("publisher");
        double prices=(Double) bookObject.get("price");
        String releaseDate=(String) bookObject.get("relaseDate");


        int r=1;
        for(int i=0;i<no;i++)
        {
            Row row1=sh.createRow(r++);

            Cell c1=row1.createCell(0);
            c1.setCellValue(bid);


            Cell c2=row1.createCell(1);
            c2.setCellValue(title);


            Cell c3=row1.createCell(2);
            c3.setCellValue(category);

            Cell c4=row1.createCell(3);
            c4.setCellValue(isbn);

            Cell c5=row1.createCell(4);
            c5.setCellValue(noofpages);

            Cell c6=row1.createCell(5);
            c6.setCellValue(year);

            Cell c7=row1.createCell(6);
            c7.setCellValue(auther);

            Cell c8=row1.createCell(7);
            c8.setCellValue(publisher);

            Cell c9=row1.createCell(8);
            c9.setCellValue(prices);

            Cell c10=row1.createCell(9);
            c10.setCellValue(releaseDate);



        }
        wb.write(fout);
        System.out.println("File saved successfully");
        fout.close();
        sc.close();

    }

}
