package com.in6k.employee.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.XMLDecoder;
import java.io.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.in6k.employee.domain.EmployeeModel;
import com.in6k.employee.persistense.DbProvider;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class EmployeesListServlet extends HttpServlet {
    private final Log logger = LogFactory.getLog(getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        File[] listFiles = new File("/home/employee/test/").listFiles();
        List employeesFromXml = null;
        List employeesFromDatabase = null;

        DbProvider dbProvider = new DbProvider();


        try {
            employeesFromDatabase = dbProvider.getAll();
        } catch (SQLException e) {
            e.getMessage();
        }
        logger.info(employeesFromDatabase);
        employeesFromXml = getList();

        request.setAttribute("employeesFromXml", employeesFromXml);
        request.setAttribute("employeesFromDatabase", employeesFromDatabase);
        request.getRequestDispatcher("employeesList.jsp").include(request, response);
    }

    private List getList() throws FileNotFoundException {
        File dir = new File("/home/employee/test");
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".xml");
            }
        });

        List usersList = new ArrayList();

        for (File file: files){
            FileInputStream os = new FileInputStream(file.getAbsolutePath());
            XMLDecoder decoder = new XMLDecoder(os);
            EmployeeModel employeeModel = (EmployeeModel)decoder.readObject();
            decoder.close();

            usersList.add(employeeModel);
        }
        return usersList;
    }
}
