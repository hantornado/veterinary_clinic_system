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
import model.Staff;
import repo.StaffFacade;

/**
 *
 * @author hanto
 */
@WebServlet(name = "Search_staff_info", urlPatterns = {"/Search_staff_info"})
public class Search_staff_info extends HttpServlet {

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
        
        String uname = request.getParameter("uname");
        List<Staff> staffs = staffFacade.findAll();
        Staff found = null;
        for (Staff staff: staffs) {
            if (uname.equals(staff.getUname())) {
                found = staff;
                break;
            }
        }
        
        if (found == null) {
            request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
            try (PrintWriter out = response.getWriter()) {
                out.println("<br>There is no matched result!");
            }
        } else {
            request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
            try (PrintWriter out = response.getWriter()) {
                out.println("<br>Matched result:");
                out.println("<br><table><tr>\n" +
                "    <th>Username</th>\n" +
                "    <th>Password</th>\n" +
                "    <th>Gender</th>\n" +
                "    <th>Actions</th>\n" +
                "  </tr>");       
                out.println("<tr>");
                out.println("<td>" + found.getUname() + "</td>");
                out.println("<td>" + found.getPwd() + "</td>");
                out.println("<td>" + found.getGender() + "</td>");
                out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(found.getId()) + "\"></form> ");
                out.println("<form action=\"Delete_staff_info\" method=\"post\"><input type=\"submit\" value=\"Delete\" name=\"" + String.valueOf(found.getId()) + "\"></form></td>");
                out.println("</tr>");            
                out.println("</table>");
            }
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
