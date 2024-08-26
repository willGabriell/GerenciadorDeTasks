package org.esig.mavenproject1.bean;

import jakarta.annotation.ManagedBean;
import jakarta.ejb.EJB;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.util.List;
import org.esig.mavenproject1.dao.TaskDao;
import org.esig.mavenproject1.enums.Status;
import org.esig.mavenproject1.model.Tasks;

@Named("TaskBean")
@RequestScoped
@ManagedBean
public class TaskBean {
    
    @EJB
    private TaskDao taskDao;
    private Tasks task = new Tasks();
    private List<Tasks> tasks;
    
    private String filterNumber;
    private String filterTitleDesc;
    private String filterResp;
    private String filterStatus;

    public String getFilterNumber() {
        return filterNumber;
    }

    public void setFilterNumber(String filterNumber) {
        this.filterNumber = filterNumber;
    }

    public String getFilterTitleDesc() {
        return filterTitleDesc;
    }

    public void setFilterTitleDesc(String filterTitleDesc) {
        this.filterTitleDesc = filterTitleDesc;
    }

    public String getFilterResp() {
        return filterResp;
    }

    public void setFilterResp(String filterResp) {
        this.filterResp = filterResp;
    }

    public String getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(String filterStatus) {
        this.filterStatus = filterStatus;
    }
    
    

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
    
    public void updateTask(Tasks task) {
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
    
    public void finishTask(Tasks task) {
        task.setStatus(Status.CONCLUIDA);
        taskDao.updateTask(task);
    }
    
    public void searchTasks() {
        
    }
    
    
}
