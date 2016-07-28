package com.ay.shopping.entities;

/**新闻类
 * @author Fu_Yuan
 *
 */
public class NewsInfo {
	private int newsId;
	private String newsTitle;
	private String newsContent;
	private String newsDate;
	public int getNewsId() {
		return newsId;
	}
	public void setNewsId(int newsId) {
		this.newsId = newsId;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public String getNewsDate() {
		return newsDate;
	}
	@Override
	public String toString() {
		return "NewsInfo [newsId=" + newsId + ", newsTitle=" + newsTitle
				+ ", newsContent=" + newsContent + ", newsDate=" + newsDate
				+ "]";
	}
	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	
}
