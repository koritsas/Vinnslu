package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.common.Authority;
import org.koritsas.vinnslu.models.common.Company;
import org.koritsas.vinnslu.models.topo.Guarantee;
import org.koritsas.vinnslu.models.types.GuaranteeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuaranteeRepository extends JpaRepository<Guarantee,Long> {

    Guarantee findByAmount(final double amount);

    List<Guarantee> findByAmountGreaterThan(final double amount);

    List<Guarantee> findByAmountLessThan(final double amount);

    List<Guarantee> findByAuthority(final Authority authority);

    List<Guarantee> findByCompany(final Company company);

    List<Guarantee> findByGuaranteeType(final GuaranteeType guaranteeType);
}
