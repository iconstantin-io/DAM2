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

-- Exercici 4: Creació de la taula ModulProfessional
CREATE TABLE IF NOT EXISTS ModulProfessional (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    hores INT NOT NULL,
    id_professor INT,
    FOREIGN KEY (id_professor) REFERENCES Professors(id) ON DELETE SET NULL
    );

-- Inserció de mòduls d'exemple
INSERT INTO ModulProfessional (nom, hores, id_professor) VALUES
    ('Accés a Dades', 120, 1),
    ('Desenvolupament d Interfaces', 90, 2);
