package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import dao.EmployerDAO;
import model.Employer;

@WebServlet("/employers")
public class EmployerServlet extends HttpServlet {
    private EmployerDAO employerDAO;

    public void init() {
        employerDAO = new EmployerDAO();
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
                    insertEmployer(request, response);
                    break;
                case "delete":
                    deleteEmployer(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "update":
                    updateEmployer(request, response);
                    break;
                default:
                    listEmployer(request, response);
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

    private void listEmployer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Employer> listEmployer = employerDAO.findAll();
        request.setAttribute("listEmployer", listEmployer);
        request.getRequestDispatcher("/WEB-INF/views/employer-list.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/employer-form.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Employer existingEmployer = employerDAO.findById(id);
        request.setAttribute("employer", existingEmployer);
        request.getRequestDispatcher("/WEB-INF/views/employer-form.jsp").forward(request, response);
    }

    private void insertEmployer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String socialReason = request.getParameter("socialReason");
        String activity = request.getParameter("activity");
        
        Employer newEmployer = new Employer(socialReason, activity);
        employerDAO.save(newEmployer);
        response.sendRedirect("employers");
    }

    private void updateEmployer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String socialReason = request.getParameter("socialReason");
        String activity = request.getParameter("activity");

        Employer employer = new Employer(socialReason, activity);
        employer.setId(id);
        
        employerDAO.update(employer);
        response.sendRedirect("employers");
    }

    private void deleteEmployer(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        employerDAO.delete(id);
        response.sendRedirect("employers");
    }
}