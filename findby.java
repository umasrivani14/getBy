package getby;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class findby {
	private static final String Driver="com.mysql.cj.jdbc.Driver";
	private static final String Username="root";
	private static final String Password="root";
	private static final String Url="jdbc:mysql://localhost:3306/crudoperations";
	private static Connection conn;
	private static PreparedStatement pmst;
	public static void main(String[] args) {
		try
		{
			Scanner src=new Scanner(System.in);
			Class.forName(Driver);
			conn=DriverManager.getConnection(Url, Username, Password);
			String sql="select * from student where branch=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter the branch:");
			pmst.setString(1,src.next());
			ResultSet rs=pmst.executeQuery();
			while(rs.next()) {
				System.out.println("name:"+rs.getString("name"));
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
