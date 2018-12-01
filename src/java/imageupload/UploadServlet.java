/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageupload;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@WebServlet("/UploadServlet")
@MultipartConfig(maxFileSize = 16177215) 
public class UploadServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        int productid = Integer.parseInt(request.getParameter("Product_id"));
        String category = request.getParameter("category");
        int sellingprice = Integer.parseInt(request.getParameter("selling_price"));
        String phoneno = request.getParameter("phone_no");
         
        InputStream is = null;
        Part img = request.getPart("image");
        
        is = img.getInputStream();
        
        ImageUploadDao i = null;
        try {
            i = new ImageUploadDao();
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        String result = null;
        try {
            result = i.imageUpload(productid,category ,sellingprice,phoneno,is);
        } catch (SQLException ex) {
            Logger.getLogger(UploadServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        // out.println(result);
        if(result.equals("image upload sucessfully"))
        {
            response.sendRedirect("frontend.jsp");
        }
        else
        {
            out.println("invalid login details");
            response.sendRedirect("signin.html");
        }
    }
}
