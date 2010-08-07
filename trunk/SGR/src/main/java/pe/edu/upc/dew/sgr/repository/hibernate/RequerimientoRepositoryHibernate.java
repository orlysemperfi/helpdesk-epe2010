package pe.edu.upc.dew.sgr.repository.hibernate;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
import pe.edu.upc.dew.sgr.domain.Requerimiento;
import pe.edu.upc.dew.sgr.repository.RequerimientoRepository;

/**
 *
 * @author Administrador
 */

@Component
public class RequerimientoRepositoryHibernate 
        extends HibernateDaoSupport
        implements RequerimientoRepository{

    @Autowired
    public RequerimientoRepositoryHibernate(SessionFactory sf){
        setSessionFactory(sf);
    }

    public List<Requerimiento> obtenerRequerimientos() {
        return getHibernateTemplate().
                find("from tb_requerimiento");
    }

    public List<Requerimiento> obtenerRequerimientosPorUsuario(int cod_usuario) {
        return getSession().
                createQuery("from tb_requerimiento req"
                + " where req.cod_req = ?").
                setInteger(0, cod_usuario).list();
    }

    public Requerimiento obtenerRequerimiento(int cod_req) {
        return (Requerimiento) getSession().
                createQuery("from tb_requerimiento req"
                + " where req.cod_req = ?").
                setInteger(0, cod_req).uniqueResult();
    }

    public void grabarRequerimiento(Requerimiento obj) {
        getHibernateTemplate().saveOrUpdate(obj);
    }

    public void eliminarRequerimiento(int id) {
        Requerimiento obj = obtenerRequerimiento(id);
        getHibernateTemplate().delete(obj);
    }
}
