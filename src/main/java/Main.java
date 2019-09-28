
import Service.HibernateSessionFactoryUtil;
import Model.Group;
import Model.Student;
import Service.ServiceEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ServiceEntity serviceEntity = new ServiceEntity();

        List<Group> listGroup = new ArrayList<>();
        listGroup.add(new Group("Java", "26.08.19"));
        listGroup.add(new Group("PHP", "21.09.19"));
        listGroup.add(new Group("Ruby", "22.06.19"));

       /* for (Group group:listGroup) {
            serviceEntity.addGroup(group);
        }*/

        List<Student> studentsJava = new ArrayList<>();
        studentsJava.add(new Student("Alex", 22));
        studentsJava.add(new Student("Norman", 20));
        studentsJava.add(new Student("Ben", 25));
        studentsJava.add(new Student("Natali", 30));

        Group groupJava = listGroup.get(0);

        /*for (Student student:studentsJava) {

            groupJava.addStudent(student);
            student.setGroup(groupJava);
          }
*/

        List<Student> studentsPHP = new ArrayList<>();
        studentsPHP.add(new Student("Tom", 21));
        studentsPHP.add(new Student("Victor", 35));
        studentsPHP.add(new Student("Juli", 27));
        studentsPHP.add(new Student("Olga", 31));

        Group groupPHP = listGroup.get(1);

        /*for (Student student:studentsPHP) {

            groupPHP.addStudent(student);
            student.setGroup(groupPHP);
        }*/

        List<Student> studentsRuby = new ArrayList<>();
        studentsRuby.add(new Student("Sandra", 35));
        studentsRuby.add(new Student("Sam", 23));
        studentsRuby.add(new Student("Anna", 27));

        Group groupRuby = listGroup.get(2);

       /* for (Student student:studentsRuby) {

            groupRuby.addStudent(student);
            student.setGroup(groupRuby);
        }
        for (Group group:listGroup) {
            serviceEntity.updateGroup(group);
        }*/

        List<Student> students = serviceEntity.getStudentsByGroup(groupRuby);
        System.out.println(students.toString());


    }
}
