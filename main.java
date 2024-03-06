import Functions.Studentfunctions;
import Functions.Teacherfunctions;
import model.Admin;
import model.Person;
import model.Student;
import model.Teacher;
import services.StudentServices;
import services.TeacherServices;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
     public static void main(String[] args) {
               Scanner input = new Scanner(System.in);
               Admin admin = new Admin();
               Teacherfunctions teacherfunctions = new Teacherfunctions();
               Studentfunctions studentfunctions=new Studentfunctions();
               String Email, Pass;
               int choice;
               System.out.println("--------------Welcome To School System-------------");
               System.out.println("Plz Enter Email And Password ");
               System.out.print("Email : ");
               Email = input.nextLine();
               System.out.print("Pass : ");
               Pass = input.nextLine();
               if (admin.isAdmin("SchoolSystem@12", "123456")) {
                    while (true) {
                         System.out.println(" 1-Teachers\n 2-Students\n 3-Courses\n 4-Exit (Enter number)");
                         choice = input.nextInt();
                         input.nextLine(); // Consume newline character
                         switch (choice) {
                              case 1: // Teacher
                                   System.out.println("1-Add Teacher\n2-Edit Info\n3-Search about Teacher\n4-Absent Teacher in Day\n5-Reports ");
                                   choice = input.nextInt();
                                   input.nextLine(); // Consume newline character
                                   switch (choice) {
                                        case 1:
                                            teacherfunctions.addTeacher();
                                               break;
                                       case 2:
                                           teacherfunctions.editTeacherInfo();
                                             break;
                                       case 3:
                                           teacherfunctions.searchTeacher();
                                           break;
                                        default:
                                             break;
                                   }
                                   break;
                              case 2: // Student
                                  System.out.println("1-Add Student\n2-Edit Info\n3-Search about Student\n4-Absent Student in Day\n5-Reports ");
                                  choice = input.nextInt();
                                  input.nextLine(); // Consume newline character
                                  switch (choice) {
                                      case 1:
                                          studentfunctions.addStudent();
                                          break;
                                      case 2:
                                          studentfunctions.editStudentInfo();
                                          break;
                                      case 3:
                                          studentfunctions.searchStudent();
                                      default:
                                          break;
                                  }
                                   break;
                              case 3: // Courses
                                   break;
                              case 4: // Exit
                                   System.exit(0);
                              default:
                                   System.out.println("Invalid choice. Please enter a valid option.");
                                   break;
                         }
                    }
               } else {
                    System.out.println("Sorry You aren't the admin :(");
               }
//          //   D:\Projects\SchoolSystem\DB\StudentDB.xlsx
//          System.out.println("Helllo");
//          StudentServices services = new StudentServices();
//          TeacherServices services1=new TeacherServices();
//          //services1.writeToExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx");
//          //services.writeToExcelSheet();
//          List<Student> userList = services.readFromExcelStudent("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx");
//          List<Teacher> userList2 = services1.readFromExcelTeacher("D:\\Projects\\SchoolSystem\\DB\\TeacherDB.xlsx");
//          //services.readDataFromExcel("D:\\Projects\\SchoolSystem\\DB\\StudentDB.xlsx");
//          for (int i=0;i<userList.size();i++)
//          {
//               System.out.println("name "+userList.get(i).getName());
//               System.out.println("Courses  "+userList.get(i).getCourseNames());
//               System.out.println("Grade  "+userList.get(i).getGrade());
//               System.out.println("Est   "+userList.get(i).getEstimation());
//          }
//          System.out.println("/////////////////////////////////////////////////////////////////////");
//          for (int i=0;i<userList2.size();i++)
//          {
//               System.out.println("name "+userList2.get(i).getName());
//               System.out.println("Courses  "+userList2.get(i).getCourseNames());
//               System.out.println("Grade  "+userList2.get(i).getGrads());
//               System.out.println("Est   "+userList2.get(i).getEmail());
//          }
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