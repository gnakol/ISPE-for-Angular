package fr.kolie.ispe.catchup.service;

import fr.kolie.ispe.catchup.beans.User;
import fr.kolie.ispe.catchup.methods.WebServices;
import fr.kolie.ispe.catchup.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.util.List;

@Service
public class UserService implements WebServices<User> {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> listes() {
        return this.userRepository.findAll();
    }

    public String crypte(String password) throws GeneralSecurityException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(password.getBytes());
        byte byteData[] = md.digest();

        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();

    }

    @Override
    public void add(User e) throws GeneralSecurityException {

        e.setPassword(this.crypte(e.getPassword()));

        this.userRepository.save(e);
    }

    @Override
    public User update(int id_e, User e) {
        return this.userRepository.findById(id_e)
                .map(p -> {
                    p.setNom(e.getNom());
                    p.setPrenom(e.getPrenom());
                    try {
                        p.setPassword(this.crypte(e.getPassword()));
                    } catch (GeneralSecurityException ex) {
                        throw new RuntimeException(ex);
                    }
                    p.setRole(e.getRole());
                    return this.userRepository.save(p);
                }).orElseThrow(()-> new RuntimeException("Attention user non trouver"));
    }

    @Override
    public void remove(int id_e) {

        User user = this.userRepository.findById(id_e).get();

        if(user != null)
            this.userRepository.delete(user);
    }

    @Override
    public User getById(int id_e) {
        return this.userRepository.findById(id_e).get();
    }
}
