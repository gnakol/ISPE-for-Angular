package fr.kolie.ispe.catchup.controllers;

import fr.kolie.ispe.catchup.beans.User;
import fr.kolie.ispe.catchup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.GeneralSecurityException;
import java.util.List;


@RestController
@RequestMapping("/catchup/user")
public class UserController {

    @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/listes")
    public List<User> user_listes()
    {
        return this.userService.listes();
    }

    @PostMapping("/add")
    public String user_add(@Validated @RequestBody User user) throws GeneralSecurityException {
        this.userService.add(user);

        return "Utilisateur creer avec succes";
    }

    @PutMapping("/update/{id_user}")
    public String user_update(@Validated @PathVariable int id_user, @RequestBody User user)
    {
        this.userService.update(id_user, user);

        return "Utilisateur mise à jour avec succes";
    }

    @DeleteMapping("/remove/{id_user}")
    public String user_remove(@Validated @PathVariable int id_user)
    {
        this.userService.remove(id_user);

        return "Utilisateur supprimer avec succès";
    }

    @GetMapping("/getById/{id_user}")
    public User user_getById(@Validated @PathVariable int id_user)
    {
        return this.userService.getById(id_user);
    }
}
