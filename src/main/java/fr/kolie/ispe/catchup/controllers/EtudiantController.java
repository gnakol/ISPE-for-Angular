package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.Etudiant;
import fr.kolie.ispe.catchup.service.EtudiantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/catchup/etudiant")
public class EtudiantController {

    @Autowired
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping("/listes")
    public List<Etudiant> etudiant_all_liste()
    {
        return this.etudiantService.listes();
    }

    @PostMapping("/add")
    public String etudiant_add(@Validated @RequestBody Etudiant etudiant)
    {
        this.etudiantService.add(etudiant);

        return "etudiant ajouter avec succès";
    }

    @PutMapping("/update/{id_etudiant}")
    public String etudiant_update(@Validated @PathVariable int id_etudiant, @RequestBody Etudiant etudiant)
    {
        this.etudiantService.update(id_etudiant, etudiant);

        return "Mise à jour étudiant avec succès";
    }

    @DeleteMapping("/remove/{id_etudiant}")
    public String etudiant_delete(@Validated @PathVariable int id_etudiant)
    {
        this.etudiantService.remove(id_etudiant);

        return "Etudiant supprimer avec succès";
    }

    @GetMapping("/getById/{id_etudiant}")
    public Etudiant etudiant_get_by_id(@Validated @PathVariable int id_etudiant)
    {
        return this.etudiantService.getById(id_etudiant);
    }
}
