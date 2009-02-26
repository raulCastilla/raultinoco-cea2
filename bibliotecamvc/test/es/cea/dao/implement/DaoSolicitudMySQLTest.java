package es.cea.dao.implement;


import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import es.cea.dao.Dao;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.dao.modelo.UsuarioNoRegistrado;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoSolicitudMySQLTest {
	DaoSolicitudMySQL daoSolicitud;
	
	@BeforeMethod
	public void iniciarRecursos(){
		Dao<Usuario> daoUsuario = new DaoUsuario(){

			@Override
			public Usuario obtener(Object o) throws BibliotecaDaoExcepcion {
				// TODO Auto-generated method stub
				Usuario usuario = new UsuarioNoRegistrado("","","");
				return usuario;
			}
			
		};
		daoSolicitud = new DaoSolicitudMySQL(daoUsuario);
	}
	
	@Test
	public void agregarSolicitud() throws BibliotecaDaoExcepcion{
		daoSolicitud.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoSolicitud.executeImport("/resources/import.sql");
		
		Solicitud solicitud = new Solicitud(new UsuarioNoRegistrado("","",""));
		daoSolicitud.agregar(solicitud);
		List<Solicitud> solicitudes = daoSolicitud.obtenerLista();
		assert(solicitudes.size()==3);
	}
	
	@Test
	public void obtenerListaSolicitudes() throws BibliotecaDaoExcepcion{
		daoSolicitud.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoSolicitud.executeImport("/resources/import.sql");
		List<Solicitud> soliList = daoSolicitud.obtenerLista();
		assert(soliList.size()==2);
	}
	
	@Test
	public void obtenerSolicitud() throws BibliotecaDaoExcepcion{
		daoSolicitud.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoSolicitud.executeImport("/resources/import.sql");
		
		Solicitud sol = daoSolicitud.obtener("pepe@pepe.com");
		assert(sol!=null);
	}
	
	@Test
	public void eliminarSolicitud() throws BibliotecaDaoExcepcion{
		daoSolicitud.conecta("jdbc:mysql://localhost/biblioteca", "root", "root");
		daoSolicitud.executeImport("/resources/import.sql");
		
		Solicitud solicitud = new Solicitud(new UsuarioNoRegistrado("","pepe@pepe.com",""));
		daoSolicitud.eliminar(solicitud);
		List<Solicitud> solicitudes = daoSolicitud.obtenerLista();
		assert(solicitudes.size()==1);
	}
}
