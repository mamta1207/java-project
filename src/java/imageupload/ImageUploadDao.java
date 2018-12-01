/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imageupload;

import java.io.InputStream;
import java.sql.*;

public class ImageUploadDao {

    Connection con;
    String url;
    String username;
    String password;
    String query = "INSERT INTO product values (?, ?, ?,?,?)";

    public ImageUploadDao() throws SQLException, ClassNotFoundException {
        url = "jdbc:mysql://localhost:3306/project";
        username = "root";
        password = "";
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
    }

    public String imageUpload(int Product_id, String category,int sellingprice,String phoneno, InputStream is) throws SQLException {

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, Product_id);
        ps.setString(2,category);
        ps.setInt(3,sellingprice);
        ps.setString(4,phoneno);
      
        

        // fetches input stream of the upload file for the blob column
        ps.setBlob(5, is);

        int row = ps.executeUpdate();
        if (row > 0) {
            return "image upload sucessfully";
        }

        return "not inserted";
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        InputStream is = null;
        ImageUploadDao i = new ImageUploadDao();
        String result = i.imageUpload(1, "Bykes",40000,"987652", is);
        System.out.println(result);
    }
}
