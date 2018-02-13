package org.koritsas.vinnslu.repos;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.koritsas.vinnslu.models.Topo;
import org.springframework.orm.hibernate5.HibernateTransactionManager;

public abstract class TopoRepo implements TopoRepository {

    private HibernateTransactionManager em;


    public Topo getCriteriaTopo(){
        Session session=em.getSessionFactory().openSession();
	Topo t= (Topo) session.createCriteria(Topo.class).add(Restrictions.eq("id",1)).uniqueResult();
	return t;
    }
}
