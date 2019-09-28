package Service;

import DAO.Dao;
import DAO.DaoEntity;
import Model.Group;
import Model.Student;
import org.hibernate.Session;

import java.util.List;

public class ServiceEntity {


    public void addGroup(Group group) {

        Dao dao = new DaoEntity();
        dao.creatGroup(group);
    }

    public void removeGroup(Group group) {

        Dao dao = new DaoEntity();
        dao.deleteGroup(group);

    }

    public void updateGroup(Group group) {

        Dao dao = new DaoEntity();
        dao.updateGroup(group);

    }

    public void removeAllGroup() {


    }

    public List<Group> getAllGroup() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Group").list();
        }
    }

    public List<Student> getStudentsByGroup(Group group) {
        Dao dao = new DaoEntity();
        return dao.getStudentByGroup(group);


    }


}
