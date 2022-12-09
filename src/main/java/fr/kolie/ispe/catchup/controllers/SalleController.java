package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.Salle;
import fr.kolie.ispe.catchup.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/catchup/salle")
public class SalleController {

    @Autowired
    private final SalleService salleService;

    public SalleController(SalleService salleService) {
        this.salleService = salleService;
    }

    @GetMapping("/listes")
    public List<Salle> salle_listes()
    {
        return this.salleService.listes();
    }

    @PostMapping("/add")
    public String salle_add(@Validated @RequestBody Salle salle) throws GeneralSecurityException {
        this.salleService.add(salle);

        return "Salle ajouter avec succèss";
    }

    @PutMapping("/update/{id_salle}")
    public String salle_update(@Validated @PathVariable int id_salle, @RequestBody Salle salle)
    {
        this.salleService.update(id_salle, salle);

        return "Salle mise à jours avec succèss";
    }

    @DeleteMapping("/remove/{id_salle}")
    public String salle_remove(@Validated @PathVariable int id_salle)
    {
        this.salleService.remove(id_salle);
        return "Salle supprimer avec succèss";
    }

    @GetMapping("/getById/{id_salle}")
    public Salle salle_getById(@Validated @PathVariable int id_salle)
    {
        return this.salleService.getById(id_salle);
    }
}
