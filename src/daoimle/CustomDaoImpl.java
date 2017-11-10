package daoimle;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Custom;
import bean.User;
import dao.CustomDao;
import util.Pool;
public class CustomDaoImpl implements CustomDao{
   
	@Override
	public boolean Login(User user) {
		Connection con = Pool.getConnection();
		String sql = "SELECT * FROM user WHERE username=? AND password=?";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, user.getUsername());
			psmt.setString(2, user.getPassword());
			ResultSet rs = psmt.executeQuery();
			
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public boolean Register(Custom custom) {	
		if (this.Login(new User(custom.getUsername(),custom.getPassword()))) {
			return false;
		}
		Connection con = Pool.getConnection();
		String sql = "INSERT INTO custom(username,password,age,birthday,tel,email) "
				+ "VALUES(?,?,?,?,?,?)";
		String sql2 = "INSERT INTO user(username,password) VALUES(?,?)";
		try {
			PreparedStatement psmt = con.prepareStatement(sql);
			psmt.setString(1, custom.getUsername());
			psmt.setString(2, custom.getPassword());
			psmt.setInt(3, custom.getAge());
			psmt.setDate(4, custom.getBirthday());
			psmt.setString(5, custom.getTel());
			psmt.setString(6, custom.getEmail());
			int tag1 = psmt.executeUpdate();
			PreparedStatement psmt2 = con.prepareStatement(sql2);
			psmt2.setString(1, custom.getUsername());
			psmt2.setString(2, custom.getPassword());
		    int tag2 = psmt2.executeUpdate();
//			if (1==psmt.executeUpdate() && 1==psmt2.executeUpdate()) {
//				System.out.println("Regising..");
//			   return true;	
//			}
		    if (tag1==1 && tag2==1)
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return false;
	}

	@Override
	public List<Custom> getAll() {
		Connection con = Pool.getConnection();
		String sql = "SELECT * FROM custom";
		List<Custom> list = new ArrayList<Custom>();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				list.add(new Custom(rs.getString(1),rs.getString(2),rs.getInt(3)
						,rs.getDate(4),rs.getString(5),rs.getString(6)));
			}
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
    
}
