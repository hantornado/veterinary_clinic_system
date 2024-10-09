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
@WebServlet(name = "Add_staff_info", urlPatterns = {"/Add_staff_info"})
public class Add_staff_info extends HttpServlet {

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
        String pwd = request.getParameter("pwd");
        String gender = request.getParameter("gender");
        
        
        List<Staff> staffs = staffFacade.findAll();
        Staff found = null;
        try (PrintWriter out = response.getWriter()) {
            // validate the inputs, repetition of uname is not allowed!
            try {
                if (uname.length() > 8 || uname.length() == 0) {
                    throw new Exception();
                }
                
                if (pwd.length() > 8 || pwd.length() == 0) {
                    throw new Exception();
                }
                
                if (gender.length() > 1 || gender.length() == 0) {
                    throw new Exception();
                }
                
                // check if the entered gender match any of the provieded gender options
                char[] gender_options = {'M', 'F'};
                boolean gender_isValid = false;
                for (char gender_option: gender_options) {
                    if (gender.charAt(0) == gender_option) {
                        gender_isValid = true;
                        break;
                    }
                }
                
                if (!gender_isValid) {
                    throw new Exception();
                }
                
                
                for (Staff staff:staffs) {
                    // check for repetition of username
                    if (staff.getUname().equals(uname)) {
                        found = staff;
                        break;
                    } 
                }
                
                if (found != null) {
                    request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
                    out.println("The username has been registered, try again.");
                    out.println("<br><table><tr>\n" +
                        "    <th>Username</th>\n" +
                        "    <th>Password</th>\n" +
                        "    <th>Gender</th>\n" +
                        "    <th>Actions</th>\n" +
                        "  </tr>");
                    for (Staff staff: staffs) {
                        out.println("<tr>");
                        out.println("<td>" + staff.getUname() + "</td>");
                        out.println("<td>" + staff.getPwd() + "</td>");
                        out.println("<td>" + staff.getGender() + "</td>");
                        out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(staff.getId()) + "\"></form> ");
                        out.println("<form action=\"Delete_staff_info\" method=\"post\"><input type=\"submit\" value=\"Delete\" name=\"" + String.valueOf(staff.getId()) + "\"></form></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                } else {
                    // register the new staff
                    Staff new_staff = new Staff(uname, pwd, gender.charAt(0));
                    staffFacade.create(new_staff);
                    staffs = staffFacade.findAll();
                    request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
                    out.println("<br><table><tr>\n" +
                    "    <th>Username</th>\n" +
                    "    <th>Password</th>\n" +
                    "    <th>Gender</th>\n" +
                    "    <th>Actions</th>\n" +
                    "  </tr>");
                    for (Staff staff: staffs) {
                        out.println("<tr>");
                        out.println("<td>" + staff.getUname() + "</td>");
                        out.println("<td>" + staff.getPwd() + "</td>");
                        out.println("<td>" + staff.getGender() + "</td>");
                        out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(staff.getId()) + "\"></form> ");
                        out.println("<form action=\"Delete_staff_info\" method=\"post\"><input type=\"submit\" value=\"Delete\" name=\"" + String.valueOf(staff.getId()) + "\"></form></td>");
                        out.println("</tr>");
                    }
                    out.println("</table>");
                }
                
            } catch (Exception e){
                
                request.getRequestDispatcher("managing_staff/manage_staff_info.jsp").include(request, response);
                out.println("Invalid inputs while registration, try again.");
                out.println("<br><table><tr>\n" +
                    "    <th>Username</th>\n" +
                    "    <th>Password</th>\n" +
                    "    <th>Gender</th>\n" +
                    "    <th>Actions</th>\n" +
                    "  </tr>");
                for (Staff staff: staffs) {
                    out.println("<tr>");
                    out.println("<td>" + staff.getUname() + "</td>");
                    out.println("<td>" + staff.getPwd() + "</td>");
                    out.println("<td>" + staff.getGender() + "</td>");
                    out.println("<td><form action=\"Edit_staff_info\" method=\"post\"><input type=\"submit\" value=\"Edit\" name=\"" + String.valueOf(staff.getId()) + "\"></form> ");
                    out.println("<form action=\"Delete_staff_info\" method=\"post\"><input type=\"submit\" value=\"Delete\" name=\"" + String.valueOf(staff.getId()) + "\"></form></td>");
                    out.println("</tr>");
                }
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
