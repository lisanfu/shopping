package com.ay.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ay.shopping.entities.Admin_UserInfo;
import com.ay.shopping.servlet.Admin_LoginServlet;

public class AdminDao {
	/**后台登录页面
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	public  Admin_UserInfo login(String username,String password)
	{
		Admin_UserInfo user = null;
		Connection conn = ConnDB.getConn();
		ResultSet rs =  null;
		Statement stmt = null;
		String sql = "select * from admin_UserInfo where admin_username= '" 
		+ username + "'and admin_userpwd='" + password + "'";
		try
		{
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				user = new Admin_UserInfo();
				user.setAdmin_username(rs.getString("admin_username"));
			}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}finally
		{
			ConnDB.close(rs,stmt,conn);
		}
		return user;
	}

	/**添加管理员
	 * @param admin
	 * @return
	 */
	public int addAdmin(Admin_UserInfo admin) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn =ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "insert into admin_userinfo(admin_username,admin_userpwd) values(?,?)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getAdmin_username());
			stmt.setString(2, admin.getAdmin_userpwd());
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}
	/**查询所有管理员
	 * @return
	 */
	public ArrayList<Admin_UserInfo> getAll()
	{
		ArrayList<Admin_UserInfo> adminList = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from admin_userinfo";
		try {
			adminList = new ArrayList<Admin_UserInfo>();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next())
			{
				
					
					Admin_UserInfo admin = new Admin_UserInfo();
					admin.setAdmin_userID(rs.getInt("admin_userID"));
					admin.setAdmin_username(rs.getString("admin_username"));
					admin.setAdmin_userpwd(rs.getString("admin_userpwd"));
					adminList.add(admin);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		finally
		{
			ConnDB.close(rs, stmt, conn);
		}
		
		return adminList;
	}
	/**根据ID查询管理员方法
	 * @param userId
	 * @return
	 */
	public  Admin_UserInfo getAdmin(int userId) {
		Admin_UserInfo admin = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from admin_userinfo where admin_userId = " + userId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				admin = new Admin_UserInfo();
				admin.setAdmin_username(rs.getString("admin_username"));
				admin.setAdmin_userpwd(rs.getString("admin_userpwd"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			ConnDB.close(rs, stmt, conn);
		}
		return admin;

	}

	/**修改后台管理员资料方法
	 * @param admin
	 * @return
	 */
	public int updateAdmin(Admin_UserInfo admin) {
		// TODO Auto-generated method stub
		int res = 0;
		
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "update admin_userinfo set admin_username = ?,admin_userpwd = ?" + "where admin_userId =?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, admin.getAdmin_username());
			stmt.setString(2, admin.getAdmin_userpwd());
			stmt.setInt(3, admin.getAdmin_userID());
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
		}
		finally
		{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}

	public int deleteAdmin(int userId) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "delete from admin_userinfo where admin_userId = ? ";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1,userId);
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		finally
		{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}
}

















