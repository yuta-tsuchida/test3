package blog;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * トピックの投稿を行うサーブレット
 */
@WebServlet(name="post", urlPatterns="/post")
public class PostServlet extends HttpServlet {



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perform(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		perform(request, response);
	}

	protected void perform(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		String title = request.getParameter("title");
		String content = request.getParameter("content");
		Topic topic = new Topic();
		topic.setTitle(title);
		topic.setContent(content);
		BlogController ctrl = BlogController.getInstance();
		ctrl.postTopic(topic);
		request.getRequestDispatcher("/read").forward(request, response);
	}

}
