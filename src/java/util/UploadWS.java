package util;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author marcelosiedler
 */
@WebServlet(urlPatterns = {"/UploadWS"})
public class UploadWS extends HttpServlet {

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
        Upload up = new Upload();

        up.setFolderUpload("arquivos");
        String destino;
        //Processo meu formulário
        if (up.formProcess(getServletContext(), request)) {
            if (up.form.containsKey("urldestino")) {
                destino = up.form.get("urldestino");
            } else {
                destino = request.getHeader("referer");
            }

            response.setContentType("text/html;charset=UTF-8");
            StringBuffer sb = new StringBuffer();
            sb.append("<!DOCTYPE html>");
            sb.append("<html>");
            sb.append("<body>");
            sb.append("<form id='formulario' action='");
            sb.append(destino);
            sb.append("' method='post'>");
            for (Map.Entry<String, String> obj : up.form.entrySet()) {
                if (!obj.getKey().contains("ParameterValues")) {
                    sb.append("<input type='hidden' name='");
                    sb.append(obj.getKey());
                    sb.append("' value='");
                    sb.append(obj.getValue());
                    sb.append("' />");
                } else {
                    String nome = obj.getKey().replace("ParameterValues", "");
                    String itens[] = obj.getValue().split(";");
                    for (String iten : itens) {
                        
                        sb.append("<input type='hidden' name='");
                        sb.append(nome);
                        sb.append("' value='");
                        sb.append(iten);
                        sb.append("' />");
                        
                    }
                }
            }

            sb.append("</form><script>formulario.submit()</script></body>");
            sb.append("</html>");

            try (PrintWriter out = response.getWriter()) {
                /* TODO output your page here. You may use following sample code. */
                out.println(sb.toString());

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
