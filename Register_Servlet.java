package register;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
* Servlet implementation class registerservlet
*/
@WebServlet("/registerservlet")
public class registerservlet extends HttpServlet {
private static final long serialVersionUID = 1L;
/**
* @see HttpServlet#HttpServlet()
*/
public registerservlet() {
super();
// TODO Auto-generated constructor stub
}
/**
* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
response)
*/
protected void doGet(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
// TODO Auto-generated method stub
response.getWriter().append("Served at:

").append(request.getContextPath());
}
/**
* @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
response)
*/
protected void doPost(HttpServletRequest request, HttpServletResponse
response) throws ServletException, IOException {
// TODO Auto-generated method stub

//read username and password from login page
String uname = request.getParameter("uname");
String pass = request.getParameter("pass");
String email=request.getParameter("email");
//verify in database

try {
Class.forName("oracle.jdbc.driver.OracleDriver");
System.out.println("driver loaded");
Connection conn = DriverManager.getConnection(

"jdbc:oracle:thin:@localhost:1521:xe","ep","ep123");

System.out.println("connected to database");
PreparedStatement pstmt =

conn.prepareStatement("insert into userlogin1
values('hanuman','1234'hanuman@gmail.com')");
// pstmt.setString(1, uname);
// pstmt.setString(2,pass);
// pstmt.setString(3,email);
int i = pstmt.executeUpdate();
System.out.println(i);

// ResultSet rs = pstmt.executeQuery();

if(i > 0)
{
RequestDispatcher rd =

request.getRequestDispatcher("index.html");

rd.forward(request, response);
}
} catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
e.printStackTrace();
} catch (SQLException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}
}
