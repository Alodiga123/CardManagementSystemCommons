package com.cms.commons.genericEJB;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.EJBContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.apache.log4j.Logger;
import javax.persistence.Query;
import com.alodiga.cms.commons.exception.EmptyListException;
import com.alodiga.cms.commons.exception.GeneralException;
import com.alodiga.cms.commons.exception.NullParameterException;
import com.alodiga.cms.commons.exception.RegisterNotFoundException;
import com.cms.commons.models.audit.Audit;
import com.cms.commons.models.audit.EventType;
import com.cms.commons.util.EjbConstants;
import com.cms.commons.util.MessageFormatHelper;
import com.cms.commons.util.QueryParam;
import java.util.Date;

public class AbstractDistributionEJB {

//    @PersistenceContext(name = "cmsPu")
    protected EntityManager entityManager;
    @Resource
    protected EJBContext context;
    protected MessageFormatHelper sysMessages, sysError;
    protected EntityManagerWrapper entityManagerWrapper = null;
    
    protected EntityManagerFactory emf = null;
    public AbstractDistributionEJB() {
        emf = Persistence.createEntityManagerFactory("cmsPu");
        entityManagerWrapper = new EntityManagerWrapper();
        entityManager = emf.createEntityManager();

    }

    //@Override
    @PostConstruct
    public void init() {
        entityManagerWrapper.setEntityManager(entityManager);
    }

    public boolean echo() throws Exception {
        return true;
    }

    protected String getMethodName() {
        return Thread.currentThread().getStackTrace()[2].getMethodName();
    }

    public EntityManagerWrapper getEntityManagerWrapper() {
        return entityManagerWrapper;
    }

