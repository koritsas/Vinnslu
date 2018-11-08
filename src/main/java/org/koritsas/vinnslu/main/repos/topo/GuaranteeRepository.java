package org.koritsas.vinnslu.main.repos.topo;

import org.koritsas.vinnslu.main.models.common.Authority;
import org.koritsas.vinnslu.main.models.common.Company;
import org.koritsas.vinnslu.main.models.topo.Guarantee;
import org.koritsas.vinnslu.main.models.types.GuaranteeType;
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
