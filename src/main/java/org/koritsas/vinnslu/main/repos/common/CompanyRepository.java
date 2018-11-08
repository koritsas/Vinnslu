package org.koritsas.vinnslu.main.repos.common;

import org.koritsas.vinnslu.main.models.common.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long>{


    Company findByName(final String name);
    Company findByAfm(final Long afm);
    Company findByPhone(final int phone);
    List<Company> findByAddress(final String address);
    List<Company> findByAddressLike(final String address);
    List<Company> findByAddressIsNull();

}
