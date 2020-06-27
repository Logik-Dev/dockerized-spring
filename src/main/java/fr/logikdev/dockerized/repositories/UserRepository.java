package fr.logikdev.dockerized.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.logikdev.dockerized.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
