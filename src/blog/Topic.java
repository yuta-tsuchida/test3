package blog;

import java.util.Date;

/**
 * トピックのビーン
 * @author 土田　悠太
 *
 */
public class Topic {

	/**
	 * 連番
	 */
	private int id;

	/**
	 * タイトル
	 */
	private String title;

	/**
	 * 内容
	 */
	private String content;

	/**
	 * 投稿日
	 */
	private Date postDate;

	public String toString(){
		return super.toString()
				+ ",id=" + id
				+ ",title=" + title
				+ ",content=" + content
				+ ",postDate=" + postDate
				;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}


}
