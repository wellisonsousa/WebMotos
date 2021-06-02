package br.com.webmoto;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webmoto.dao.MotoDao;
import br.com.webmoto.model.Moto;


/**
 * Servlet implementation class MotoController
 */
@WebServlet("/MotoController")
public class MotoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MotoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MotoDao motoDao = new MotoDao();
		
		List<Moto> motosList = motoDao.getAllMotos();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(motosList);
		
		// TODO Auto-generated method stub
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Moto u = new Moto(
				request.getParameter("moto-name"),
				request.getParameter("moto-brand"),
				request.getParameter("moto-color")
				);
		
		MotoDao motoDao = new MotoDao();
		
		motoDao.addMoto(u);
		
		response.getWriter().append(u.toString());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Moto moto = new Moto(
				Long.parseLong(request.getParameter("moto-id")),
				request.getParameter("moto-name"),
				request.getParameter("moto-brand"),
				request.getParameter("moto-color")
				);
		
		MotoDao motoDao = new MotoDao();
		
		motoDao.updateMoto(moto);
		
		response.getWriter().append(moto.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long motoId = Long.parseLong(request.getParameter("moto-id"));
		
		MotoDao motoDao = new MotoDao();
		
		motoDao.deleteMoto(motoId);
		
		response.getWriter().append("Success");
	}

}
