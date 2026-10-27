CREATE DATABASE IF NOT EXISTS dam2_db;

USE dam2_db;

-- Exercici 1: Creació de la taula Professors
CREATE TABLE IF NOT EXISTS Professors (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    cognoms VARCHAR(100) NOT NULL
    );

-- Exercici 2: Inserció de 3 professors d'exemple
INSERT INTO Professors (nom, cognoms) VALUES
    ('Joan', 'García Pérez'),
    ('Maria', 'López Fernández'),
    ('Carles', 'Sánchez Pujol');

-- Exercici 4: taula ModulsProfessionals

-- Esborrem la taula antiga que no seguia l'enunciat
DROP TABLE IF EXISTS ModulProfessional;

-- Creem la taula nova
CREATE TABLE IF NOT EXISTS ModulsProfessionals (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professors(id) ON DELETE SET NULL
);

-- 3 mòduls d'exemple
INSERT INTO ModulsProfessionals (nom, id_professor) VALUES
    ('Accés a Dades', 1),
    ('Programació de serveis', 2),
    ('Programació multimèdia', 3);
