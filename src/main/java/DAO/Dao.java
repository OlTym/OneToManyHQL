package DAO;

import Model.Group;
import Model.Student;

import java.util.List;

public interface Dao {

    void creatGroup(Group group);

    void deleteGroup(Group group);

    void updateGroup(Group group);


    int deleteGroupByName(Group group);

    public List<Group> getAllGroup();

    public List<Student> getStudentByGroup(Group group);
}
