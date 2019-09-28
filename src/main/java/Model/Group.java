package Model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "date")
    private String data;


    //   @OneToMany(mappedBy = "group", cascade = CascadeType.ALL, orphanRemoval = true)
    @OneToMany(mappedBy = "group", orphanRemoval = true)
    private List<Student> students;

    public Group() {
    }

    public Group(String name, String data) {
        this.name = name;
        this.data = data;
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        student.setGroup(this);
        students.add(student);
    }

    public void removeStudent(Student student) {
        students.remove(student);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


    @Override
    public String toString() {
        return "Group{" +
                ", name='" + name + '\'' +
                ", data='" + data + '\'' +
                '}';
    }
}