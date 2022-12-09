package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Salle;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class SalleService implements WebServices<Salle> {

    @Autowired
    private final SalleRepository salleRepository;

    public SalleService(SalleRepository salleRepository) {
        this.salleRepository = salleRepository;
    }

    @Override
    public List<Salle> listes() {
        return this.salleRepository.findAll();
    }

    @Override
    public void add(Salle e) throws GeneralSecurityException {
        this.salleRepository.save(e);
    }

    @Override
    public Salle update(int id_e, Salle e) {
        return this.salleRepository.findById(id_e)
                .map(p->{
                    p.setNom(e.getNom());
                    p.setNombre_place(e.getNombre_place());
                    return this.salleRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention un probleme pour la recuperation de cette salle"));
    }

    @Override
    public void remove(int id_e) {

        Salle salle = this.salleRepository.findById(id_e).get();

        if (salle != null)
            this.salleRepository.delete(salle);
    }

    @Override
    public Salle getById(int id_e) {
        return this.salleRepository.findById(id_e).get();
    }
}
