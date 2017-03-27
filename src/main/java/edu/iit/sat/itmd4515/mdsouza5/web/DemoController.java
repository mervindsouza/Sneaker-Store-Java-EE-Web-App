/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.mdsouza5.web;

import edu.iit.sat.itmd4515.mdsouza5.domain.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

/**
 *
 * @author mervin
 */
@WebServlet(name = "DemoController", urlPatterns = {"/ProductValidations"})
public class DemoController extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(DemoController.class.getName());
    
    @Resource
    private Validator validator;

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DemoController</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet DemoController at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    private Product buildProductFromRequestParams(HttpServletRequest request) throws ParseException {
        String productName = request.getParameter("productName");
        //String dateAdd = 
        Date dateAdded = new SimpleDateFormat("MM/dd/yyyy",Locale.US).parse(request.getParameter("dateAdded"));
        String prodCount = request.getParameter("productCount");
        Integer productCount = Integer.parseInt(prodCount);

        Product p = new Product(productName, dateAdded, productCount);
        LOG.info(p.toString());

        return p;

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
        try {
            Product p = buildProductFromRequestParams(request);

            Map messages = new HashMap<String, String>();

            request.setAttribute("messages", messages);
            request.setAttribute("Product", p);

            Set<ConstraintViolation<Product>> violations = validator.validate(p);
            if (violations.isEmpty()) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/confirmationPage.jsp");
                dispatcher.forward(request, response);

            } else {
                messages.put("minNamePastDate", "See Detailed Error Below.");
                messages.put("violations", violations);
                messages.put("violationsSize", "Number of Violations Occured: "+violations.size());
                RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/errorPage.jsp");
                dispatcher.forward(request, response);
            }
        } catch (ParseException ex) {
            Logger.getLogger(DemoController.class.getName()).log(Level.SEVERE, null, ex);
        }

        //response.sendRedirect(request.getContextPath() + "/confirmation.jsp");
        //response.sendRedirect(request.getContextPath() + "/confirmation.jsp");
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
