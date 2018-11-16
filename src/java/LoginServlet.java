import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.*;
import javax.servlet.*;
import java.sql.ResultSet;

/**
 *
 * @author hp
 */
public class LoginServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException
    {
        res.setContentType("text/html; charset=UTF-8");
       // PrintWriter out=res.getWriter();
        String username = req.getParameter("uname");
        String pswd = req.getParameter("pass");
        
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
            s1=rs.getString("fname");
            s2=rs.getString("password");
            
            if(username.equals(s1)&&pswd.equals(s2))
            {
               // out.print("Welcome"+"\n");
                flag=1;
                
            }
        }
            if(flag==1)
                    {
                         res.sendRedirect("index_1.html");
                    }
            else
            {
                 res.sendRedirect("index.html");
            }
        
        }
        catch (IOException | ClassNotFoundException | SQLException e)
        {
            //out.print(e);
        }
    }
    
}
