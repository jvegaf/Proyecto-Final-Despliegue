package me.jvegaf.Agenda.Services;

import me.jvegaf.Agenda.Storage.StorageRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RemoveContactUseCase {

    private StorageRepository repository;

    public RemoveContactUseCase(StorageRepository rep) {
        this.repository = rep;
    }

    public void execute(Integer id){
        String sql = "DELETE FROM contactos WHERE id=?";

        Connection conn = null;
        try {
            conn = this.repository.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);
                boolean result = ps.execute();
                if (!result) throw new SQLException();
                ps.close();

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
            this.repository.releaseConnection(conn);
            }
        }
    }
}
