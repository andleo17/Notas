package com.andres.notas.dao;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Matricula;

public interface MatriculaDAO extends IDBConnection{

    default ArrayList<Matricula> consultarLista() {
        ArrayList<Matricula> matriculas = new ArrayList<>();

        try (Connection connection = conectarBD()){
            String query = String.format("SELECT * FROM %s;",
                            TMATRICULA);
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setIdCiclo(rs.getInt(TMATRICULA_idCiclo));
                matricula.setIdCurso(rs.getInt(TMATRICULA_idCurso));
                matricula.setIdEstudiante(rs.getInt(TMATRICULA_idEstudiante));
                matricula.setIdProfesor(rs.getInt(TMATRICULA_idProfesor));
                matricula.setPromedioFinal(rs.getFloat(TMATRICULA_promedioFinal));
                matricula.setRubricas(matricula.hallarRubricas());
                matriculas.add(matricula);
            }
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matriculas;
    }

    default void agregar(Matricula matricula) {
        try (Connection connection = conectarBD()) {
            String insert = String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES (?, ?, ?, ?);",
                                TMATRICULA,
                                TMATRICULA_idCiclo,
                                TMATRICULA_idCurso,
                                TMATRICULA_idEstudiante,
                                TMATRICULA_idProfesor);
            PreparedStatement ps = connection.prepareStatement(insert);
            ps.setInt(1, matricula.getIdCiclo());
            ps.setInt(2, matricula.getIdCurso());
            ps.setInt(3, matricula.getIdEstudiante());
            ps.setInt(4, matricula.getIdProfesor());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void actualizar(Matricula matricula) {
        try (Connection connection = conectarBD()){
            String update = String.format("UPDATE %s SET %s = ?, %s = ? WHERE %s = ? AND %s = ? AND %s = ?;", 
                                TMATRICULA,
                                TMATRICULA_idProfesor,
                                TMATRICULA_promedioFinal,
                                TMATRICULA_idCiclo,
                                TMATRICULA_idCurso,
                                TMATRICULA_idEstudiante);
            PreparedStatement ps = connection.prepareStatement(update);
            ps.setInt(1, matricula.getIdProfesor());
            ps.setFloat(2, matricula.getPromedioFinal());
            ps.setInt(3, matricula.getIdCiclo());
            ps.setInt(4, matricula.getIdCurso());
            ps.setInt(5, matricula.getIdEstudiante());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    default void eliminar(Matricula matricula) {
        try (Connection connection = conectarBD()) {
            String delete = String.format("DELETE FROM %s WHERE %s = ? AND %s = ? AND %s = ?;", 
                                TMATRICULA,
                                TMATRICULA_idCiclo,
                                TMATRICULA_idCurso,
                                TMATRICULA_idEstudiante);
            PreparedStatement ps = connection.prepareStatement(delete);
            ps.setInt(1, matricula.getIdCiclo());
            ps.setInt(2, matricula.getIdCurso());
            ps.setInt(3, matricula.getIdEstudiante());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}