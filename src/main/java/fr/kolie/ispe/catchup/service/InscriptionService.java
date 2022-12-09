package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Inscripton;
import fr.kolie.ispe.catchup.beans.KeyComposite;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.CatchupRepository;
import fr.kolie.ispe.catchup.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.security.GeneralSecurityException;
import java.util.List;

@Repository
public class InscriptionService /*implements WebServices<Inscripton> */{
/*
    @Autowired
    private final InscriptionRepository inscriptionRepository;

    @Autowired
    private final CatchupRepository catchupRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository, CatchupRepository catchupRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.catchupRepository = catchupRepository;
    }

    @Override
    public List<Inscripton> listes() {
        return this.inscriptionRepository.findAll();
    }

    @Override
    public void add(Inscripton e) throws GeneralSecurityException {
        this.inscriptionRepository.save(e);
    }

    @Override
    public Inscripton update(int keyComposite, Inscripton e) {
        return null;
    }

    public Inscripton update_inscription(KeyComposite keyComposite, Inscripton e) {
        return this.inscriptionRepository.findById(keyComposite)
                .map(p->{
                    p.setNote(e.getNote());
                    p.setPresent(e.isPresent());
                    p.setHeureRendu(e.getHeureRendu());
                    return this.inscriptionRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention probleme"));
    }

    @Override
    public void remove(int id_e) {

    }

    public void remove_inscription(KeyComposite keyComposite)
    {
        Inscripton inscripton = this.inscriptionRepository.findById(keyComposite).get();

        if(inscripton != null)
            this.inscriptionRepository.delete(inscripton);
    }
    @Override
    public Inscripton getById(int id_e) {
        return null;
    }

    public Inscripton inscriptin_getById(KeyComposite id_e) {
        return this.inscriptionRepository.findById(id_e).get();
    }

 */
}
