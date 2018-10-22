package org.koritsas.vinnslu.repos.common;

import org.koritsas.vinnslu.models.common.Opinion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OpinionRepository extends JpaRepository<Opinion,Long> {

}
