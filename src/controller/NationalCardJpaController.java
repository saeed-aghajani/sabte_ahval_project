/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import common.CustomExceptionMessage;
import common.SabteAhvalException;
import controller.exceptions.NonexistentEntityException;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.NationalCard;

/**
 *
 * @author saeed
 */
public class NationalCardJpaController implements Serializable {

    public NationalCardJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(NationalCard nationalCard) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(nationalCard);
            em.flush();
            em.getTransaction().commit();            
            return nationalCard.getId();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(NationalCard nationalCard) throws SabteAhvalException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            nationalCard = em.merge(nationalCard);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = nationalCard.getId();
                if (findNationalCard(id) == null) {
                    throw new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "NationalCard", msg);
                }
            }
            throw new SabteAhvalException(CustomExceptionMessage.DB_UNKNOWN_EXCEPTION, "NationalCard", msg);
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            NationalCard nationalCard;
            try {
                nationalCard = em.getReference(NationalCard.class, id);
                nationalCard.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The nationalCard with id " + id + " no longer exists.", enfe);
            }
            em.remove(nationalCard);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<NationalCard> findNationalCardEntities() {
        return findNationalCardEntities(true, -1, -1);
    }

    public List<NationalCard> findNationalCardEntities(int maxResults, int firstResult) {
        return findNationalCardEntities(false, maxResults, firstResult);
    }

    private List<NationalCard> findNationalCardEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(NationalCard.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public NationalCard findNationalCard(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(NationalCard.class, id);
        } finally {
            em.close();
        }
    }

    public int getNationalCardCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<NationalCard> rt = cq.from(NationalCard.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
     public List<NationalCard> findAllNationalCard(){
        EntityManager em = getEntityManager();
        List<NationalCard>results = null;        
        TypedQuery<NationalCard> query = em.createNamedQuery("NationalCard.findAll",NationalCard.class);
        results = query.getResultList();                  
        return results;
    }
     
    public void updateNationalCardIssuance(String nid, boolean isIssued, boolean isReplica, Date issueDate) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            TypedQuery<NationalCard> query = em.createNamedQuery("NationalCard.updateIssuance",NationalCard.class);
            query.setParameter("nid", nid); 
            query.setParameter("isIssued", isIssued); 
            query.setParameter("isReplica", isReplica); 
            query.setParameter("issueDate", issueDate); 
            query.executeUpdate(); 
            em.getTransaction().commit();
        } catch(NonUniqueResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.PERSISTENCE_NON_UNIQUE_RESULT, "NationalCard", e.getMessage());
        }
    }  
    
    public void updateNationalCardDelivery(String nid, boolean isDeliver, Date deliverDate) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            TypedQuery<NationalCard> query = em.createNamedQuery("NationalCard.updateDelivery", NationalCard.class);
            query.setParameter("nid", nid);  
            query.setParameter("isDeliver", isDeliver);            
            query.setParameter("deliverDate", deliverDate); 
            query.executeUpdate(); 
            em.getTransaction().commit();
        } catch(NonUniqueResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.PERSISTENCE_NON_UNIQUE_RESULT, "NationalCard", e.getMessage());
        }
    }
    
    public NationalCard findNationalCardByNid(String nid) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            NationalCard results = null;            
            TypedQuery<NationalCard> query = em.createNamedQuery("NationalCard.findByNid",NationalCard.class);
            query.setParameter("nid", nid);
            results = query.getSingleResult();                  
            return results;
        } catch(NoResultException e){
            SabteAhvalException exception = new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "ResponsibleInformation", e.getMessage());
            throw exception;
        }
    }
}
