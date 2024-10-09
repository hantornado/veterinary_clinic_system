/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import JSP_utils.ListsOfRecords;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Appointment;
import model.Vet;
import repo.AppointmentFacade;
import repo.VetFacade;

/**
 *
 * @author hanto
 */
@WebServlet(name = "Create_appointment", urlPatterns = {"/Create_appointment"})
public class Create_appointment extends HttpServlet {

    @EJB
    private VetFacade vetFacade;


    @EJB
    private AppointmentFacade appointmentFacade;

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
        String yearStr = request.getParameter("year");
        String monthStr = request.getParameter("month");
        String dayStr = request.getParameter("day");
        String hourStr = request.getParameter("hour");
        String minuteStr = request.getParameter("minute");
        String assigned_vet = request.getParameter("assigned_vet");
        String cust_uname = request.getParameter("cust_uname");
        String gender = request.getParameter("gender");
        String email_adr = request.getParameter("email_adr");
        String contact_num = request.getParameter("contact_num");
        String nationality = request.getParameter("nationality");
        String ageStr = request.getParameter("age");
        String pet_name = request.getParameter("pet_name");
        String species = request.getParameter("species");
        int year;
        int month;
        int day;
        int hour;
        int minute;
        int age;
        LocalDateTime appointmentDateTime;
        
        
        try (PrintWriter out = response.getWriter()) {
            
            try {
                // check for the format of the appointment date time
                year = Integer.parseInt(yearStr);
                month = Integer.parseInt(monthStr);
                day = Integer.parseInt(dayStr);
                hour = Integer.parseInt(hourStr);
                minute = Integer.parseInt(minuteStr);
                age = Integer.parseInt(ageStr);
                appointmentDateTime = LocalDateTime.of(year, month, day, hour, minute, 0);
                
                // check if the assigned vet exists
                List<Vet> allVets = vetFacade.findAll();
                Vet found = null;
                for (Vet v: allVets) {
                    if (v.getUname().equals(assigned_vet)) {
                        found = v;
                        break;
                    }
                }
                if (found == null) {
                    throw new Exception();
                }
                
                
                //check for the length of the customer username
                if (cust_uname.length() == 0 || cust_uname.length() > 8) {
                    throw new Exception();
                }
                
                //check for the length of the pet name
                if (pet_name.length() == 0 || pet_name.length() > 8) {
                    throw new Exception();
                }
                
                // check if the entered gender match any of the provieded gender options
                if (gender.length() > 1 || gender.length() == 0) {
                    throw new Exception();
                }
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
                
                if (age <= 0) {
                    throw new Exception();
                }
                
                
                request.getRequestDispatcher("receptionist/manage_appointments.jsp").include(request, response);
                out.println("<br>The appointment has been successfully added!");
                Appointment new_appointment = new Appointment(assigned_vet, cust_uname, appointmentDateTime, "", "", false, gender.charAt(0), email_adr, contact_num, nationality, age, pet_name, species);                
                appointmentFacade.create(new_appointment);
                // rmb to manipulate the VET_APPOINTMENT, table for the one2many relationship betw vet and appointment
                found.getAppointments().add(new_appointment);
                vetFacade.edit(found);
                List<Appointment> appointments = appointmentFacade.findAll();
                
                ListsOfRecords li = new ListsOfRecords();
                out.println("<br>" + li.listOfAppointments(appointments));
            } catch (Exception e) {
                request.getRequestDispatcher("receptionist/manage_appointments.jsp").include(request, response);
                // Load some existing appointments from the database
                out.println("<br>Invalid inputs while creating the appointment, try again!");
                
                List<Appointment> appointments = appointmentFacade.findAll();
                ListsOfRecords li = new ListsOfRecords();
                out.println("<br>" + li.listOfAppointments(appointments));
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
