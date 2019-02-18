package com.andres.notas.dao;

import static com.andres.notas.database.Database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.andres.notas.database.IDBConnection;
import com.andres.notas.model.Ciclo;
import com.andres.notas.model.Curso;
import com.andres.notas.model.Estudiante;
import com.andres.notas.model.Matricula;
import com.andres.notas.model.Profesor;

public interface MatriculaDAO extends IDBConnection, RubricaDAO {

    default ArrayList<Matricula> consultarLista(Estudiante estudiante, Ciclo ciclo) {
        ArrayList<Matricula> matriculas = new ArrayList<>();

        try (Connection connection = conectarBD()){
            String query = String.format("SELECT * FROM %s WHERE %s = ? AND %s = ?;",
                            TMATRICULA,
                            TMATRICULA_idEstudiante,
                            TMATRICULA_idCiclo);
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, estudiante.getId());
            ps.setInt(2, ciclo.getId());
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Matricula matricula = new Matricula();
                matricula.setCiclo(ciclo);
                matricula.setCurso(Curso.buscar(rs.getInt(TMATRICULA_idCurso)));
                matricula.setEstudiante(estudiante);
                matricula.setProfesor(Profesor.buscar(rs.getInt(TMATRICULA_idProfesor)));
                matricula.setPromedioFinal(rs.getFloat(TMATRICULA_promedioFinal));
                matricula.setRubricas(obtenerRubricas(matricula));
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
            ps.setInt(1, matricula.getCiclo().getId());
            ps.setInt(2, matricula.getCurso().getId());
            ps.setInt(3, matricula.getEstudiante().getId());
            ps.setInt(4, matricula.getProfesor().getId());
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
            ps.setInt(1, matricula.getProfesor().getId());
            ps.setFloat(2, matricula.getPromedioFinal());
            ps.setInt(3, matricula.getCiclo().getId());
            ps.setInt(4, matricula.getCurso().getId());
            ps.setInt(5, matricula.getEstudiante().getId());
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
            ps.setInt(1, matricula.getCiclo().getId());
            ps.setInt(2, matricula.getCurso().getId());
            ps.setInt(3, matricula.getEstudiante().getId());
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}