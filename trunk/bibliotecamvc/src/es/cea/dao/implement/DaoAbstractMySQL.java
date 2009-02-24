package es.cea.dao.implement;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;


import es.cea.excepcion.BibliotecaDaoExcepcion;

public class DaoAbstractMySQL {
	protected Connection connection;

	protected void resetDataBaseConImportSQL() throws BibliotecaDaoExcepcion {
		executeImport( "/resources/import.sql");
	}
	protected void executeImport( String importsql) throws BibliotecaDaoExcepcion {
		String currentdir = System.getProperty("user.dir");
		FileInputStream fstream;
		try {
			fstream = new FileInputStream(currentdir + importsql);
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			while ((strLine = br.readLine()) != null) {
				execute( strLine);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw new BibliotecaDaoExcepcion(e);
		}
	}
	
	protected void execute(String sql) throws SQLException{
		connection.createStatement().executeUpdate(sql);
	}
}
