package ua.edu.ucu.apps.lab8.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.edu.ucu.apps.lab8.model.AppUser;
import ua.edu.ucu.apps.lab8.service.AppUserService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class AppUserController {

    private AppUserService appUserService;

    @Autowired
    public AppUserController(AppUserService appUserService) {
        this.appUserService = appUserService;
    }

    @GetMapping("/user")
    public List<AppUser> getAllUsers() {
        return appUserService.getUsers();
    }

    @PostMapping("/user")
    public AppUser createUser(@RequestBody AppUser appUser) {
        return appUserService.createAppUser(appUser);
    }

    @GetMapping("/user/email")
    public ResponseEntity<AppUser> getUserByEmail(@RequestParam String email) {
        AppUser userByEmail = appUserService.getAppUserByEmail(email);
        if (userByEmail == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(userByEmail);
    }
}