package org.koritsas.vinnslu.security.repos;

import org.koritsas.vinnslu.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(final String email);

    User findByUsername(final String username);
}
