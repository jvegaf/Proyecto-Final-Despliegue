package me.jvegaf.Agenda.Services;

import me.jvegaf.Agenda.Model.Contact;
import me.jvegaf.Agenda.Storage.StorageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GetAllContacstUseCase {

    private StorageRepository repository;

    public GetAllContacstUseCase(StorageRepository rep) {
        this.repository = rep;
    }

    public ArrayList<Contact> execute(){
        ArrayList<Contact> contactsList = null;

        String sql = "SELECT id, nombre, telefono, correo FROM `contactos`";

        Connection conn = null;
        try {
            conn = this.repository.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);

                ResultSet rs = ps.executeQuery();
                contactsList = new ArrayList<Contact>();
                while (rs.next()) {
                    Contact contact = new Contact(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4)
                    );

                    contactsList.add(contact);
                }
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                this.repository.releaseConnection(conn);
            }
        }

        return contactsList;
    }
}
