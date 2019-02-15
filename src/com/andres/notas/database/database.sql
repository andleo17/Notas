CREATE TABLE estudiante (
    id              SERIAL              PRIMARY KEY,
    nombre          VARCHAR(35)         NOT NULL,
    apellidos       VARCHAR(35)         NOT NULL,
    email           VARCHAR(100)        NOT NULL UNIQUE,
    pass            VARCHAR(20)         NOT NULL
);

CREATE TABLE curso (
    id              SERIAL              PRIMARY KEY,
    nombre          VARCHAR(30)         NOT NULL UNIQUE,
    creditos        INTEGER             NOT NULL
);

CREATE TABLE profesor (
    id              SERIAL              PRIMARY KEY,
    nombre          VARCHAR(35)         NOT NULL,
    apellidos       VARCHAR(35)         NOT NULL,
    email           VARCHAR(100)        NOT NULL UNIQUE
);

CREATE TABLE ciclo (
    id              SERIAL              PRIMARY KEY,
    nombre          VARCHAR(7)          NOT NULL UNIQUE
);

CREATE TABLE matricula (
    idEstudiante    INTEGER             NOT NULL,
    idCurso         INTEGER             NOT NULL,
    idCiclo         INTEGER             NOT NULL,
    idProfesor      INTEGER             NOT NULL,
    promedioFinal   FLOAT               NOT NULL DEFAULT 0,

    CONSTRAINT  pk_matricula
        PRIMARY KEY     (idEstudiante, idCurso, idCiclo),
    CONSTRAINT  fk1_estudiante_matricula
        FOREIGN KEY     (idEstudiante)
        REFERENCES      estudiante,
    CONSTRAINT  fk2_curso_matricula
        FOREIGN KEY     (idCurso)
        REFERENCES      curso,
    CONSTRAINT  fk3_ciclo_matricula
        FOREIGN KEY     (idCiclo)
        REFERENCES      ciclo,
    CONSTRAINT  fk4_profesor_matricula
        FOREIGN KEY     (idProfesor)
        REFERENCES      profesor
);

CREATE TABLE rubrica (
    idEstudiante    INTEGER             NOT NULL,
    idCurso         INTEGER             NOT NULL,
    idCiclo         INTEGER             NOT NULL,
    numeroRubrica   INTEGER             NOT NULL,
    peso            FLOAT               NOT NULL,

    CONSTRAINT  pk_rubrica
        PRIMARY KEY     (idEstudiante, idCurso, idCiclo, numeroRubrica),
    CONSTRAINT  fk_matricula_rubrica
        FOREIGN KEY     (idEstudiante, idCurso, idCiclo)
        REFERENCES      matricula(idEstudiante, idCurso, idCiclo)
);

CREATE TABLE nota (
    idEstudiante    INTEGER             NOT NULL,
    idCurso         INTEGER             NOT NULL,
    idCiclo         INTEGER             NOT NULL,
    numeroRubrica   INTEGER             NOT NULL,
    numeroNota      INTEGER             NOT NULL,
    nota            FLOAT               NOT NULL DEFAULT 0,

    CONSTRAINT  pk_nota
        PRIMARY KEY     (idEstudiante, idCurso, idCiclo, numeroRubrica, numeroNota),
    CONSTRAINT  fk_rubrica_nota
        FOREIGN KEY     (idEstudiante, idCurso, idCiclo, numeroRubrica)
        REFERENCES      rubrica(idEstudiante, idCurso, idCiclo, numeroRubrica)
);
