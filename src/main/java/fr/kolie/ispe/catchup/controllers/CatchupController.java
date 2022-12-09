package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.Catchup;
import fr.kolie.ispe.catchup.service.CatchupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/catchup/catchupnow")
public class CatchupController {

    @Autowired
    private final CatchupService catchupService;

    public CatchupController(CatchupService catchupService) {
        this.catchupService = catchupService;
    }


    @GetMapping("/listes")
    public List<Catchup> catchup_listes()
    {
        return this.catchupService.listes();
    }

    @PostMapping("/add")
    public String catchup_add(@Validated @RequestBody Catchup catchup) throws GeneralSecurityException {
        this.catchupService.add(catchup);

        return "rattrapage ajouter avec succèss";
    }

    @PutMapping("/update/{id_catchup}")
    public String catchup_upadate(@Validated @PathVariable int id_catchup, @RequestBody Catchup catchup)
    {
        this.catchupService.update(id_catchup, catchup);

        return "Mise à jour rattrapage effectuer avec succeès";
    }



    @DeleteMapping("/remove/{id_catchup}")
    public String catchup_remove(@Validated @PathVariable int id_catchup)
    {
        this.catchupService.remove(id_catchup);

        return "rattrapage supprimer avec succès";
    }

    @GetMapping("/getById/{id_catchup}")
    public Catchup catchup_getById(@Validated @PathVariable int id_catchup)
    {
        return this.catchupService.getById(id_catchup);
    }

    @GetMapping("/professeur/{id_professeur}")
    public List<Catchup> vue_professeur(@Validated @PathVariable int id_professeur)
    {
        return this.catchupService.vue_professeur(id_professeur);
    }

    @GetMapping("/surveillant/{id_surveillant}")
    public List<Catchup> vue_surveillant(@Validated @PathVariable int id_surveillant)
    {
        return this.catchupService.vue_surveillant(id_surveillant);
    }
}
