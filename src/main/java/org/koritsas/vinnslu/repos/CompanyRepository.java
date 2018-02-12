package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{

    Company findById(@Param("id") final Long id);
    Company findByName(final String name);
    Company findByAfm(final Long afm);
    List<Company> findByAddress(final String address);
    List<Company> findByAddressLike(final String address);
    List<Company> findByAddressIsNull();

}
