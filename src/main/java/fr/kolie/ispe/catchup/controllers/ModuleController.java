package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.Matiere;
import fr.kolie.ispe.catchup.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;

@RestController
@RequestMapping("/catchup/module")
public class ModuleController {

    @Autowired
    private final ModuleService moduleService;

    public ModuleController(ModuleService moduleService) {
        this.moduleService = moduleService;
    }

    @GetMapping("/listes")
    public List<Matiere> module_listes()
    {
        return this.moduleService.listes();
    }

    @PostMapping("/add")
    public String module_add(@Validated @RequestBody Matiere matiere) throws GeneralSecurityException {
        this.moduleService.add(matiere);

        return "Matiere ajouter avec success";
    }

    @PutMapping("/update/{id_module}")
    public String module_udpdate(@Validated @PathVariable int id_module, @RequestBody Matiere matiere)
    {
        this.moduleService.update(id_module, matiere);

        return "Modification du module à été un success";
    }

    @DeleteMapping("/remove/{id_module}")
    public String module_remove(@Validated @PathVariable int id_module)
    {
        this.moduleService.remove(id_module);

        return "Matiere supprimer avec succèss";
    }

    @GetMapping("/getById/{id_module}")
    public Matiere module_getById(@Validated @PathVariable int id_module)
    {
        return this.moduleService.getById(id_module);
    }
}
