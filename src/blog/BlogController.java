package blog;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 土田　悠太
 *
 */
/**
 *
 * ブログを操作するビジネスロジック
 *
 */
public class BlogController {

	/**
	 * シングルトンのインスタンス
	 */
	private static BlogController controller=new BlogController();

	/**
	 * このクラスのインスタンスを取得します。
	 *
	 * @return BlogControllerのインスタンス
	 */
	public static BlogController getInstance(){
		return controller;
	}

	private BlogController(){

	}


	/**
	 * トピックをポスト（登録）します。
	 *
	 * @param topic
	 */
	public void postTopic(Topic topic){
		String sql="INSERT INTO TOPIC(TITLE, CONTENT)"
				+ "VALUES(" + "'" + topic.getTitle() + "'"
				+ ",'" + topic.getContent() + "'" + ")";

		Connection con = null;
		Statement smt = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			smt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			if(smt != null){
				try {
					smt.close();
				} catch (Exception ignore) {

				}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception ignore){

				}
			}
		}
	}


	/**
	 * 全部のトピックを取得します。
	 *
	 * @return トピックのリスト
	 */
	public List<Topic> getTopics(){
		String sql = "SELECT * FROM TOPIC";
		List<Topic> topics = new ArrayList<Topic>();

		Connection con = null;
		Statement smt = null;
		ResultSet rs = null;
		try {
			con = ConnectionManager.getConnection();
			smt = con.createStatement();
			rs = smt.executeQuery(sql);

			while(rs.next()){
				Topic topic=new Topic();
				topic.setId(rs.getInt("ID"));
				topic.setPostDate(rs.getTimestamp("POST_DATE"));
				topic.setTitle(rs.getString("TITLE"));
				topic.setContent(rs.getString("CONTENT"));
				topics.add(topic);
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}finally{
			if(rs != null){
				try{
					rs.close();
				}catch(Exception ignore){

				}
			}
			if(smt != null){
				try{
					smt.close();
				}catch(Exception ignore){

				}
			}
			if(con != null){
				try{
					con.close();
				}catch(Exception ignore){

				}
			}
		}
		return topics;
	}

	public static void main(String[] args){
		BlogController ctrl = BlogController.getInstance();
		List<Topic> topics = ctrl.getTopics();
		for(int i = 0; i < topics.size(); i++){
			System.out.println(topics.get(i));
		}
		System.out.println("END");
	}
}
