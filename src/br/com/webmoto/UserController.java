package br.com.webmoto;

import java.io.IOException;
import java.util.List;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webmoto.dao.UserDao;
import br.com.webmoto.model.User;

/**
 * Servlet implementation class UserApi
 * 
 * CRUD - 
 * 
 */

@WebServlet("/user")
public class UserApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserApi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setStatus(418); //200 - OK - PadrÃ£o (Default)

		String userId = request.getParameter("user-id");
		
	    if(userId != null) {
	    	long id = Long.valueOf(userId);
	    	
	    	UserDao userDao = new UserDao();
	    	
	        User user = userDao.getUserById(id);
	     	Gson gson = new Gson();
	    	response.getWriter().append(gson.toJson(user));
	    	
	    } else {
	    	
	    	UserDao userDao = new UserDao();
	    	
	    	List<User> users = userDao.getAllUser();
	        
	    	Gson gson = new Gson();

	    	response.getWriter().append(gson.toJson(users));

	    } //if
		
		
	} //doGet

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		User u = new User(
				request.getParameter("user-id"),
				request.getParameter("user-name"),
				request.getParameter("user-email"),
				request.getParameter("user-color")
				);
		
		UserDao userDao = new UserDao();
		
		userDao.addUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Ajustar errors com try catch
		response.setContentType("application/json");
		User u = new User(
				request.getParameter("user-id"),
				request.getParameter("user-name"),
				request.getParameter("user-email"),
				request.getParameter("user-color")
				);
		UserDao userDao = new UserDao();
		
		userDao.updateUser(u);
		
		System.out.println(u);
		
		response.getWriter().append(u.toString());
		
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setStatus(418); //200 - OK - PadrÃ£o (Default)

		if (request.getParameter("user-id") == null)
			 response.sendError(407, "Informe o ID do usuÃ¡rio a ser retornado!!!" );
		else {
		Long userId = Long.valueOf(request.getParameter("user-id"));
		
		
		
		UserDao ud = new UserDao();
		
		ud.deleteUser(userId);
		
		response.getWriter().append(request.getParameter("user-id") + " User removido");
		}
	}

}
