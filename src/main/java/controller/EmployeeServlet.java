package controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployerDAO;
import model.Employee;
import model.Employer;
import services.EmployeeService;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
    private EmployeeService employeeService;
    private EmployerDAO employerDAO;

    public void init() {
        employeeService = new EmployeeService();
        employerDAO = new EmployerDAO(); // Needed to fetch employers for the dropdown
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        try {
            switch (action) {
                case "new":
                    showNewForm(request, response);
                    break;
                case "insert":
                    insertEmployee(request, response);
                    break;
                case "delete":
                    deleteEmployee(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmployee(request, response);
                    break;
                default:
                    listEmployee(request, response);
                    break;
            }
        } catch (Exception ex) {
            throw new ServletException(ex);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employee> listEmployee = employeeService.getAllEmployee();
        request.setAttribute("listEmployee", listEmployee);
        request.getRequestDispatcher("/WEB-INF/views/employee-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employer> listEmployer = employerDAO.findAll();
        request.setAttribute("listEmployer", listEmployer);
        request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employee existingEmployee = employeeService.getEmployee(id);
        List<Employer> listEmployer = employerDAO.findAll();
        
        request.setAttribute("employee", existingEmployee);
        request.setAttribute("listEmployer", listEmployer);
        request.getRequestDispatcher("/WEB-INF/views/employee-form.jsp").forward(request, response);
    }

    private void insertEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String name = request.getParameter("name");
        BigDecimal monthlySalary = new BigDecimal(request.getParameter("monthlySalary"));
        int employerId = Integer.parseInt(request.getParameter("employerId"));
        
        Employer employer = employerDAO.findById(employerId);
        employeeService.addEmployee(name, monthlySalary, employer);
        response.sendRedirect("employees");
    }

    private void updateEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        BigDecimal monthlySalary = new BigDecimal(request.getParameter("monthlySalary"));
        int employerId = Integer.parseInt(request.getParameter("employerId"));

        Employer employer = employerDAO.findById(employerId);
        Employee employee = new Employee(name, monthlySalary, employer);
        employee.setId(id);
        
        employeeService.updateEmployee(employee);
        response.sendRedirect("employees");
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteEmployee(id);
        response.sendRedirect("employees");
    }
}