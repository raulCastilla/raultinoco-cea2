package es.cea.dao.implement;

import java.util.List;
import es.cea.dao.modelo.Solicitud;
import es.cea.dao.modelo.Usuario;
import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoSolicitud extends DaoAbstract<Solicitud>{

        @Override
        public List<Solicitud> getLista() {
                return BibliotecaDB.getInstance().getSolicitudes();
        }

        @Override
        public Solicitud obtener(Object o) throws BibliotecaDaoExcepcion {
                List<Solicitud> solicitud = getLista();
               
                String mail = (String)o;
               
                Solicitud sol=null;
                for(Solicitud s:solicitud)
                        if(s.getUsuario().getCorreo().equals(mail)) sol=s;
                return sol;
        }      
}

