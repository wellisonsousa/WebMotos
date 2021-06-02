package br.com.webcarro;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.webcarro.dao.CarroDao;
import br.com.webcarro.model.Carro;


/**
 * Servlet implementation class CarroController
 */
@WebServlet("/CarroController")
public class CarroController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CarroController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CarroDao carroDao = new CarroDao();
		
		List<Carro> carrosList = carroDao.getAllCarros();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(carrosList);
		
		// TODO Auto-generated method stub
		response.getWriter().append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carro u = new Carro(
				request.getParameter("carro-name"),
				request.getParameter("carro-brand"),
				request.getParameter("carro-color")
				);
		
		CarroDao carroDao = new CarroDao();
		
		carroDao.addCarro(u);
		
		response.getWriter().append(u.toString());
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Carro carro = new Carro(
				Long.parseLong(request.getParameter("carro-id")),
				request.getParameter("carro-name"),
				request.getParameter("carro-brand"),
				request.getParameter("carro-color")
				);
		
		CarroDao carroDao = new CarroDao();
		
		carroDao.updateCarro(carro);
		
		response.getWriter().append(carro.toString());
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		long carroId = Long.parseLong(request.getParameter("carro-id"));
		
		CarroDao carroDao = new CarroDao();
		
		carroDao.deleteCarro(carroId);
		
		response.getWriter().append("Success");
	}

}
