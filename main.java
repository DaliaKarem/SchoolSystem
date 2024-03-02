import model.Person;
import model.Student;
import model.Teacher;
import services.StudentServices;
import services.TeacherServices;

import java.util.List;

public class main {
     public static void main(String[] args) {
          //   D:\Projects\SchoolSystem\DB\StudentDB.xlsx
          System.out.println("Helllo");
          StudentServices services = new StudentServices();
          TeacherServices services1=new TeacherServices();
          //services1.writeToExcel();
          //services.writeToExcelSheet();
          List<Student> userList = services.readFromExcelStudent("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx");
          List<Teacher> userList2 = services1.readFromExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx");
          //services.readDataFromExcel("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx");
//          for (int i=0;i<userList.size();i++)
//          {
//               System.out.println("name "+userList.get(i).getName());
//               System.out.println("Courses  "+userList.get(i).getCourseNames());
//               System.out.println("Grade  "+userList.get(i).getGrade());
//               System.out.println("Est   "+userList.get(i).getEstimation());
//          }
          System.out.println("/////////////////////////////////////////////////////////////////////");
          for (int i=0;i<userList2.size();i++)
          {
               System.out.println("name "+userList2.get(i).getName());
               System.out.println("Courses  "+userList2.get(i).getCourseNames());
               System.out.println("Grade  "+userList2.get(i).getGrads());
               System.out.println("Est   "+userList2.get(i).getEmail());
          }
     }

     }

/**
 * وصف المشروع:
تطوير نظام شامل لإدارة المدرسة يستخدم تقنيات Java المتقدمة. يهدف هذا النظام إلى توفير حل شامل لإدارة جميع جوانب العمل في المدرسة بشكل إلكتروني، مما يسهل على الإدارة والمعلمين والطلاب التفاعل والتواصل بشكل أفضل.

ميزات المشروع:

إدارة المعلمين والطلاب: يتيح النظام للمدرسة إدارة بيانات المعلمين والطلاب، بما في ذلك إضافة، تعديل، وحذف سجلاتهم.

نظام حضور وغياب: يمكن للمعلمين تسجيل الحضور والغياب للطلاب، ويمكن للطلاب عرض سجلات حضورهم وغيابهم.

نظام إدارة الدورات والصفوف الدراسية: يسمح النظام بتخصيص الدورات والصفوف الدراسية وإدارة جداول الفصول والمواد الدراسية المقررة.

نظام تقييم الطلاب والتقارير: يتيح النظام للمعلمين إضافة تقييمات للطلاب وإنشاء تقارير عن أداء الطلاب، وكذلك يمكن للطلاب عرض تقارير أدائهم.

تواصل الطلاب وأولياء الأمور: يتيح النظام تواصلًا فعّالًا بين المعلمين والطلاب وأولياء الأمور من خلال نظام رسائل داخلي وإشعارات.

نظام مكتبة المدرسة: يمكن للمستخدمين إدارة مكتبة المدرسة، بما في ذلك إضافة وحذف الكتب وإدارة عمليات الاستعارة.

تحليلات وإحصائيات: يوفر النظام تقارير وإحصائيات حول أداء الطلاب والمعلمين والفصول الدراسية لمساعدة الإدارة في اتخاذ القرارات الاستراتيجية.

تقنيات البرمجة المتقدمة المستخدمة:

Java Servlets و JSP (JavaServer Pages): لبناء واجهة المستخدم الديناميكية وإدارة طلبات HTTP.

Java Persistence API (JPA): للتفاعل مع قاعدة البيانات وإدارة الكائنات المستمرة.

Spring Framework: لإدارة الحاويات والتكامل مع مكتبات أخرى مثل Spring MVC و Spring Security.

Hibernate: لتسهيل عمليات البحث والحفظ والتحديث في قاعدة البيانات.

HTML/CSS/JavaScript: لتطوير واجهة المستخدم الرسومية وتحسين تفاعل المستخدم.

MySQL أو PostgreSQL: لإنشاء وإدارة قاعدة البيانات.

هذا المشروع الضخم سيكون فرصة رائعة لتطبيق المفاهيم المتقدمة في Java وبناء تطبيق شامل يساهم في تحسين العملية التعليمية في المدرسة.
**/