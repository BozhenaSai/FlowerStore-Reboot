package ua.edu.ucu.apps.lab8.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.edu.ucu.apps.lab8.model.AppUser;
import ua.edu.ucu.apps.lab8.repository.AppUserRepository;

import java.util.List;

@Service
public class AppUserService {
    private AppUserRepository appUserRepository;

    @Autowired
    public AppUserService(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public List<AppUser> getUsers() {
        return appUserRepository.findAll();
    }

    public AppUser createAppUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }

    public AppUser getAppUserByEmail(String email) {
        return appUserRepository.findUserByEmail(email);
    }
}