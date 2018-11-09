package org.koritsas.vinnslu.main.repos.common;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {

    Authority findByName(final String name);
    Authority findByAfm(final int afm);
    Authority findByPhone(final int phone);
    List<Authority> findByAddress(final String address);
    List<Authority> findByAddressLike(final String address);
    List<Authority> findByAddressIsNull();

}
