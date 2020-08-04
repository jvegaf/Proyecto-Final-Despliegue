package me.jvegaf.Agenda.Services;

import me.jvegaf.Agenda.Model.Contact;
import me.jvegaf.Agenda.Storage.StorageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UpdateContactUseCase {

    private StorageRepository repository;

    public UpdateContactUseCase(StorageRepository rep) {
        this.repository = rep;
    }

    public void execute(Contact contact){

        String sql = "UPDATE contactos SET nombre=?, telefono=?, correo=? WHERE id=?";

        Connection conn = null;
        try {
            conn = this.repository.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, contact.getNombre());
                ps.setInt(2, contact.getTelefono());
                ps.setString(3, contact.getCorreo());
                ps.setInt(4, contact.getId());

                boolean result = ps.execute();
                if (!result) {
                    throw new SQLException();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.repository.releaseConnection(conn);
            }
        }
    }
}
