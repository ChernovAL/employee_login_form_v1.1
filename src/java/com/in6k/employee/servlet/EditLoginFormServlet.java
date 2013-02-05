package com.in6k.employee.servlet;

import com.in6k.employee.Employee;
import com.in6k.employee.domain.EmployeeModel;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.XMLDecoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EditLoginFormServlet extends HttpServlet {
    private final Log logger = LogFactory.getLog(getClass());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeModel employee = getEmployeeObjectFromXmlFile((String) request.getParameter("name"));
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("loginForm.jsp").include(request, response);
    }

    private EmployeeModel getEmployeeObjectFromXmlFile(String employeeName) throws FileNotFoundException {
        File employeeFile = new File("/home/employee/test/" + employeeName + ".xml");
        FileInputStream fileInputStream = new FileInputStream(employeeFile);
        XMLDecoder xmlDecoder = new XMLDecoder(fileInputStream);
        EmployeeModel employee = (EmployeeModel) xmlDecoder.readObject();

        return employee;
    }
}
