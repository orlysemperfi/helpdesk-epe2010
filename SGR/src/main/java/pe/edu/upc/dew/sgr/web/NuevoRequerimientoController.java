package pe.edu.upc.dew.sgr.web;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;

import pe.edu.upc.dew.sgr.service.RequerimientoService;

/**
 * @author Orly Forever
 */

public class NuevoRequerimientoController extends HttpServlet {
    private RequerimientoService requerimientoService;

    @Override
    public void init() throws ServletException {
         BeanFactory beanfactory = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
         requerimientoService = (RequerimientoService) beanfactory.getBean("requerimientoService");
    }

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {


    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        String nombres = request.getParameter("nombre");
        int codigo = Integer.parseInt(request.getParameter("codigo"));
        
        request.setAttribute("nombres", nombres);
        request.setAttribute("codigo", codigo);
        request.getRequestDispatcher("nuevo_req.jsp").forward(request, response);
    } 


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        
        int username = Integer.parseInt(request.getParameter("txt_codigo"));
        String asunto = request.getParameter("txt_asunto");
        String detalle = request.getParameter("txt_detalle");
        String mensaje = "";

        int valor = requerimientoService.grabarRequerimiento(username, asunto, detalle);

        if(valor>0){
            mensaje = "Requerimiento registrado";
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("codigo", username);
            request.getRequestDispatcher("mensajeregistro.jsp").forward(request, response);
//            request.setAttribute("codusuario", username);
//            request.setAttribute("nombres", nombre_completo);
//            request.setAttribute("requerimientos", requerimientos);
//            request.getRequestDispatcher("lista_req_usuario.jsp").forward(request, response);
        }else{
            mensaje = "No se pudo registrar el requerimiento";
            request.setAttribute("mensaje", mensaje);
            request.setAttribute("codigo", username);
            request.getRequestDispatcher("mensajeregistro.jsp").forward(request, response);
        }

    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
