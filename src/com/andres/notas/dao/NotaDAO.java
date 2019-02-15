package com.andres.notas.dao;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Nota;

public interface NotaDAO extends IDBConnection{

    default ArrayList<Nota> consultarLista() {
        ArrayList<Nota> notas = new ArrayList<>();
        
        try (Connection connection = conectarBD()) {
            String query = String.format("SELECT * FROM %s;",
                            TNOTA);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Nota nota = new Nota();
                nota.setIdCiclo(rs.getInt(TNOTA_idCiclo));
                nota.setIdCurso(rs.getInt(TNOTA_idCurso));
                nota.setIdEstudiante(rs.getInt(TNOTA_idEstudiante));
                nota.setNumeroRubrica(rs.getInt(TNOTA_numeroRubrica));
                nota.setNumeroNota(rs.getInt(TNOTA_numeroNota));
                nota.setNota(rs.getFloat(TNOTA_nota));
                notas.add(nota);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return notas;
    }

    default void agregar(Nota nota) {
        try (Connection connection = conectarBD()) {
            String insert = String.format("INSERT INTO %s (%s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?);",
                                TNOTA,
                                TNOTA_idCiclo,
                                TNOTA_idCurso,
                                TNOTA_idEstudiante,
                                TNOTA_numeroRubrica,
                                TNOTA_numeroNota);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, nota.getIdCiclo());
            ps.setInt(2, nota.getIdCurso());
            ps.setInt(3, nota.getIdEstudiante());
            ps.setInt(4, nota.getNumeroRubrica());
            ps.setInt(5, nota.getNumeroNota());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void actualizar(Nota nota) {
        try (Connection connection = conectarBD()){
            String update = String.format("UPDATE %s SET %s = ? WHERE %s = ? AND %s = ? AND %s = ? AND %s = ? AND %s = ?;",
                                TNOTA,
                                TNOTA_nota,
                                TNOTA_idCiclo,
                                TNOTA_idCurso,
                                TNOTA_idEstudiante,
                                TNOTA_numeroRubrica,
                                TNOTA_numeroNota);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setFloat(1, nota.getNota());
            ps.setInt(2, nota.getIdCiclo());
            ps.setInt(3, nota.getIdCurso());
            ps.setInt(4, nota.getIdEstudiante());
            ps.setInt(5, nota.getNumeroRubrica());
            ps.setInt(6, nota.getNumeroNota());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void eliminar(Nota nota) {
        try (Connection connection = conectarBD()) {
            String delete = String.format("DELETE FROM %s WHERE %s = ? AND %s = ?, %s = ?, %s = ?, %s = ?;", 
                                TNOTA,
                                TNOTA_idCiclo,
                                TNOTA_idCurso,
                                TNOTA_idEstudiante,
                                TNOTA_numeroRubrica,
                                TNOTA_numeroNota);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, nota.getIdCiclo());
            ps.setInt(2, nota.getIdCurso());
            ps.setInt(3, nota.getIdEstudiante());
            ps.setInt(4, nota.getNumeroRubrica());
            ps.setInt(5, nota.getNumeroNota());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}