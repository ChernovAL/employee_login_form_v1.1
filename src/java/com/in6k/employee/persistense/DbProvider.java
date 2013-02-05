package com.in6k.employee.persistense;

import com.in6k.employee.domain.EmployeeModel;
import com.in6k.employee.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DbProvider implements DataProvider {

    @Override
    public void save(Identifier model) throws IOException {
        Transaction transaction = null;
        Session session = HibernateUtil.getInstance().openSession();
        transaction = session.beginTransaction();
        session.save(model);
        transaction.commit();
    }

    public List getAll() throws SQLException {
        Session session = null;
        List  list = new ArrayList();
        try {
            session = HibernateUtil.getInstance().openSession();
            list = session.createCriteria(EmployeeModel.class).list();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    public void update(EmployeeModel employeeModel) throws SQLException {
        Session session = null;
        try {
            session = HibernateUtil.getInstance().openSession();
            session.beginTransaction();
            session.update(employeeModel);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.getMessage();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}