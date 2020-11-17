package com.example.demo.dao;

import com.example.demo.model.Action;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Component
public class DemoDaoImpl implements  DemoDao{

    private static final String url = "jdbc:postgresql://optumhackathon2020.postgres.database.azure.com:5432/postgres";
    private static final String user = "hacks@optumhackathon2020";
    private static final String pwd = "Instance123";
    private static final String sqlInsertAction = "INSERT INTO hackathon.action_data(device_id, session_id, action_detected) " +
            "VALUES(?,?,?)";
    public int insertAction(Action action) throws  Exception{
        int insertedRows = 0;

        Class.forName("org.postgresql.Driver");
        //DriverManager.register(new org.postgresql.Driver());

        try (Connection conn = DriverManager.getConnection(url, user, pwd);
             PreparedStatement ps = conn.prepareStatement(sqlInsertAction)) {
            ps.setString(1,action.getDeviceId());
            ps.setString(2, action.getSessionId());
            ps.setString(3, action.getActionDetected());

            insertedRows = ps.executeUpdate();
            System.out.println("Inserted Rows to DB:"+insertedRows);
        }
        catch (SQLException e) {
            e.printStackTrace(System.out);
        }

        return insertedRows;
    }
}
