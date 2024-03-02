package services;

import model.Course;
import model.Person;
import model.Student;
import model.Teacher;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Services {

    public void writeToExcelSheet(String[] row_heading, List<? extends Person> users, String SheetName, String Path ) {

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet(SheetName);
        Row headerRow = spreadsheet.createRow(0);

        // Creating header
        for (int i = 0; i < row_heading.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(row_heading[i]);
        }

        for(int i = 0; i < users.size(); i++) {
            Row dataRow = spreadsheet.createRow(i + 1);
            Person user = users.get(i);
            if (user instanceof Teacher) {
                Teacher teacher = (Teacher) user;
                dataRow.createCell(0).setCellValue(teacher.getName());
                dataRow.createCell(1).setCellValue(String.valueOf(teacher.getGrads()));
                dataRow.createCell(2).setCellValue(String.valueOf(teacher.getCourseNames()));
                dataRow.createCell(3).setCellValue(teacher.getEmail());
                dataRow.createCell(4).setCellValue(teacher.getAddress());

            } else if (user instanceof Student) {
                Student student = (Student) user;
                dataRow.createCell(0).setCellValue(student.getName());
                dataRow.createCell(1).setCellValue(student.getGrade());
                dataRow.createCell(2).setCellValue(student.getEstimation());
                dataRow.createCell(3).setCellValue(String.valueOf(student.getCourseNames()));
            }
        }

        try (FileOutputStream out = new FileOutputStream(new File(Path))) {
            workbook.write(out);
            System.out.println("Write to excel sheet done successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readDataFromExcel(String path) {
        List<Person> userList = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(path)));
            for (Sheet sheet : workbook) {
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);
                    String name = row.getCell(0).getStringCellValue();

                    if (row.getCell(1).getCellType() == CellType.NUMERIC) {
                        // Assuming it's a student
                        double grade = row.getCell(1).getNumericCellValue();
                        char estimation = row.getCell(2).getStringCellValue().charAt(0);
                        List<String> courses = Collections.singletonList(row.getCell(3).getStringCellValue());
                        userList.add(new Student(name, grade, estimation, new Course(courses)));
                    } else {
                        // Assuming it's a teacher
                        System.out.println("Gradd  "+i + "   "+row.getCell(3).getStringCellValue());

                        List<Double> grade = Collections.singletonList(row.getCell(1).getNumericCellValue());
                        String email = row.getCell(3).getStringCellValue();
                        String address = row.getCell(4).getStringCellValue();
                        List<String> courses = Collections.singletonList(row.getCell(2).getStringCellValue());
                        //userList.add(new Teacher(name,grade,new Course(courses),email, address));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }


}
