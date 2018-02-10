package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findById(@Param("id") final int id);
    Authority findByName(final String name);
    Authority findByAfm(final Long afm);
    List<Authority> findByAddress(final String address);
    List<Authority> findByAddressLike(final String address);
    List<Authority> findByAddressIsNull();

}
