/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.ImagemDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Area;
import modelo.Imagem;

/**
 *
 * @author dappo
 */
@WebServlet(name = "AreaWS", urlPatterns = {"/AreaWS"})
public class AreaWS extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("txtId");
        ImagemDAO dao = new ImagemDAO();
        Imagem imagem = dao.buscarPorChavePrimaria(Long.parseLong(id));
        String[] areas = request.getParameterValues("txtArea");
        List<Area> listAreas = new ArrayList<Area>();
        if(areas!=null){
            for(String area:areas){
                String[] itens = area.split(";");
                Area a = new Area();
                a.setShape(itens[0]);
                a.setCoords(itens[1]);
                a.setHref(itens[2]);
                a.setAlt(itens[3]);
                a.setTitle(itens[4]);
                a.setImagem(imagem);
                listAreas.add(a);
            }
        }
        imagem.setAreas(listAreas);
        dao.alterar(imagem);
        request.setAttribute("imagem", imagem);
        request.setAttribute("listAreas", listAreas);
        RequestDispatcher destino = request.getRequestDispatcher("final.jsp");
        destino.forward(request, response);
    }
}
