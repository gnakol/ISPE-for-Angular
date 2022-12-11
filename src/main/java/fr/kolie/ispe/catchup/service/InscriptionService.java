package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Inscription;
import fr.kolie.ispe.catchup.beans.KeyComposite;
import fr.kolie.ispe.catchup.repository.CatchupRepository;
import fr.kolie.ispe.catchup.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscriptionService {

    @Autowired
    private final InscriptionRepository inscriptionRepository;

    @Autowired
    private final CatchupRepository catchupRepository;

    public InscriptionService(InscriptionRepository inscriptionRepository, CatchupRepository catchupRepository) {
        this.inscriptionRepository = inscriptionRepository;
        this.catchupRepository = catchupRepository;
    }

    public List<Inscription> liste_inscription()
    {
        return this.inscriptionRepository.findAll();
    }

    public void add(Inscription e)  {
        this.inscriptionRepository.save(e);
    }

    public Inscription update(int id_etudiant, int ref_catchup, Inscription inscription)
    {
        KeyComposite keyComposite = new KeyComposite(id_etudiant, ref_catchup);

        return this.inscriptionRepository.findById(keyComposite)
                .map(p-> {
                    p.setNote(inscription.getNote());
                    p.setPresent(inscription.isPresent());
                    p.setHeureRendu(inscription.getHeureRendu());
                    p.setEtudiant(inscription.getEtudiant());
                    p.setCatchup(inscription.getCatchup());
                    return this.inscriptionRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("attention probleme d'ID"));
    }

    public void remove(int id_etudiant, int ref_catchup)
    {
        KeyComposite keyComposite = new KeyComposite(id_etudiant, ref_catchup);

        Inscription inscription = this.inscriptionRepository.findById(keyComposite).get();

        if(inscription != null)
            this.inscriptionRepository.delete(inscription);
    }

    public Inscription inscriptin_getById(int id_etudiant, int ref_catchup) {

        KeyComposite keyComposite = new KeyComposite(id_etudiant, ref_catchup);

        return this.inscriptionRepository.findById(keyComposite).get();
    }


}
