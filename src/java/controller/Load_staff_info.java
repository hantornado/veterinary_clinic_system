/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Staff;
import repo.StaffFacade;


/**
 *
 * @author hanto
 */
@WebServlet(name = "Load_staff_info", urlPatterns = {"/Load_staff_info"})
public class Load_staff_info extends HttpServlet {

    @EJB
    private StaffFacade staffFacade;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        // Loading all staffs info and save them into the session
        List<Staff> staffs = staffFacade.findAll();
        HttpSession s = request.getSession(false);
        Staff user = (Staff)s.getAttribute("user");
        request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
            out.println("<br><table><tr>\n" +
            "    <th>Username</th>\n" +
            "    <th>Password</th>\n" +
            "    <th>Gender</th>\n" +
            "    <th>Actions</th>\n" +
            "  </tr>");
            for (Staff staff: staffs) {
                if (staff.getId() == user.getId()) {
                    // The staffs are not allowed to delete their respective accounts
                    out.println("<tr>");
                    out.println("<td>" + staff.getUname() + "</td>");
                    out.println("<td>" + staff.getPwd() + "</td>");
                    out.println("<td>" + staff.getGender() + "</td>");
                    out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(staff.getId()) + "\"></form> ");
                    out.println("</tr>");
                } else {
                    out.println("<tr>");
                    out.println("<td>" + staff.getUname() + "</td>");
                    out.println("<td>" + staff.getPwd() + "</td>");
                    out.println("<td>" + staff.getGender() + "</td>");
                    out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(staff.getId()) + "\"></form> ");
                    out.println("<form action=\"Delete_staff_info\" method=\"post\"><input type=\"submit\" value=\"Delete\" name=\"" + String.valueOf(staff.getId()) + "\"></form></td>");
                    out.println("</tr>");
                }
            }
            out.println("</table>");
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
