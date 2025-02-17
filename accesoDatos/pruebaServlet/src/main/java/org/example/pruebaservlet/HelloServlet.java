package org.example.pruebaservlet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.*;
import dto.Libro;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/LibroServlet")
public class HelloServlet extends HttpServlet {
    private String message;
    private DAO dao;

    public void init() {
        dao = new LibroDao();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/plain");
        PrintWriter out = response.getWriter();
        ObjectMapper mapper = new ObjectMapper();

        for(int i=0;i<dao.readAll().size();i++) {
            out.write(mapper.writeValueAsString(dao.readAll().get(i).toString()));
            out.println();
        }

        /*List<String> campos = new ArrayList<String>();
        List<String> valores = new ArrayList<>();

        if(!request.getParameter("isbn").equals("")) {
            campos.add("isbn");
            valores.add(request.getParameter("isbn"));
        }
        if(!request.getParameter("titulo").equals("")) {
            campos.add("titulo");
            valores.add(request.getParameter("titulo"));
        }
        if(!request.getParameter("autor").equals("")) {
            campos.add("autor");
            valores.add(request.getParameter("autor"));
        }
        if(!campos.isEmpty()) {
            mapper.writeValue(out, dao.readBy(campos,valores));
        }else{
            mapper.writeValue(out, dao.readAll());
        }*/
    }
    public void destroy() {
    }
}