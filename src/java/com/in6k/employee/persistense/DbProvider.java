package com.in6k.employee.persistense;

import com.in6k.employee.hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class DbProvider implements DataProvider {

    @Override
    public void save(Identifier model) throws IOException {
        Transaction transaction = null;
        Session session = HibernateUtil.getInstance().openSession();
        transaction = session.beginTransaction();
        session.save(model);
        transaction.commit();
    }
}
