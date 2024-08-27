package org.esig.mavenproject1.bean;

import jakarta.annotation.ManagedBean;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.EJB;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import java.io.Serializable;
import java.util.List;
import org.esig.mavenproject1.dao.TaskDao;
import org.esig.mavenproject1.enums.Responsibles;
import org.esig.mavenproject1.enums.Status;
import org.esig.mavenproject1.model.Tasks;

@Named("TaskBean")
@ViewScoped
@ManagedBean
public class TaskBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @EJB
    private TaskDao taskDao;
    private Tasks task = new Tasks();
    private List<Tasks> tasks;
    
    private Integer filterNumber;
    private String filterTitleDesc;
    private Responsibles filterResp;
    private Status filterStatus;
   
    private boolean create = true;
    private boolean searchPerformed = false;
    private boolean editing = false;
    

    @PostConstruct
    public void init() {
        tasks = taskDao.searchTasks(null, null, null, null);
    }
    
    public Integer getFilterNumber() {
        return filterNumber;
    }

    public void setFilterNumber(Integer filterNumber) {
        this.filterNumber = filterNumber;
    }

    public String getFilterTitleDesc() {
        return filterTitleDesc;
    }

    public void setFilterTitleDesc(String filterTitleDesc) {
        this.filterTitleDesc = filterTitleDesc;
    }

    public Responsibles getFilterResp() {
        return filterResp;
    }

    public void setFilterResp(Responsibles filterResp) {
        this.filterResp = filterResp;
    }

    public Status getFilterStatus() {
        return filterStatus;
    }

    public void setFilterStatus(Status filterStatus) {
        this.filterStatus = filterStatus;
    }
    
    public boolean isCreate() {
        return create;
    }
    
    public boolean isEditing() {
        return editing;
    }

    public void setEditing(boolean editing) {
        this.editing = editing;
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
        if(searchPerformed) {
            return tasks;
        } else {
            tasks = taskDao.getTasks();
            return tasks;    
        }      
    }
    
    
    public void finishTask(Tasks task) {
        task.setStatus(Status.CONCLUIDA);
        taskDao.updateTask(task);
    }
    
    public List<Tasks> searchTasks() {
        tasks = taskDao.searchTasks(filterNumber, filterTitleDesc, filterResp, filterStatus);
        System.out.println("total encontrada: " + tasks.size());
        searchPerformed = true;
        for (Tasks t : tasks) {
        System.out.println("Tarefa: " + t.getId() + " - " + t.getTitulo());
        }
        return tasks;
    }
    
    @Transactional
    public void updateTask() {
        if (task != null) {
            taskDao.updateTask(task);
            tasks = taskDao.getTasks();
            task = new Tasks();
            editing = false;
            create = true;  
        }
        
    }
    
    public void cancelEdit() {
    task = new Tasks();
    this.editing = false;
    this.create = true;
}

    public void prepareEditTask(Tasks taskToEdit) {
    this.task = taskToEdit;
    this.editing = true;
    this.create = false;
}


    
}
