/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author hp
 */
public class ForgetPassword extends HttpServlet {

 public void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         PrintWriter out = response.getWriter();   
           
             String email = request.getParameter("Email");
            String phoneno=request.getParameter("phone no");
           
             String s1="";
             String s2="";
           
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamta","root","");
        Statement st=con.createStatement();
        
        ResultSet rs= st.executeQuery("Select * from user2");
        
        int flag=0;
        while(rs.next())
        {
            s1=rs.getString("email");
            s2=rs.getString("phone no");
             
            
            if(email.equals(s1)&&phoneno.equals(s2))
            {
                out.print("ok verified"+"\n");
                flag=1;
           
              //  response.sendRedirect("test.html");
                
            }
           
        }
        }
        catch (Exception e)
        {
            out.print(e);
                             response.sendRedirect("index.html");

        }
    }
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        processRequest(req, res) ;
    }
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
         processRequest(req, res) ;
        
    }
            
            
    }
