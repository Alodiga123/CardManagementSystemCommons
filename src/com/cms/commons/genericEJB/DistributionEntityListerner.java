package com.cms.commons.genericEJB;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;
import com.cms.commons.models.audit.Audit;
import com.cms.commons.models.audit.Event;
import com.cms.commons.models.audit.EventType;

public class DistributionEntityListerner {

    @PrePersist
    public void onEntityPrePersist(Object entity) {
    }

    @PostPersist
    public void onEntityPostPersist(Object entity) {
    }

    @PreRemove
    public void onEntityPreRemove(Object entity) {
    }

    @PostRemove
    public void onEntityPostRemove(Object entity) {
    }

    @PreUpdate
    public void onEntityPreUpdate(Object entity) {
    }

    @PostUpdate
    public void onEntityPostUpdate(Object entity) {
    }

    @PostLoad
    public void onEntityLoad(Object entity) {
    }

    public static void processAction(EventType eventType, List<Audit> audits, Object entity, EntityManagerWrapper emw) {
        Event event = new Event();
        Object oldEntity = null;
        if (audits != null && !audits.isEmpty()) {
            for (Audit audit : audits) {
                try {
                    audit.setCreationDate(new Timestamp(new Date().getTime()));
                    if (isInstanceEntity(entity)) {
                        audit.setTableName(((AbstractDistributionEntity) entity).getTableName());
                    }
                    switch (eventType) {
                        case CREATE:
                            event.setId(new Long(EventType.CREATE.getValue()));
                            audit.setNewValues(entity.toString());
                            audit.setEvent(event);

                            break;
                        case READ:
                            event.setId(new Long(EventType.READ.getValue()));
                            audit.setEvent(event);
                            audit.setOriginalValues(entity.toString());
                            break;
                        case UPDATE:
                            event.setId(new Long(EventType.UPDATE.getValue()));
                            audit.setEvent(event);
                            if (isInstanceEntity(entity)) {
                                oldEntity = emw.load(entity.getClass(), ((AbstractDistributionEntity) entity).getPk());
                                audit.setOriginalValues(oldEntity.toString());
                            }
                            audit.setNewValues(entity.toString());
                            break;
                        case DELETE:
                            audit.setEvent(event);
                            event.setId(new Long(EventType.DELETE.getValue()));
                            if (isInstanceEntity(entity)) {
                                oldEntity = emw.load(entity.getClass(), ((AbstractDistributionEntity) entity).getPk());
                                audit.setOriginalValues(oldEntity.toString());
                            }
                            break;
                    }
                    //Seguir probando este caso
                    //emw.save(audit);
                    emw.entityManager.persist(audit);
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
//			
            }
        }
    }

    public static boolean isInstanceEntity(Object entity) {
        return entity instanceof AbstractDistributionEntity;
    }
}
