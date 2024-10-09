/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
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
@WebServlet(name = "Save_staff_info", urlPatterns = {"/Save_staff_info"})
public class Save_staff_info extends HttpServlet {

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
        
        HttpSession s = request.getSession(false);
        Staff user = (Staff)s.getAttribute("user");
        List<Staff> staffs = staffFacade.findAll();
        long staffID2beEdited = (long)s.getAttribute("staffID2BeEdited");
        String new_pwd = request.getParameter("pwd");
        String new_gender = request.getParameter("gender");
        if (staffID2beEdited == user.getId()) {
            // If the login user is Ali, and he is updating his info.
            user.setPwd(new_pwd);
            user.setGender(new_gender.charAt(0));
            staffFacade.edit(user);
        } else {
            // If the login user is Ali, and he is updating others' info.
            staffFacade.updateByID(staffID2beEdited, new_pwd, new_gender.charAt(0));
        }
        
        
        request.getRequestDispatcher("Load_staff_info").forward(request, response);
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
