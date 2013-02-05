package com.in6k.employee.servlet;

import com.in6k.employee.Employee;
import com.in6k.employee.domain.EmployeeModel;
import com.in6k.employee.form.EmployeeForm;
import com.in6k.employee.persistense.ProviderFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class EmployeeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmployeeForm employeeForm = new EmployeeForm();

        employeeForm.setName(request.getParameter("name"));
        employeeForm.setSurname(request.getParameter("surname"));
        employeeForm.setBirthday(request.getParameter("birthday"));
        employeeForm.setEmail(request.getParameter("email"));
        employeeForm.setPassword(request.getParameter("password"));
        employeeForm.setPassword_confirm(request.getParameter("pass_confirm"));

        List errorsList = employeeForm.validate();
        boolean hasError = errorsList.size() > 0;

        if(hasError) {
            Employee employee = new Employee(employeeForm.getName(), employeeForm.getSurname(), employeeForm.getBirthday(), employeeForm.getEmail(), employeeForm.getPassword());
            request.setAttribute("errorsList", errorsList);
            request.setAttribute("employee", employee);
            request.getRequestDispatcher("loginForm.jsp").include(request,response);
            return;
        }

        EmployeeModel employeeModel = new EmployeeModel(employeeForm, ProviderFactory.ProviderType.DB);
        employeeModel.save();

        response.sendRedirect("/employeeList");
    }
}
