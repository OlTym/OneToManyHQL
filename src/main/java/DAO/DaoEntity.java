package DAO;

import Model.Group;
import Model.Student;
import Service.HibernateSessionFactoryUtil;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class DaoEntity implements Dao {


    @Override
    public void creatGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(group);
            transaction.commit();
        }
    }

    @Override
    public void deleteGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(group);
            transaction.commit();
        }
    }

    @Override
    public void updateGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(group);
            transaction.commit();
        }
    }

    public int removeAllGroup() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Group");
            int count = query.executeUpdate();
            transaction.commit();
            return count;
        }
    }

    @Override
    public int deleteGroupByName(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();
            Query query = session.createQuery("DELETE FROM Group WHERE name = :name");
            query.setParameter("name", group.getName());
            int count = query.executeUpdate();
            transaction.commit();
            return count;

        }
    }

    public List<Group> getAllGroup() {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
            return session.createQuery("From Group").list();
        }
    }

    public List<Student> getStudentByGroup(Group group) {
        try (Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession()) {
        /*    SQLQuery sqlQuery= session.createSQLQuery("SELECT students.\"name\", age  FROM students inner join \"groups\" " +
                    "on students.group_id=\"groups\".id WHERE \"groups\".\"name\"=:a").setParameter("a",group.getName());

            sqlQuery.addEntity(Student.class);
            return sqlQuery.list();*/
            return session.createQuery("Select s.name From Student s inner join  Group  g on s.group_id=g.id where groups.name=:name").setParameter("name", group.getName()).list();
        }


    }


}
