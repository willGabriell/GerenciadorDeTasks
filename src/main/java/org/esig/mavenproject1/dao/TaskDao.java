package org.esig.mavenproject1.dao;

import java.util.List;
import org.esig.mavenproject1.enums.Responsibles;
import org.esig.mavenproject1.enums.Status;
import org.esig.mavenproject1.model.Tasks;

public interface TaskDao {
    void save(Tasks task);
    void updateTask(Tasks task);
    void removeTask(Tasks task);
    List<Tasks> getTasks();
    List<Tasks> searchTasks(Integer id, String titulo, Responsibles responsavel, Status status);  
}
