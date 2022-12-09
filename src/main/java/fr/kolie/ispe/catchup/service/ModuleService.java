package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Matiere;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class ModuleService implements WebServices<Matiere> {

    @Autowired
    private final ModuleRepository moduleRepository;

    public ModuleService(ModuleRepository moduleRepository) {
        this.moduleRepository = moduleRepository;
    }


    @Override
    public List<Matiere> listes() {
        return this.moduleRepository.findAll();
    }

    @Override
    public void add(Matiere e) throws GeneralSecurityException {

        this.moduleRepository.save(e);
    }

    @Override
    public Matiere update(int id_e, Matiere e) {
        return this.moduleRepository.findById(id_e)
                .map(p->{
                    p.setCode(e.getCode());
                    p.setLibelle(e.getLibelle());
                    return this.moduleRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention execption sur ce module"));
    }

    @Override
    public void remove(int id_e) {

        Matiere matiere = this.moduleRepository.findById(id_e).get();

        if(matiere != null)
            this.moduleRepository.delete(matiere);
    }

    @Override
    public Matiere getById(int id_e) {
        return this.moduleRepository.findById(id_e).get();
    }
}
