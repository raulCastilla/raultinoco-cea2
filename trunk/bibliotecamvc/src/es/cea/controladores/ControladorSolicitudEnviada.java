package es.cea.controladores;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.cea.dao.modelo.Usuario;
import es.cea.dao.Dao;
import es.cea.dao.implement.DaoSolicitud;
import es.cea.dao.implement.DaoUsuario;
import es.cea.dao.modelo.Solicitud;
import es.cea.recursos.AtributosConstantes;

//controla que la solicitud se ha creado correctamente

public class ControladorSolicitudEnviada extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ControladorSolicitudEnviada() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
