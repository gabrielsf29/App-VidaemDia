/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import controller.ProjectController;
import controller.TaskController;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import model.Project;
import model.Task;
import util.ConnectionFactory;

/**
 *
 * @author gabri
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
        // TODO code application logic here
        
        /*
        ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setName("Projeto Teste 2");
        project.setDescription("description 2");
        projectController.save(project);
        
        
        ProjectController projectController = new ProjectController();
        
        Project project = new Project();
        project.setId(1);        
        project.setName("Novo nome do projeto");
        project.setDescription("new description");
        
        projectController.update(project);
        
        
        List<Project> projects = projectController.getAll();
        System.out.println("Total de projetos = " + projects.size());
        */
        
        //ProjectController projectController = new ProjectController();
        //projectController.removeById(1);
        
        
        /*
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setIdproject(1);
        task.setName("Criar as telas da aplicação");
        task.setDescription("Devem ser criadas telas para os cadastros");
        task.setNotes("Sem notas");
        task.setIsCompleted(false);
        task.setDeadline(new Date());
        
        taskController.save(task);
         */
        
        /*
        TaskController taskController = new TaskController();
        
        Task task = new Task();
        task.setId(1);
        task.setIdproject(1);
        task.setName("alterar telas da aplicação");
        task.setNotes("Sem notas");
        task.setDescription("As telas para os cadastros devem ser alteradas");
        task.setDeadline(new Date());
        taskController.update(task);
        */
        /*
        TaskController taskController = new TaskController();
        
        List<Task> tasks = taskController.getAll(1);
        System.out.println("Total de tarefas = " + tasks.size());
        
        taskController.removeById(2);
        */
    }
    
}
