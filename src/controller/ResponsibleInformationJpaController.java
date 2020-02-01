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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.ResponsibleInformation;

/**
 *
 * @author saeed
 */
public class ResponsibleInformationJpaController implements Serializable {

    public ResponsibleInformationJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public int create(ResponsibleInformation responsibleInformation) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(responsibleInformation);
            em.flush();
            em.getTransaction().commit();            
            return responsibleInformation.getId();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(ResponsibleInformation responsibleInformation) throws SabteAhvalException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            responsibleInformation = em.merge(responsibleInformation);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = responsibleInformation.getId();
                if (findResponsibleInformation(id) == null) {
                    throw new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "ResponsibleInformation", msg);
                }
            }
            throw new SabteAhvalException(CustomExceptionMessage.DB_UNKNOWN_EXCEPTION, "ResponsibleInformation", msg);
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
            ResponsibleInformation responsibleInformation;
            try {
                responsibleInformation = em.getReference(ResponsibleInformation.class, id);
                responsibleInformation.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The responsibleInformation with id " + id + " no longer exists.", enfe);
            }
            em.remove(responsibleInformation);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<ResponsibleInformation> findResponsibleInformationEntities() {
        return findResponsibleInformationEntities(true, -1, -1);
    }

    public List<ResponsibleInformation> findResponsibleInformationEntities(int maxResults, int firstResult) {
        return findResponsibleInformationEntities(false, maxResults, firstResult);
    }

    private List<ResponsibleInformation> findResponsibleInformationEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(ResponsibleInformation.class));
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

    public ResponsibleInformation findResponsibleInformation(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(ResponsibleInformation.class, id);
        } finally {
            em.close();
        }
    }

    public int getResponsibleInformationCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<ResponsibleInformation> rt = cq.from(ResponsibleInformation.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public List<ResponsibleInformation> findAllResponsibleInformation(){
        EntityManager em = getEntityManager();
        List<ResponsibleInformation>results = null;        
        TypedQuery<ResponsibleInformation> query = em.createNamedQuery("ResponsibleInformation.findAll",ResponsibleInformation.class);
        results = query.getResultList();                  
        return results;
    }
    
    public ResponsibleInformation findResponsibleInfoByUsername(String username) throws SabteAhvalException{
        try{
            EntityManager em = getEntityManager();
            ResponsibleInformation results = null;            
            TypedQuery<ResponsibleInformation> query = em.createNamedQuery("ResponsibleInformation.findByUsername",ResponsibleInformation.class);
            query.setParameter("username", username);
            results = query.getSingleResult();                  
            return results;
        } catch(NoResultException e){
            SabteAhvalException exception = new SabteAhvalException(CustomExceptionMessage.NO_RESULT_EXCEPTION, "ResponsibleInformation", e.getMessage());
            throw exception;
        }
    }
}
