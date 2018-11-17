
import static java.awt.event.PaintEvent.UPDATE;
import java.io.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class ForgetPassword extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html; charset=UTF-8");
        //PrintWriter out=res.getWriter();
        String email = req.getParameter("email");
        String pass=req.getParameter("pass");
        String s1 = "";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mamta", "root", "");
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery("Select email, password from user2 where email='"+email+"'");

           if(rs.next()) {
                   String query = "UPDATE user2 SET password = '"+pass+"'  where email='"+email+"'";
                   int i=st.executeUpdate(query);
                   res.sendRedirect("index.html");
                } 
           else
           {
               res.sendRedirect("forget.html");
           }
            }
            
         catch (ClassNotFoundException | SQLException e) {
            //out.print(e);
        }
    }

   
}
