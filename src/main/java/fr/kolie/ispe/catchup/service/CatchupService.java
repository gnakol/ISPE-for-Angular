package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.Catchup;
import fr.kolie.ispe.catchup.beans.User;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.CatchupRepository;
import fr.kolie.ispe.catchup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.util.List;

@Service
public class CatchupService  {



    @Autowired
    private final CatchupRepository catchupRepository;

    @Autowired
    private final UserRepository userRepository;

    public CatchupService(CatchupRepository catchupRepository, UserRepository userRepository) {
        this.catchupRepository = catchupRepository;
        this.userRepository = userRepository;
    }




    public List<Catchup> listes() {
        return this.catchupRepository.findAll();
    }


    public void add(Catchup e) throws GeneralSecurityException {
        this.catchupRepository.save(e);
    }

    public Catchup update(int id_e, Catchup e) {
        return this.catchupRepository.findById(id_e)
                .map(p-> {
                    p.setSujet(e.getSujet());
                    p.setDate(e.getDate());
                    p.setHeure(e.getHeure());
                    p.setDuree(e.getDuree());
                    p.setEtat(e.getEtat());
                    p.setProfesseur(e.getProfesseur());
                    p.setSurveillant(e.getSurveillant());
                    p.setSalle(e.getSalle());
                    p.setMatiere(e.getMatiere());
                    return this.catchupRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention une execption pour catchup"));
    }




    public void remove(int id_e) {

        Catchup catchup = this.catchupRepository.findById(id_e).get();

        if(catchup != null)
        {
            this.catchupRepository.delete(catchup);
        }
    }

    public Catchup getById(int id_e) {
        return this.catchupRepository.findById(id_e).get();
    }

    // Liste des rattrapage pour le professeur

    public List<Catchup> vue_professeur(int id_professeur)
    {
        User professeur = this.userRepository.findById(id_professeur).get();

        return this.catchupRepository.findByProfesseur(professeur);
    }

    // Liste des rattapage pour le surveillant

    public List<Catchup> vue_surveillant(int id_surveillant)
    {
        User surveillant = this.userRepository.findById(id_surveillant).get();

        return this.catchupRepository.findBySurveillant(surveillant);
    }

    public List<Catchup> catchups_byEtat(String etat)
    {
        return this.catchupRepository.findByEtat(etat);
    }

    public List<Catchup> catchups_restant_nonEffectuer_ByProf(int id_professeur)
    {
        User professeur = this.userRepository.findById(id_professeur).get();

        return this.catchupRepository.findByEtatAndProfesseur("Non effectué", professeur);
    }


    public List<Catchup> catchups_restant_nonEffectuer_BySurveillant(int id_surveillant)
    {
        User surveillant = this.userRepository.findById(id_surveillant).get();

        return this.catchupRepository.findByEtatAndSurveillant("Non effectué", surveillant);
    }


}
