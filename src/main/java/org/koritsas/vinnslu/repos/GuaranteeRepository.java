package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.Company;
import org.koritsas.vinnslu.models.Guarantee;
import org.koritsas.vinnslu.models.types.GuaranteeLetterType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuaranteeRepository extends JpaRepository<Guarantee,Guarantee.GuaranteeLetter>{

    Guarantee findByGuaranteeLetter(Guarantee.GuaranteeLetter guaranteeLetter);

    List<Guarantee> findByCompany(Company company);

    List<Guarantee> findByGuaranteeLetterType(GuaranteeLetterType guaranteeLetterType);

    List<Guarantee> findByComplementary(boolean complementary);

    @Query("Select l from #{#entityName} l where l.guaranteeLetter.letterNumber = (:letterNumber)" )
    Guarantee findByLetterNumber(String letterNumber);

    @Query("Select l from #{#entityName} l where l.guaranteeLetter.money = (:money)" )
    List<Guarantee> findByMoneyAmount(double money);

    @Query("Select l from #{#entityName} l where l.guaranteeLetter.organization = (:organization)" )
    List<Guarantee> findByOrganization(String organization);
}
