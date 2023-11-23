package sj.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sj.board.entity.SiteUser;

import java.util.Optional;

public interface UserRepository extends JpaRepository<SiteUser, Long> {
    Optional<SiteUser> findByusername(String username);
}