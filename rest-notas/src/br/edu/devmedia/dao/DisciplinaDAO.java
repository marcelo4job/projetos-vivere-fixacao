package br.edu.devmedia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.edu.devmedia.config.BDConfig;
import br.edu.devmedia.entidade.Aluno;
import br.edu.devmedia.entidade.Disciplina;

public class DisciplinaDAO {
	
	
	public List<Disciplina> listarDisciplinas() throws Exception {
        List<Disciplina> lista = new ArrayList<>();
 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "SELECT * FROM DISCIPLINA";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
 
        while (rs.next()) {
            Disciplina disciplina = new Disciplina();
            disciplina.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
            disciplina.setNome(rs.getString("NOME"));
            disciplina.setNota(rs.getInt("NOTA"));
                     
 
            lista.add(disciplina);
        }
 
        return lista;
    }
	
	
     
    public Disciplina buscarPorId(int idDisciplina) throws Exception {
        Disciplina disciplina = null;
 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "select * from disciplina where id_disciplina = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, idDisciplina);
        ResultSet rs = statement.executeQuery();
 
        if (rs.next()) {
            disciplina = new Disciplina();
            disciplina.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
            disciplina.setNome(rs.getString("NOME"));
            disciplina.setNota(rs.getInt("NOTA"));
        }
 
        return disciplina;
    }
    
    public int addDisciplina(Disciplina disciplina) throws Exception {
        int idGerado = 0;
        Connection conexao = BDConfig.getConnection();
 
        String sql = "insert into disciplina(nome, nota) VALUES(?, ?)";
 
        PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, disciplina.getNome());
        statement.setInt(2, disciplina.getNota());       
        statement.execute();
         
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
         
        return idGerado;
    }
    
    public void editarDisciplina(Disciplina disciplina, int idDisciplina) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "UPDATE DISCIPLINA SET NOME = ?, NOTA = ? WHERE ID_DISCIPLINA = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, disciplina.getNome());
        statement.setInt(2, disciplina.getNota());
        statement.setInt(3, disciplina.getId_disciplina());
        statement.execute();
    }
    
    public void removerDisciplina(int idDisciplina) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "DELETE FROM DISCIPLINA WHERE ID_DISCIPLINA = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, idDisciplina);
        statement.execute();
    }
    
    
}
