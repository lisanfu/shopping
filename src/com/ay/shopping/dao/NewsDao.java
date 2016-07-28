package com.ay.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ay.shopping.entities.NewsInfo;

/**
 * @author Fu_Yuan
 *
 */
public class NewsDao {
	
	/**添加新闻
	 * @param newsinfo
	 * @return
	 */
	public int addNews(NewsInfo newsInfo)
	{
		int res = 0;
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt  =null;
		String sql = "insert into newsinfo(newsTitle,newsContent,newsDate) values(?,?,default)";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newsInfo.getNewsTitle());
			stmt.setString(2, newsInfo.getNewsContent());
			res = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}

}
