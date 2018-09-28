package org.koritsas.vinnslu.repos;

import org.koritsas.vinnslu.models.common.Authority;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority,Long> {



}