    protected Boolean removeEntity(Object entity, Logger logger, String methodName, List<Audit> auditData) {
//    	FIXME utilizar el AUDIT DATA
        List<Object> entities = (List<Object>) entity;
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            for (Object o : entities) {
                entityManager.remove(entity);
            }
            transaction.commit();
        } finally {
            return false;
        }
    }

    protected Object saveEntity(Object entity, Logger logger, String methodName, List<Audit> auditData) throws GeneralException, NullParameterException {
        if (entity == null) {
            throw new NullParameterException(logger, "", null);
        }
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            if (((DistributionGenericEntity) entity).getPk() != null) {
                //processAuditData(EventType.UPDATE, entity, auditData, entityManagerWrapper);
                entityManagerWrapper.update(entity);
            } else {
                entityManagerWrapper.save(entity);
                //processAuditData(EventType.CREATE, entity, auditData, entityManagerWrapper);
            }

            transaction.commit();
        } catch (Exception e) {
            try {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (IllegalStateException e1) {
                throw new GeneralException(logger, "", e1);
            } catch (SecurityException e1) {
                throw new GeneralException(logger, "", e1);
            }
            throw  new GeneralException(logger, "", e);
        }

        return entity;
    }

    protected Object listEntities(Class clazz, Integer first, Integer limit, Logger logger, String methodName, List<Audit> auditData) throws GeneralException, EmptyListException {
        Object oReturns = null;
        try {
            oReturns = entityManagerWrapper.get(clazz, first, limit);
            //persistAuditData(EventType.READ, oReturns, auditData);

        } catch (Exception e) {
            throw new GeneralException(logger, "", e);
        }
        if (((List) oReturns).isEmpty()) {
            throw new EmptyListException(logger, "", null);
        }
        return oReturns;
    }

    protected Object loadEntity(Class clazz, Object pk, Logger logger, String methodName, List<Audit> auditData) throws NullParameterException, GeneralException, RegisterNotFoundException {
        Object oReturn = null;
        if (pk == null) {
          
            throw new NullParameterException(logger, "", null);
        }
        try {
            oReturn = entityManagerWrapper.load(clazz, pk);
            //persistAuditData(EventType.READ, oReturn, auditData);
        } catch (Exception e) {
            throw new GeneralException(logger, "", null);
        }
        if (oReturn == null) {
            throw new RegisterNotFoundException(logger, "", null);
        }
        return oReturn;
    }
    
     protected Object loadEntity(Class clazz, Object pk) throws NullParameterException, GeneralException, RegisterNotFoundException {
        Object oReturn = null;
        if (pk == null) {
          
            throw new NullParameterException( "", null);
        }
        try {
            oReturn = entityManagerWrapper.load(clazz, pk);
            //persistAuditData(EventType.READ, oReturn, auditData);
        } catch (Exception e) {
            throw new GeneralException( "", null);
        }
        if (oReturn == null) {
            throw new RegisterNotFoundException( "", null);
        }
        return oReturn;
    }

    protected Object getNamedQueryResult(Class clazz, String namedQueryName, Map<? extends Object, ? extends Object> map, String method, Logger logger, String returnObjectName, Integer first, Integer limit, List<Audit> auditData) throws EmptyListException, GeneralException {
        Object object = null;

        if (map == null) {
            map = new HashMap<Object, Object>();
        }
        try {
            object = (Object) entityManagerWrapper.findByNamedQuery(namedQueryName, map, first, limit);
            //persistAuditData(EventType.READ, object, auditData);

        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(logger, "", e);
        }
        if (object == null || ((List<Object>) object).size() < 1) {
            throw new EmptyListException(logger, "", null);
        }

        return object;
    }

    private void processAuditData(EventType eventType, Object entity, List<Audit> audits, EntityManagerWrapper emw) {
        if (audits != null && !audits.isEmpty()) {
            DistributionEntityListerner.processAction(eventType, audits, entity, emw);
        }

    }

    protected Object removeEntity(EJBRequest request, Logger logger, String methodName) throws GeneralException, NullParameterException {
        if (request == null) {
            throw new NullParameterException(logger, "", null);
        }
        return removeEntity(request.getParam(), logger, methodName, request.getAuditData());
    }

    protected Object saveEntity(EJBRequest request, Logger logger, String methodName) throws GeneralException, NullParameterException {
        if (request == null) {
            throw new NullParameterException(logger, "", null);
        }
        return saveEntity(request.getParam(), logger, methodName, request.getAuditData());
    }

    protected Object listEntities(Class clazz, EJBRequest request, Logger logger, String methodName) throws GeneralException, EmptyListException, NullParameterException {
        if (request == null) {
            throw new NullParameterException(logger, "", null);
        }
        return listEntities(clazz, request.getFirst(), request.getLimit(), logger, methodName, request.getAuditData());
    }

    protected Object loadEntity(Class clazz, EJBRequest request, Logger logger, String methodName) throws NullParameterException, GeneralException, RegisterNotFoundException {
        if (request == null) {
            throw new NullParameterException(logger, "", null);
        }
        return loadEntity(clazz, request.getParam(), logger, methodName, request.getAuditData());
    }

    protected Object getNamedQueryResult(Class clazz, String namedQueryName, EJBRequest request, String method, Logger logger, String returnObjectName) throws EmptyListException, GeneralException, NullParameterException {
        if (request == null) {
            throw new NullParameterException(logger, "", null);
        }
        return getNamedQueryResult(clazz, namedQueryName, request.getParams(), method, logger, returnObjectName, request.getFirst(), request.getLimit(), request.getAuditData());
    }

    protected void persistAuditData(EventType eventType, Object entity, List<Audit> auditData) {
        /*EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            processAuditData(eventType, entity, auditData, entityManagerWrapper);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
*/
    }

    public void executeNameQuery(Class clazz, String namedQueryName, Map<? extends Object, ? extends Object> map, String method, Logger logger, String returnObjectName, Integer first, Integer limit) throws EmptyListException, GeneralException {

        if (map == null) {
            map = new HashMap<Object, Object>();
        }
        try {
            EntityTransaction transaction = entityManager.getTransaction();
            transaction.begin();
            entityManagerWrapper.executeNamedQuery(namedQueryName, map);
            transaction.commit();
        } catch (Exception e) {
            throw new GeneralException(logger, "", null);
        }
    }

    public Query createQuery(String sql) throws NullParameterException, Exception {
        Query query = null;
        if (sql == null) {
            throw new NullParameterException("sql cannot be null");
        }
        try {
            query = entityManagerWrapper.createQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception(e.getMessage());
        }
        return query;
    }

    protected Object createSearchQuery(Class clazz, EJBRequest request, Map orderMap, Logger logger, String methodName, String returnObjectName, boolean isFilter) throws GeneralException, EmptyListException, NullParameterException {
        Object object = null;
        Map map = request.getParams();
        if (map == null) {
            throw new NullParameterException(logger, "Map data is empty", null);
        }
        try {
            //System.out.println(".........A1.........."+(new Date()));
            object = (Object) entityManagerWrapper.executeSearchQuery(clazz, map, orderMap, request.getFirst(), request.getLimit(), isFilter);
            //System.out.println(".........A2.........."+(new Date()));
            //persistAuditData(EventType.READ, object, request.getAuditData());
            //System.out.println(".........A3.........."+(new Date()));
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(logger, "", e);
        }
        if (object == null || ((List<Object>) object).size() < 1) {
            throw new EmptyListException(logger, "", null);
        }
        return object;
    }

    //Este metodo se utiliza para que el procesamiento sea mas rapido pero no guardara registro en la bitacora.
    protected Object saveEntity(Object entity) throws GeneralException, NullParameterException {
        if (entity == null) {
            throw new NullParameterException("NullParameterException ");
        }
        EntityTransaction transaction = entityManager.getTransaction();
        try {

            transaction.begin();
            if (((DistributionGenericEntity) entity).getPk() != null) {
                //processAuditData(EventType.UPDATE, entity, auditData, entityManagerWrapper);
                entityManagerWrapper.update(entity);
            } else {
                entityManagerWrapper.save(entity);
                //processAuditData(EventType.CREATE, entity, auditData, entityManagerWrapper);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                transaction.rollback();
            } catch (Exception e1) {
                throw new GeneralException("GeneralException saveEntity");
            }
            throw new GeneralException("GeneralException saveEntity");
        }

        return entity;
    }
}
