package org.esig.mavenproject1.dao;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.PersistenceContext;
import java.util.List;
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
            em.remove(taskToDelete);
        } else {
            throw new EntityNotFoundException("Nenhuma tarefa encontrada");
        }
    }
   
    @Override
    public List<Tasks> getTasks() {
        return em.createQuery("SELECT t FROM Tasks t", Tasks.class).getResultList();
    }

    
    
    
}
