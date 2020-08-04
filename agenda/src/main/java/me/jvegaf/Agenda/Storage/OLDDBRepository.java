package me.jvegaf.Agenda.Storage;

import java.sql.Connection;
import java.sql.SQLException;

public class OLDDBRepository {

	private final String database = "agenda_db";
    private final String user = "root";
    private final String pass = "root";


    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://db:3306/" + this.database,
                    this.user, this.pass);

        } catch (SQLException | ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return cn;
    }
}
