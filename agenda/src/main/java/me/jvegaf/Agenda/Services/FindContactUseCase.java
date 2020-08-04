package me.jvegaf.Agenda.Services;

import me.jvegaf.Agenda.Model.Contact;
import me.jvegaf.Agenda.Storage.StorageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindContactUseCase {

    private StorageRepository repository;

    public FindContactUseCase(StorageRepository rep) {
        this.repository = rep;
    }

    public Contact execute(Integer id){

        String sql = "SELECT nombre, telefono, correo FROM contactos where id=?";
        Contact contacto = null;
        Connection conn = null;
        try {
            conn = this.repository.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null){
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                ResultSet rs = ps.executeQuery();
                if (rs.next()){
                    contacto = new Contact(
                            id,
                            rs.getString(1),
                            rs.getInt(2),
                            rs.getString(3)
                    );
                }
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.repository.releaseConnection(conn);
            }
        }
        return contacto;
    }
}
