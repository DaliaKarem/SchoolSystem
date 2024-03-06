package services;

import Functions.Teacherfunctions;
import model.Course;
import model.Person;
import model.Student;
import model.Teacher;
import org.apache.poi.ss.formula.functions.T;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.*;

public abstract class Services {

    public void writeToExcelSheet(String[] row_heading, List<? extends Person> users, String SheetName, String Path) {
        try (FileInputStream inputStream = new FileInputStream(new File(Path));
             XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {

            XSSFSheet spreadsheet = workbook.getSheet(SheetName);
            if (spreadsheet == null) {
                spreadsheet = workbook.createSheet(SheetName);
                createHeaderRow(spreadsheet.createRow(0), row_heading);
            }

            int lastRowNum = spreadsheet.getLastRowNum();
            int newRowNum = lastRowNum + 1;

            for (Person user : users) {
                Row dataRow = spreadsheet.createRow(newRowNum++);

                if (user instanceof Teacher) {
                    writeTeacherData(dataRow, (Teacher) user);
                } else if (user instanceof Student) {
                    writeStudentData(dataRow, (Student) user);
                }
            }

            try (FileOutputStream out = new FileOutputStream(new File(Path))) {
                workbook.write(out);
                System.out.println("Write to excel sheet done successfully.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createHeaderRow(Row headerRow, String[] row_heading) {
        for (int i = 0; i < row_heading.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(row_heading[i]);
        }
    }
    private void writeTeacherData(Row dataRow, Teacher teacher) {
        dataRow.createCell(0).setCellValue(teacher.getId());
        dataRow.createCell(1).setCellValue(teacher.getName());
        dataRow.createCell(2).setCellValue(teacher.getAge());
        dataRow.createCell(3).setCellValue(String.valueOf(teacher.getGrads_Course()));
        dataRow.createCell(4).setCellValue((long) teacher.getPhone());
        dataRow.createCell(5).setCellValue(teacher.getEmail());
        dataRow.createCell(6).setCellValue(teacher.getAddress());
        dataRow.createCell(7).setCellValue(teacher.isAbsent());
    }

    private void writeStudentData(Row dataRow, Student student) {
        //		//id, name, grade, 'A', email_Parents, address, course, age, phone, true
        dataRow.createCell(0).setCellValue(student.getId());
        dataRow.createCell(1).setCellValue(student.getName());
        dataRow.createCell(2).setCellValue(student.getGrade());
        dataRow.createCell(3).setCellValue(student.getEstimation());
        dataRow.createCell(4).setCellValue(student.getEmail());
        dataRow.createCell(5).setCellValue(student.getAddress());
        dataRow.createCell(6).setCellValue(String.valueOf(student.getCourseNames()));
        dataRow.createCell(7).setCellValue(student.getAge());
        dataRow.createCell(8).setCellValue((long) student.getPhone());
        dataRow.createCell(9).setCellValue(student.isAbsent());
    }

    public List<Person> readDataFromExcel(String path) {
        List<Person> userList = new ArrayList<>();

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(new File(path)));
            for (Sheet sheet : workbook) {
                for (int i = 1; i <= sheet.getLastRowNum(); i++) {
                    Row row = sheet.getRow(i);

                    if (row.getCell(1).getCellType() == CellType.NUMERIC) {
                        // Assuming it's a student
                        //		//id, name, grade, 'A', email_Parents, address, course, age, phone, true
                        int ID = (int) row.getCell(0).getNumericCellValue();
                        String name = row.getCell(1).getStringCellValue();
                        double Age = row.getCell(2).getNumericCellValue();
                        long Phone  = (long) row.getCell(3).getNumericCellValue();
                        String email = row.getCell(4).getStringCellValue();
                        String address = row.getCell(5).getStringCellValue();
                        Boolean Absent = row.getCell(6).getBooleanCellValue();
                        int grade = (int)row.getCell(7).getNumericCellValue();
                        String estimation = row.getCell(8).getStringCellValue();
                        List<String> courses = Collections.singletonList(row.getCell(9).getStringCellValue());
                        userList.add(new Student(ID,name, grade, estimation,email,address, new Course(courses),Age,Phone,Absent));
                    } else {
                        // Assuming it's a teacher
                        int ID = (int) row.getCell(0).getNumericCellValue();
                        String name = row.getCell(1).getStringCellValue();
                        double Age = row.getCell(2).getNumericCellValue();
                        String grade_Course  = row.getCell(3).getStringCellValue();
                        long Phone  = (long) row.getCell(4).getNumericCellValue();
                        String email = row.getCell(5).getStringCellValue();
                        String address = row.getCell(6).getStringCellValue();
                        Boolean Absent = row.getCell(7).getBooleanCellValue();
                        //List<String> courses = Collections.singletonList(row.getCell(2).getStringCellValue());
                        //"ID","Name","Age","Grade->Course","Phone","Email","Address","Absent"
//public Teacher(int ID, String name, double age, String Grade_Course, Number phone, String Email, String address, String Address,boolean isAbsent) {
                        userList.add(new Teacher(ID,name,Age, grade_Course, Phone, email, address,Absent));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return userList;
    }



}