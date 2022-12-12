package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.Etudiant;
import fr.kolie.ispe.catchup.beans.Inscription;
import fr.kolie.ispe.catchup.service.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catchup/inscription")
public class InscriptionController {

    @Autowired
    private final InscriptionService inscriptionService;

    public InscriptionController(InscriptionService inscriptionService) {
        this.inscriptionService = inscriptionService;
    }

    @GetMapping("/listes")
    public List<Inscription> listes_inscription()
    {
        return this.inscriptionService.liste_inscription();
    }

    @PostMapping("/add")
    public String ajouter_inscription(@Validated @RequestBody Inscription inscripton)
    {
        this.inscriptionService.add(inscripton);

        return "inscription ajouter avec succèss";
    }

    @GetMapping("getById/{id_etudiant}/{ref_catchup}")
    public Inscription inscripton_getById(@Validated @PathVariable int id_etudiant, @PathVariable int ref_catchup)
    {
        return this.inscriptionService.inscriptin_getById(id_etudiant, ref_catchup);
    }

    @PutMapping("/update/{id_etudiant}/{ref_catchup}")
    public String inscription_update(@Validated @PathVariable int id_etudiant, @PathVariable int ref_catchup, @RequestBody Inscription inscription)
    {
        this.inscriptionService.update(id_etudiant, ref_catchup, inscription);

        return "Super l'inscription à été modifier avec succèss";
    }

    @DeleteMapping("/remove/{id_etudiant}/{ref_catchup}")
    public String inscription_remove(@Validated @PathVariable int id_etudiant, @PathVariable int ref_catchup)
    {
        this.inscriptionService.remove(id_etudiant, ref_catchup);

        return "inscription supprimer avec succès";
    }

    @GetMapping("/inscriptionsByCatchup/{ref_catchup}")
    public List<Inscription> inscriptions_byCatchupRef(@Validated @PathVariable int ref_catchup)
    {
        return this.inscriptionService.inscriptions_ByCatchupRef(ref_catchup);
    }

    @GetMapping("/etudiantsPresentByCatchupRef/{ref_catchup}")
    public List<Etudiant> etudiants_presentByCatchupRef(@Validated @PathVariable int ref_catchup)
    {
        return this.inscriptionService.etudiants_present_ByCatchupRef(ref_catchup);
    }

    @GetMapping("/etudiantsByCatchupRef/{ref_catchup}")
    public List<Etudiant> etudiants_getByCatchupRef(@Validated @PathVariable int ref_catchup)
    {
        return this.inscriptionService.etudiants_byCatchupRef(ref_catchup);
    }
}
