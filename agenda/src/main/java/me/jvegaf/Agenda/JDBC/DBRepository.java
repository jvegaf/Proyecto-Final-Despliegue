package me.jvegaf.Agenda.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBRepository {
	
	private final String database;
    private String message;

    public Connection getConnection() {
        Connection cn = null;

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            cn = java.sql.DriverManager.getConnection(
                    "jdbc:mysql://db:3306/" + this.database,
                    "root", "root");

        } catch (SQLException | ClassNotFoundException ex) {
            setMessage(ex.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return cn;
    }

    public DBRepository() {
        this.database = "agenda_db";
    }

    public DBRepository(String database) {
        this.database = database;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
