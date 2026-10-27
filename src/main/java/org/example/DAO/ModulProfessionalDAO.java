
package org.example.DAO;

import org.example.Model.ModulProfessional;
import java.util.List;

public interface ModulProfessionalDAO {

    void addDam2(ModulProfessional modul);

    void deleteDam2(int id);

    void updateDam2(ModulProfessional modul);

    List<ModulProfessional> readDam2();
}
