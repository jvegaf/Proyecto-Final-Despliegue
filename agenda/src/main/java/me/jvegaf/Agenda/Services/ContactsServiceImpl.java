package me.jvegaf.Agenda.Services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import me.jvegaf.Agenda.JDBC.DBRepository;
import me.jvegaf.Agenda.Model.Contact;

public class ContactsServiceImpl implements ContactsService {
	
	private final DBRepository db;
	private String mensaje;
	
	public ContactsServiceImpl() {
		this.db = new DBRepository();
	}

	public List<Contact> getAll() {

	}


	@Override
	public Contact getContact(int id) {
		return null;
	}

	@Override
	public void updateContact(Contact contactos) {

	}



	@Override
	public void contactosUpd(Contactos contactos) {
		String sql = "UPDATE contactos SET nombres=?, celular=?, correo=? WHERE id=?";
		
		Connection cn = db.getConnection();
		if (cn != null) {
			try {
				PreparedStatement ps = cn.prepareStatement(sql);
				
				ps.setString(1, contactos.getNombres());
				ps.setInt(2, contactos.getCelular());
				ps.setString(3, contactos.getCorreo());
				ps.setInt(4, contactos.getId());
				
				int exec = ps.executeUpdate();
				
				if (exec == 0) {
					throw new SQLException();
					
				}
				ps.close();
				
			} catch (SQLException e) {
				setMensaje("Problemas para actualizar: " + e.getMessage());
			} finally {
				try {
					cn .close();
				} catch (SQLException ex) {
					setMensaje(ex.getMessage());
				}
			}
		} else {
			setMensaje("Error en conexion: " + db.getMessage());
		}
		
	}
	public String getMessage() {
		return mensaje;
	}
	
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}