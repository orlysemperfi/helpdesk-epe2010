
package pe.edu.upc.dew.sgr.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import pe.edu.upc.dew.sgr.domain.Requerimiento;
import pe.edu.upc.dew.sgr.domain.Usuario;
import pe.edu.upc.dew.sgr.repository.RequerimientoRepository;
import pe.edu.upc.dew.sgr.service.RequerimientoService;
import pe.edu.upc.dew.sgr.service.UsuarioService;

/**
 *
 * @author Administrador
 */
public class RequerimientoController extends HttpServlet {

    private UsuarioService usuarioService;
    private RequerimientoService requerimientoService;

    ArrayList<Requerimiento> requerimientos =
                new ArrayList<Requerimiento>();

    @Override
    public void init() throws ServletException {
         BeanFactory beanfactory = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
         usuarioService = (UsuarioService) beanfactory.getBean("usuarioService");
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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet RequerimientoController</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet RequerimientoController at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
            */
        } finally { 
            out.close();
        }
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
        processRequest(request, response);
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        //processRequest(request, response);
        String mensaje = "";
        Usuario usuario = null;

        int codigo = Integer.parseInt(request.getParameter("txt_codigo"));

        usuario = usuarioService.getUsuarioPorCodigo(codigo);

        if (usuario==null){
            mensaje = "Usuario no existe";
            request.setAttribute("mensaje", mensaje);
            request.getRequestDispatcher("mensajeerror.jsp").forward(request, response);
        }
        else{
            int cod_usuario = usuario.getCod_usuario();
            String nombre_completo = usuario.getTxt_nombres() + ' ' + usuario.getTxt_apellido_paterno() + ' ' +  usuario.getTxt_apellido_materno();

            List<Requerimiento> requerimientos = requerimientoService.obtenerRequerimientosPorUsuario(cod_usuario);

            request.setAttribute("codusuario", cod_usuario);
            request.setAttribute("nombres", nombre_completo);
            request.setAttribute("requerimientos", requerimientos);
            request.getRequestDispatcher("lista_req_usuario.jsp").forward(request, response);
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
