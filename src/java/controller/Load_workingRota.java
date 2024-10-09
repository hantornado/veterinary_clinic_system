/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.WorkingRota;


import java.util.Comparator;
import repo.WorkingRotaFacade;
 
class RotaSortingComparator implements Comparator<WorkingRota> {
 
    @Override
    public int compare(WorkingRota rota1, WorkingRota rota2) {
        return rota1.getStartingDate().compareTo(rota2.getStartingDate());
    }
}

/**
 *
 * @author hanto
 */
@WebServlet(name = "Load_workingRota", urlPatterns = {"/Load_workingRota"})
public class Load_workingRota extends HttpServlet {

    @EJB
    private WorkingRotaFacade workingRotaFacade;

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
        List<WorkingRota> rotas = workingRotaFacade.findAll();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        Collections.sort(rotas, (new RotaSortingComparator()).reversed());
        
        request.getRequestDispatcher("vet/check_workingRota.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
            
            for (WorkingRota r: rotas) {
                out.println("<br><br><table border=\"1\" width=\"80%\" style=\"margin-left: auto; margin-right: auto;\">");
                out.println("<tr><th>Mon ("+ r.getStartingDate().format(formatter) +") </th> <th>Tue ("+ r.getStartingDate().plusDays(1).format(formatter) +") </th> <th>Wed ("+ r.getStartingDate().plusDays(2).format(formatter) +") </th> <th>Thu ("+ r.getStartingDate().plusDays(3).format(formatter) +") </th> <th>Fri ("+ r.getStartingDate().plusDays(4).format(formatter) +") </th> <th>Sat ("+ r.getStartingDate().plusDays(5).format(formatter) +")</th> <th>Sun ("+ r.getStartingDate().plusDays(6).format(formatter) +") </th></tr>");
                out.println("<tr><td>"+ r.getMondayVet1() +"</td><td>"+ r.getTuesdayVet1() +"</td><td>"+ r.getWednesdayVet1() +"</td><td>"+ r.getThursdayVet1() +"</td><td>"+ r.getFridayVet1()+"</td><td>"+ r.getSaturdayVet1() +"</td><td>"+ r.getSundayVet1() +"</td></tr>");
                out.println("<tr><td>"+ r.getMondayVet2() +"</td><td>"+ r.getTuesdayVet2() +"</td><td>"+ r.getWednesdayVet2() +"</td><td>"+ r.getThursdayVet2() +"</td><td>"+ r.getFridayVet2()+"</td><td>"+ r.getSaturdayVet2() +"</td><td>"+ r.getSundayVet2() +"</td></tr>");
                out.println("<tr><td>"+ r.getMondayVet3() +"</td><td>"+ r.getTuesdayVet3() +"</td><td>"+ r.getWednesdayVet3() +"</td><td>"+ r.getThursdayVet3() +"</td><td>"+ r.getFridayVet3()+"</td><td>"+ r.getSaturdayVet3() +"</td><td>"+ r.getSundayVet3() +"</td></tr>");
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
