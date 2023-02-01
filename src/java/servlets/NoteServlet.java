/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Note;

/**
 *
 * @author vitor
 */
public class NoteServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String editNote = request.getParameter("edit");
                
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        BufferedReader br = new BufferedReader(new FileReader(new File(path)));
        
        String readTitle = br.readLine();
        String readContent = br.readLine();
        String moreLine = "";
        do {
            moreLine = br.readLine();
            if (moreLine != null) {
                readContent = readContent + "\n" + moreLine;
            }
        } while (moreLine != null);
                        
        br.close();
        
        Note note = new Note(readTitle, readContent);
        request.setAttribute("note", note);
               
        if (editNote != null) {
            getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp")
                .forward(request, response);
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        String path = getServletContext().getRealPath("/WEB-INF/note.txt");
        
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(path, false)));
        
        String printTitle = request.getParameter("title");
        String printContent = request.getParameter("content");
        
        pw.println(printTitle);
        pw.print(printContent);
        
        printContent = printContent.replace("\n", "<br>");
        
        pw.close();
        
        Note note = new Note(printTitle, printContent);
        request.setAttribute("note", note);
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp")
                .forward(request, response);
        
    }

}
