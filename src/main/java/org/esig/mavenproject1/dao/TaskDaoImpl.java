package org.esig.mavenproject1.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import java.util.List;
import org.esig.mavenproject1.enums.Responsibles;
import org.esig.mavenproject1.enums.Status;
import org.esig.mavenproject1.model.Tasks;

@Stateless
public class TaskDaoImpl implements TaskDao{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(Tasks task) {
        em.persist(task);
    }

    @Override
    public void updateTask(Tasks updatedTask) {
       Tasks existingTask = em.find(Tasks.class, updatedTask.getId());
       
       if(existingTask != null) {
           
           existingTask.setTitulo(updatedTask.getTitulo());
           existingTask.setDescricao(updatedTask.getDescricao());
           existingTask.setPrioridade(updatedTask.getPrioridade());
           existingTask.setResponsavel(updatedTask.getResponsavel());
           existingTask.setDeadline(updatedTask.getDeadline());
           existingTask.setStatus(updatedTask.getStatus());
           
           em.merge(existingTask);
           
       } else {
           throw new EntityNotFoundException("Nenhuma tarefa encontrada");
       }
       
    }

    
    @Override
    public void removeTask(Tasks taskToDelete) {
        Tasks existingTask = em.find(Tasks.class, taskToDelete.getId());
        
        if (existingTask != null) {
            em.remove(existingTask);
        } else {
            throw new EntityNotFoundException("Nenhuma tarefa encontrada");
        }
    }
   
    @Override
    public List<Tasks> getTasks() {
        return em.createQuery("SELECT t FROM Tasks t", Tasks.class).getResultList();
    }

   @Override
    public List<Tasks> searchTasks(Integer id, String titulo, Responsibles responsavel, Status status) {
        StringBuilder queryBuilder = new StringBuilder("SELECT t FROM Tasks t WHERE 1=1");

        if (id != null) {
            queryBuilder.append(" AND t.id = :id");
        }
        if (titulo != null && !titulo.isEmpty()) {
            queryBuilder.append(" AND t.titulo LIKE :titulo");
        }
        if (responsavel != null) {
            queryBuilder.append(" AND t.responsavel = :responsavel");
        }
        if (status != null) {
            queryBuilder.append(" AND t.status = :status");
        }

        TypedQuery<Tasks> query = em.createQuery(queryBuilder.toString(), Tasks.class);

        if (id != null) {
            query.setParameter("id", id);
        }
        if (titulo != null && !titulo.isEmpty()) {
            query.setParameter("titulo", "%" + titulo + "%");
        }
        if (responsavel != null) {
            query.setParameter("responsavel", responsavel);
        }
        if (status != null) {
            query.setParameter("status", status);
        }

        return query.getResultList();
    }

    
    
    
}
