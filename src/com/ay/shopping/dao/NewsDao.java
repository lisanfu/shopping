package com.ay.shopping.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

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
	/**获取总页数
	 * @param pageSize
	 * @return
	 */
	public int getNewsCount(int pageSize)
	{
		int pageCount = 0;
		int newsCount = 0;//获取新闻列表总数
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as newsCount from newsinfo";
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				newsCount = rs.getInt("newsCount");
			}
			//页数计算
			if(newsCount % pageSize == 0)
			{
				pageCount = newsCount / pageSize;
			}else
			{
				pageCount = newsCount / pageSize+1;
			}
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			ConnDB.close(rs, stmt, conn);
		}
		return pageCount;	
	}
	/**新闻列表数据分页
	 * 更具当前页数和每页现实的行数来查询相应的结果
	 * @param pageSize
	 * 			每页现实的行数
	 * @param pageNow
	 * 			当前页数
	 * @return
	 */
	public ArrayList<NewsInfo> getNewsForPage(int pageSize,int pageNow)
	{
		ArrayList<NewsInfo> newsList = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		/*String sql = "select Top " + pageSize +
				"* from newsinfo where newsid not in(select Top(" +
				pageSize + " *(" +pageNow +"- 1)) newsid from newsinfo";
				*/
		String sql = "select * from newsinfo where newsId not in(select newsid from (select * from newsinfo limit "+pageSize*(pageNow-1)+" )as foo ) limit "+pageSize;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				if(newsList == null)
				{
					newsList = new ArrayList<NewsInfo>();
				}
				NewsInfo news = new NewsInfo();
				news.setNewsId(rs.getInt("newsid"));
				news.setNewsTitle(rs.getString("newsTitle"));
				news.setNewsDate(rs.getString("newsDate"));
				newsList.add(news);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			ConnDB.close(rs, stmt, conn);
		}
		
		return newsList;
	}
	/**根据ID查询新闻的方法
	 * @param newsId
	 * @return
	 */
	public NewsInfo updateNews(int newsId)
	{
		NewsInfo newsInfo = null;
		Connection conn = ConnDB.getConn();
		Statement stmt = null;
		ResultSet rs = null;
		String sql = "select * from newsinfo where newsId= "+newsId;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if(rs.next())
			{
				newsInfo = new NewsInfo();
				newsInfo.setNewsTitle(rs.getString("newsTitle"));
				newsInfo.setNewsContent(rs.getString("newsContent"));
				newsInfo.setNewsDate(rs.getString("newsDate"));
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		finally
		{
			ConnDB.close(rs, stmt, conn);
		}
		return newsInfo;
	}
	/**修改新闻资料的方法
	 * @param newsInfo
	 * @return
	 */
	public int updateNews(NewsInfo newsInfo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn  = ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "update newsInfo set newsTitle=?,newsContent=?"+" where newsId=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, newsInfo.getNewsTitle());
			stmt.setString(2, newsInfo.getNewsContent());
			stmt.setInt(3, newsInfo.getNewsId());
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			ConnDB.close(null, stmt, conn);
		}
		return res;
	}
	/**根据ID删除新闻记录
	 * @param newsId
	 * @return
	 */
	public int deleteNews(int newsId) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = ConnDB.getConn();
		PreparedStatement stmt = null;
		String sql = "delete from newsinfo where newsId=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, newsId);
			res = stmt.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		}
		return res;
	}
}
