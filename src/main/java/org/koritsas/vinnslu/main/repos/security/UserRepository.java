package org.koritsas.vinnslu.main.repos.security;

import org.koritsas.vinnslu.main.models.security.VinnsluUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<VinnsluUser, Long> {

    VinnsluUser findByEmail(final String email);

    VinnsluUser findByUsername(final String username);
}
