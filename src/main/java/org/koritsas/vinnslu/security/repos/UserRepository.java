package org.koritsas.vinnslu.security.repos;

import org.koritsas.vinnslu.security.models.VinnsluUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<VinnsluUser, Long> {

    VinnsluUser findByEmail(final String email);

    VinnsluUser findByUsername(final String username);
}
