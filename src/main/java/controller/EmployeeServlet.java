package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import dao.EmployerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Employee;
import model.Employer;
import services.EmployeeService;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {

    private EmployeeService employeeService = new EmployeeService();
    private EmployerDAO employerDAO = new EmployerDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> employees = employeeService.getAllEmployee();

        request.setAttribute("employees", employees);

        request.getRequestDispatcher("/WEB-INF/views/Employees.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        BigDecimal salary = new BigDecimal(request.getParameter("salary"));

        int employerId = Integer.parseInt(request.getParameter("employerId"));

        Employer employer = employerDAO.findById(employerId);

        employeeService.addEmployee(name, salary, employer);

        response.sendRedirect("employees");
    }
}