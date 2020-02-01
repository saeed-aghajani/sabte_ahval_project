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
import model.BirthCertificate;

/**
 *
 * @author saeed
 */
public class BirthCertificateJpaController implements Serializable {

    public BirthCertificateJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(BirthCertificate birthCertificate) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(birthCertificate);
            em.flush();
            em.getTransaction().commit();
            return birthCertificate.getId();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(BirthCertificate birthCertificate) throws SabteAhvalException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            birthCertificate = em.merge(birthCertificate);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = birthCertificate.getId();
                if (findBirthCertificate(id) == null) {
                    msg = "The birthCertificate with id " + id + " no longer exists.";
                    throw new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "BirthCertificate", msg);
                }
            }
            throw new SabteAhvalException(CustomExceptionMessage.DB_UNKNOWN_EXCEPTION, "BirthCertificate", msg);
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
            BirthCertificate birthCertificate;
            try {
                birthCertificate = em.getReference(BirthCertificate.class, id);
                birthCertificate.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The birthCertificate with id " + id + " no longer exists.", enfe);
            }
            em.remove(birthCertificate);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<BirthCertificate> findBirthCertificateEntities() {
        return findBirthCertificateEntities(true, -1, -1);
    }

    public List<BirthCertificate> findBirthCertificateEntities(int maxResults, int firstResult) {
        return findBirthCertificateEntities(false, maxResults, firstResult);
    }

    private List<BirthCertificate> findBirthCertificateEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(BirthCertificate.class));
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

    public BirthCertificate findBirthCertificate(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(BirthCertificate.class, id);
        } finally {
            em.close();
        }
    }

    public int getBirthCertificateCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<BirthCertificate> rt = cq.from(BirthCertificate.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<BirthCertificate> findBirthCertificates(){
        EntityManager em = getEntityManager();
        List<BirthCertificate>results = null;        
        TypedQuery<BirthCertificate> query = em.createNamedQuery("BirthCertificate.findAll",BirthCertificate.class);
        results = query.getResultList();                  
        return results;
    }
    
    public BirthCertificate findBirthCertificateByCertIdSeiSeryal(String certId, String seri, String seryal) throws SabteAhvalException{
        BirthCertificate bc = null;
        try{
            EntityManager em = getEntityManager();
            TypedQuery<BirthCertificate> query = em.createNamedQuery("BirthCertificate.findByCertIdSeriSeryal",BirthCertificate.class);
            query.setParameter("certificateNumber", certId); 
            query.setParameter("seri", seri); 
            query.setParameter("seryal", seryal); 
            bc = query.getSingleResult(); 
        } catch(NonUniqueResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.PERSISTENCE_NON_UNIQUE_RESULT, "BirthCertificate", e.getMessage());
        } catch(NoResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "BirthCertificate", e.getMessage());
        }
        return bc;
    }
    
    public void updateBirthCertificateIssuance(String certId, String seri, String seryal, boolean isIssued, boolean isReplica, Date issueDate) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            TypedQuery<BirthCertificate> query = em.createNamedQuery("BirthCertificate.updateIssuance",BirthCertificate.class);
            query.setParameter("certificateNumber", certId); 
            query.setParameter("seri", seri); 
            query.setParameter("seryal", seryal); 
            query.setParameter("isIssued", isIssued); 
            query.setParameter("isReplica", isReplica); 
            query.setParameter("issueDate", issueDate); 
            int id = query.executeUpdate(); 
            em.getTransaction().commit();            
        } catch(NonUniqueResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.PERSISTENCE_NON_UNIQUE_RESULT, "BirthCertificate", e.getMessage());
        }
    }
    
    public void updateBirthCertificateDelivery(String certId, String seri, String seryal, boolean isDeliver, Date deliverDate) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            em.getTransaction().begin();
            TypedQuery<BirthCertificate> query = em.createNamedQuery("BirthCertificate.updateDelivery", BirthCertificate.class);
            query.setParameter("certificateNumber", certId); 
            query.setParameter("seri", seri); 
            query.setParameter("seryal", seryal); 
            query.setParameter("isDeliver", isDeliver);            
            query.setParameter("deliverDate", deliverDate); 
            query.executeUpdate(); 
            em.getTransaction().commit(); 
        } catch(NonUniqueResultException e){
            throw new SabteAhvalException(CustomExceptionMessage.PERSISTENCE_NON_UNIQUE_RESULT, "BirthCertificate", e.getMessage());
        }
    }
}
