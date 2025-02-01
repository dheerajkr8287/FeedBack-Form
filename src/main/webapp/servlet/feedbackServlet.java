package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/feedback")
public class feedbackServlet extends HttpServlet {

    //database details
    private static final String dbURL="jdbc:mysql://localhost:3306/feedback_form";
    private  static final String dbUser="root";
    private  static  final String dbPassword="kakaji";


    //Method to handle POST requests for inserting feedback
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //form data :get the form data

        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String feedbackMessage = req.getParameter("feedback_message");

        // setup  the response
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        //database connection and data insertion
        Connection connection=null;
        PreparedStatement stmt=null;

        try{
//            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            //connecting to db
            connection = DriverManager.getConnection(dbURL, dbUser, dbPassword);

            //sql for insert feedback data
            String insertSQL="insert into feedback (email,phone,feedback_message) values (? ,?, ?)";
            stmt=connection.prepareStatement(insertSQL);

            //set the values from the form data
            stmt.setString(1,email);
            stmt.setString(2,phone);
            stmt.setString(3,feedbackMessage);

            stmt.executeUpdate();

            System.out.println("Feedback data is Successfully inserted into DataBase");

            //response to user after submission



            resp.setContentType("text/html");
            PrintWriter writer1 = resp.getWriter();
            writer1.println("<h1>Feedback servlet Working </h1>");
            writer1.println("""
                    <h2>your form details that you have submitted :</h2>
                    <h4> Email address :%s </h4>
                    <h4> Phone number: %s </h4>
                    <h4> Feedback message :%s </h4>
                    """.formatted(email,phone,feedbackMessage));

            //redirect the page after suceessfull submission
//            resp.sendRedirect("/home");



        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<h3>Error: " + e.getMessage() + "</h3>");
        }
        finally {
            try {
                if (stmt != null) stmt.close();
                if (connection != null) connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbUser,dbPassword);

            String selectSQL = "SELECT email, phone, feedback_message FROM feedback";
            stmt = conn.prepareStatement(selectSQL);
            rs = stmt.executeQuery();

            writer.println("<h2>Feedback Submitted by Users:</h2>");
            while (rs.next()) {
                writer.println("<h3>Email: " + rs.getString("email") + "</h3>");
                writer.println("<h3>Phone: " + rs.getString("phone") + "</h3>");
                writer.println("<h3>Feedback Message: " + rs.getString("feedback_message") + "</h3><hr>");
            }
            System.out.println("Feedback Data is Reading Successfully");
        } catch (Exception e) {
            e.printStackTrace();
            writer.println("<h3>Error: " + e.getMessage() + "</h3>");
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }



}
