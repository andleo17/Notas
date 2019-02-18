package com.andres.notas.dao;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Estudiante;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface EstudianteDAO extends IDBConnection{

    default ArrayList<Estudiante> consultarLista() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        
        try (Connection connection = conectarBD()) {
            String query = String.format("SELECT * FROM %s;",
                            TESTUDIANTE);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setId(rs.getInt(TESTUDIANTE_id));
                estudiante.setNombre(rs.getString(TESTUDIANTE_nombre));
                estudiante.setApellidos(rs.getString(TESTUDIANTE_apellidos));
                estudiante.setEmail(rs.getString(TESTUDIANTE_email));
                estudiante.setPassword(rs.getString(TESTUDIANTE_password));
                estudiantes.add(estudiante);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return estudiantes;
    }

    default void agregar(Estudiante estudiante) {
        try (Connection connection = conectarBD()){
            String insert = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?);",
                                TESTUDIANTE,
                                TESTUDIANTE_nombre,
                                TESTUDIANTE_apellidos,
                                TESTUDIANTE_email,
                                TESTUDIANTE_password);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getEmail());
            ps.setString(4, estudiante.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void actualizar(Estudiante estudiante) {
        try (Connection connection = conectarBD()) {
            String update = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ?, %s = ? WHERE %s = ?;",
                                TESTUDIANTE,
                                TESTUDIANTE_nombre,
                                TESTUDIANTE_apellidos,
                                TESTUDIANTE_email,
                                TESTUDIANTE_password,
                                TESTUDIANTE_id);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, estudiante.getNombre());
            ps.setString(2, estudiante.getApellidos());
            ps.setString(3, estudiante.getEmail());
            ps.setString(4, estudiante.getPassword());
            ps.setInt(5, estudiante.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}