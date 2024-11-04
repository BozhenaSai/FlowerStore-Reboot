package ua.edu.ucu.apps.lab8.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.edu.ucu.apps.lab8.model.AppUser;

@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Repository> {
    @Query("SELECT u FROM app_user u WHERE u.email = ?1")
    AppUser findUserByEmail(String email);
}