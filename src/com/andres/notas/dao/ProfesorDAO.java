package com.andres.notas.dao;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Profesor;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public interface ProfesorDAO extends IDBConnection{

    default ArrayList<Profesor> consultarLista() {
        ArrayList<Profesor> profesores = new ArrayList<>();

        try (Connection connection = conectarBD()){
            String query = String.format("SELECT * FROM %s ORDER BY %s;",
                            TPROFESOR,
                            TPROFESOR_apellidos);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Profesor profesor = new Profesor();
                profesor.setId(rs.getInt(TPROFESOR_id));
                profesor.setNombre(rs.getString(TPROFESOR_nombre));
                profesor.setApellidos(rs.getString(TPROFESOR_apellidos));
                profesor.setEmail(rs.getString(TPROFESOR_email));
                profesores.add(profesor);
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return profesores;
    }

    default void agregar(Profesor profesor) {
        try (Connection connection = conectarBD()) {
            String insert = String.format("INSERT INTO %s (%s, %s, %s) VALUES (?, ?, ?);",
                        TPROFESOR,
                        TPROFESOR_nombre,
                        TPROFESOR_apellidos,
                        TPROFESOR_email);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellidos());
            ps.setString(3, profesor.getEmail());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    default void actualizar(Profesor profesor) {
        try (Connection connection = conectarBD()) {
            String update = String.format("UPDATE %s SET %s = ?, %s = ?, %s = ? WHERE %s = ?", 
                                TPROFESOR,
                                TPROFESOR_nombre,
                                TPROFESOR_apellidos,
                                TPROFESOR_email,
                                TPROFESOR_id);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setString(1, profesor.getNombre());
            ps.setString(2, profesor.getApellidos());
            ps.setString(3, profesor.getEmail());
            ps.setInt(4, profesor.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void eliminar (Profesor profesor) {
        try (Connection connection = conectarBD()) {
            String delete = String.format("DELETE FROM %s WHERE %s = ?", 
                                TPROFESOR,
                                TPROFESOR_id);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, profesor.getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}