package pl.sda.lodz9.filterExample.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;

@WebServlet(name = "UploadServlet", urlPatterns = "/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {

    private static final String FILE_PATH = "C:\\temp\\";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part filePart = request.getPart("file");
        String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
        InputStream fileContent = filePart.getInputStream();

        File uploaded = new File(FILE_PATH + fileName);
        //Apache commons ID
        //FileUtils.copyInputStreamToFile(initialStream, targetFile);

        //Pure java

        byte[] buffer = new byte[fileContent.available()];
        fileContent.read(buffer);

        OutputStream outputStream = new FileOutputStream(uploaded);
        outputStream.write(buffer);

        fileContent.close();
        outputStream.close();

        if(uploaded.exists()){
            request.setAttribute("upload_message", "File uploaded " + fileName + " successfully");
            request.getRequestDispatcher("/adminPanel.jsp").forward(request,response);

        }   else {
            request.setAttribute("upload_message", "File " + fileName + " was not uploaded");
            request.getRequestDispatcher("/adminPanel.jsp").forward(request,response);
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
