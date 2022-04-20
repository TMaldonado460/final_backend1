package com.ctd.finalbackend1.security.repository;

import com.ctd.finalbackend1.security.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<Usuario, UUID> {
    @Query
    Optional<Usuario> findByUsername(String username);

    Optional<Usuario> findByUsernameAndPassword(String username, String password);
}
