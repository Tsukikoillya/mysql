package com.ace.jdbc;
import java.sql.*;
public class skillSet {

	public static user findId(String ID) {
		user u = null;
		Connection cn = DBUtils.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select name,password,year,month,day from user where ID = ?";
		try {
			ps = cn.prepareStatement(sql);
			
			ps.setString(1, ID);
			rs = ps.executeQuery();
			if(rs.next()) {
				u = new user();
				u.setId(ID);
				u.setName(rs.getString(1));
				u.setPassword(rs.getString(2));
				u.setYear(rs.getInt(3));
				u.setmonth(rs.getInt(4));
				u.setday(rs.getInt(5));
			}					
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(rs, ps, cn);
		}
		return u;
	}
	
	public static void insert(user u) {
			Connection cn = DBUtils.getConnection();
			PreparedStatement ps =null;
			String sql = "insert into user(ID,name,password,year,month,day) values(?,?,?,?,?,?)";
			try {
				ps = cn.prepareStatement(sql);
				
				ps.setString(1, u.getId());
				ps.setString(2, u.getName());
				ps.setString(3, u.getPassword());
				ps.setInt(4, u.getYear());
				ps.setInt(5, u.getmonth());
				ps.setInt(6, u.getday());
				
				ps.executeUpdate();
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally {
				DBUtils.close(ps, cn);
			}
		
	}
	
	public static void updata(user u) {
		Connection cn = DBUtils.getConnection();
		PreparedStatement ps = null;
		String sql = "update user set name = ?,password = ?,year = ?,month = ?,day = ? where ID = ?";
		try {
			ps = cn.prepareStatement(sql);
			
			ps.setString(1, u.getName());
			ps.setString(2, u.getPassword());
			ps.setInt(3, u.getYear());
			ps.setInt(4, u.getmonth());
			ps.setInt(5, u.getday());
			ps.setString(6, u.getId());
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(ps, cn);
		}
	}
	
	public static void delete(String id) {
		Connection cn = DBUtils.getConnection();
		PreparedStatement ps =null;
		String sql = "delete from user where id = ?";
		try {
			ps = cn.prepareStatement(sql);
			
			ps.setString(1, id);
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			DBUtils.close(ps, cn);
		}
	}
	

}
