package org.esig.mavenproject1.bean;

import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.util.List;
import org.esig.mavenproject1.dao.TaskDao;
import org.esig.mavenproject1.model.Tasks;

@Named("TaskBean")
@RequestScoped
@ManagedBean
public class TaskBean {
    @EJB
    private TaskDao taskDao;
    private Tasks task = new Tasks();
    private List<Tasks> tasks;

    public Tasks getTask() {
        return task;
    }

    public void setTask(Tasks task) {
        this.task = task;
    }
    
    @Transactional
    public void addTask() {
        taskDao.save(task);
        task = new Tasks();
        tasks = taskDao.getTasks();
    }
    
    public void updateTask() {
        taskDao.updateTask(task);
        task = new Tasks();
        tasks = taskDao.getTasks();
        
        
    }
    
    public void removeTask(Tasks taskToRemove) {
        taskDao.removeTask(taskToRemove);
        tasks = taskDao.getTasks();
    }
    
    public List<Tasks> getTasks() {
        tasks = taskDao.getTasks();
        return tasks;
    }
    
    
    
    
}
