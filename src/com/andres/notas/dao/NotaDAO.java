package com.andres.notas.dao;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Nota;
import com.andres.notas.model.Rubrica;
import java.sql.SQLException;

public interface NotaDAO extends IDBConnection{

    default ArrayList<Nota> obtenerNotas(Rubrica rubrica){
        ArrayList<Nota> notas = new ArrayList<>();

        try (Connection connection = conectarBD()){
            String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ? AND %s = ? AND %s = ?;", 
                            TNOTA,
                            TNOTA_idCiclo,
                            TNOTA_idCurso,
                            TNOTA_idEstudiante,
                            TNOTA_numeroRubrica);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, rubrica.getMatricula().getCiclo().getId());
            ps.setInt(2, rubrica.getMatricula().getCurso().getId());
            ps.setInt(3, rubrica.getMatricula().getEstudiante().getId());
            ps.setInt(4, rubrica.getNumeroRubrica());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Nota nota = new Nota();
                nota.setRubrica(rubrica);
                nota.setNumeroNota(rs.getInt(TNOTA_numeroNota));
                nota.setNota(rs.getFloat(TNOTA_nota));
                notas.add(nota);
            }
            ps.close();

        } catch (Exception e) {
        }

        return notas;
    }

    default void agregar(Nota nota) throws SQLException {
        try (Connection connection = conectarBD()) {
            String insert = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES (?, ?, ?, ?, ?, ?);",
                                TNOTA,
                                TNOTA_idCiclo,
                                TNOTA_idCurso,
                                TNOTA_idEstudiante,
                                TNOTA_numeroRubrica,
                                TNOTA_numeroNota,
                                TNOTA_nota);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, nota.getRubrica().getMatricula().getCiclo().getId());
            ps.setInt(2, nota.getRubrica().getMatricula().getCurso().getId());
            ps.setInt(3, nota.getRubrica().getMatricula().getEstudiante().getId());
            ps.setInt(4, nota.getRubrica().getNumeroRubrica());
            ps.setInt(5, nota.getNumeroNota());
            ps.setFloat(6, nota.getNota());
            ps.executeUpdate();
            ps.close();
        }
    }

    default void actualizar(Nota nota) throws SQLException {
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
            ps.setInt(2, nota.getRubrica().getMatricula().getCiclo().getId());
            ps.setInt(3, nota.getRubrica().getMatricula().getCurso().getId());
            ps.setInt(4, nota.getRubrica().getMatricula().getEstudiante().getId());
            ps.setInt(5, nota.getRubrica().getNumeroRubrica());
            ps.setInt(6, nota.getNumeroNota());
            ps.executeUpdate();
            ps.close();
        }
    }

    default void eliminar(Nota nota) throws SQLException {
        try (Connection connection = conectarBD()) {
            String delete = String.format("DELETE FROM %s WHERE %s = ? AND %s = ? AND %s = ? AND %s = ? AND %s = ?;", 
                                TNOTA,
                                TNOTA_idCiclo,
                                TNOTA_idCurso,
                                TNOTA_idEstudiante,
                                TNOTA_numeroRubrica,
                                TNOTA_numeroNota);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, nota.getRubrica().getMatricula().getCiclo().getId());
            ps.setInt(2, nota.getRubrica().getMatricula().getCurso().getId());
            ps.setInt(3, nota.getRubrica().getMatricula().getEstudiante().getId());
            ps.setInt(4, nota.getRubrica().getNumeroRubrica());
            ps.setInt(5, nota.getNumeroNota());
            ps.executeUpdate();
            ps.close();
        }
    }

}