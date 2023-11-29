/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Project;
import util.ConnectionFactory;

/**
 *
 * @author gabriel
 */
public class ProjectController {
    
    public void save (Project project){
        
        String sql = "INSERT INTO projects (name, "
                + "description, "
                + "createdAt, "
                + "updatedAt) "
                + "VALUES (?,?,?,?)";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setString(1, project.getName());
            statement.setString (2, project.getDescription());
            statement.setDate (3, new Date (project.getCreatedAt().getTime()) );
            statement.setDate (4, new Date (project.getUpdatedAt().getTime()) );
            
            //Executando a query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar o Projeto" 
                    + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
    }
    
    public void update (Project project){
        String sql = "UPDATE projects SET "
                + "name = ?, "
                + "description = ?, "
                + "createdAt = ?, "
                + "updatedAt = ? "
                + "WHERE id = ?";
        
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            //Estabelecendo conexão com o servidor
            connection = ConnectionFactory.getConnection();
        
            //Preparando a query
            statement = connection.prepareStatement(sql);
            
            //Setando os valores do statement
            statement.setString (1, project.getName());
            statement.setString (2, project.getDescription());
            statement.setDate (3, new Date (project.getCreatedAt().getTime()) );
            statement.setDate (4, new Date (project.getUpdatedAt().getTime()) );
            statement.setInt (5, project.getId());
            
            //Executando a query
            statement.execute();
            
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao atualizar o projeto " 
            + ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);
        }
 
    }
    
     public void removeById (int id) {
         
         String sql = "DELETE FROM projects WHERE id = ?";
         
         Connection connection = null;
         PreparedStatement statement = null;
        
         try {
            //Estabelecendo conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
         
            //Preparando a query
            statement = connection.prepareStatement(sql);
         
            //Setando o valor do statement
            statement.setInt(1, id);
            
            //Executando a query
            statement.execute();
            
         } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o projeto ", ex);
        } finally {
            ConnectionFactory.closeConnection(connection, statement);             
         }
     }
     
     public List <Project> getAll (){
         
        String sql = "SELECT * FROM projects";
         
        List<Project> projects = new ArrayList<>();       
                 
        Connection connection = null;
        PreparedStatement statement = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet resultSet = null;
        
        try {
            //Estabelecendo a conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
             
            //Preparando a query
            statement = connection.prepareStatement(sql);
             
            //Valor retornado pela execução da query
            resultSet = statement.executeQuery();
             
            //Enquanto existir dados no banco de dados, faça
            while (resultSet.next()){
                 
                Project project = new Project();
                project.setId(resultSet.getInt("id"));
                project.setName(resultSet.getString ("name"));
                project.setDescription(resultSet.getString ("description"));
                project.setCreatedAt(resultSet.getDate ("createdAt"));
                project.setUpdatedAt(resultSet.getDate ("updatedAt"));
                
                //Adiciono o contato recuperado para a lista de contatos
                projects.add(project);
            }
             
         } catch (SQLException ex) {
             throw new RuntimeException ("Erro ao buscar os projetos " 
                     + ex.getMessage(), ex);
         } finally {
            ConnectionFactory.closeConnection(connection, statement, resultSet);
         }
        
        //Lista de projetos que foi criada e carregada do banco de dados
        return projects;
         
     }
}
