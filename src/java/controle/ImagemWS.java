/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ImagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Imagem;

/**
 *
 * @author dappo
 */
@WebServlet(name = "ImagemWS", urlPatterns = {"/ImagemWS"})
public class ImagemWS extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String foto = request.getParameter("txtFoto");
        ImagemDAO dao = new ImagemDAO();
        Imagem imagem = new Imagem();
        imagem.setFoto(foto);
        dao.incluir(imagem);
        request.setAttribute("imagem", imagem);
        RequestDispatcher destino = request.getRequestDispatcher("foto.jsp");
        destino.forward(request, response);
    }

   

}
