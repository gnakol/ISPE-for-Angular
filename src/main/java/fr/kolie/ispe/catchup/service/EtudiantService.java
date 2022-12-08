package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Etudiant;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EtudiantService implements WebServices<Etudiant> {

    @Autowired
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> listes() {
        return this.etudiantRepository.findAll();
    }

    @Override
    public void add(Etudiant e) {

        this.etudiantRepository.save(e);

    }

    @Override
    public Etudiant update(int id_e, Etudiant e) {
        return this.etudiantRepository.findById(id_e)
                .map(p -> {
                    p.setNom(e.getNom());
                    p.setPrenom(e.getPrenom());
                    p.setPhoto(e.getPhoto());
                    return this.etudiantRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention cet id à un probleme"));
    }

    @Override
    public void remove(int id_e) {

        Etudiant etudiant = this.etudiantRepository.findById(id_e).get();

        if(etudiant != null)
            this.etudiantRepository.delete(etudiant);
    }

    @Override
    public Etudiant getById(int id_e) {
        return this.etudiantRepository.findById(id_e).get();
    }
}
