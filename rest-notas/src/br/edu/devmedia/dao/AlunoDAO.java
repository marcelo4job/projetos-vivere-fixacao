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

public class AlunoDAO {
	
	public List<Aluno> listarAluno() throws Exception {
        List<Aluno> lista = new ArrayList<>();
 
        Connection conexao = BDConfig.getConnection();
 
        String sql = "SELECT * FROM TB_ALUNO";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
 
        while (rs.next()) {
            Aluno aluno = new Aluno();
            aluno.setId(rs.getInt("ID_ALUNO"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setTurma(rs.getString("TURMA"));  
            aluno.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
 
            lista.add(aluno);
            
        }
 
        return lista;
    }	
	
	public List<Aluno> listarNotasAlunos() throws Exception {
        List<Aluno> lista = new ArrayList<>();
         
        Connection conexao = BDConfig.getConnection();
 
        String sql = "select disciplina.*, tb_aluno.* from disciplina inner join tb_aluno on disciplina.id_disciplina = tb_aluno.id_aluno";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
 
        while (rs.next()) {
            Aluno aluno = new Aluno();
            
            
            aluno.setId(rs.getInt("ID_ALUNO"));
            aluno.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
            aluno.setNome(rs.getString("NOME"));
            aluno.setTurma(rs.getString("TURMA"));
           // aluno.setId_disciplina(rs.getInt("ID_DISCIPLINA"));      
            
 
            lista.add(aluno);
                        
        }
 
        return lista;
    }
	
	public Aluno buscarAlunoPorId(int idAluno) throws Exception {
	        Aluno aluno = null;
	 
	        Connection conexao = BDConfig.getConnection();
	 
	        String sql = "SELECT * FROM TB_ALUNO WHERE ID_ALUNO = ?";
	 
	        PreparedStatement statement = conexao.prepareStatement(sql);
	        statement.setInt(1, idAluno);
	        ResultSet rs = statement.executeQuery();
	 
	        if (rs.next()) {
	            aluno = new Aluno();
	            aluno.setId(rs.getInt("ID_ALUNO"));
	            aluno.setNome(rs.getString("NOME"));
	            aluno.setTurma(rs.getString("TURMA"));
	            aluno.setId_disciplina(rs.getInt("ID_DISCIPLINA"));
	            
	        }
	 
	        return aluno;
	    }

	public int addAluno(Aluno aluno) throws Exception {
        int idGerado = 0;
        Connection conexao = BDConfig.getConnection();
 
        String sql = "INSERT INTO TB_ALUNO(NOME, TURMA) VALUES(?, ?)";
 
        PreparedStatement statement = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        statement.setString(1, aluno.getNome());
        statement.setString(2, aluno.getTurma());
        statement.setInt(3, aluno.getId_disciplina());
        statement.execute();
         
        ResultSet rs = statement.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
         
        return idGerado;
    }

	public void editarAluno(Aluno aluno, int idAluno) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "UPDATE TB_ALUNO SET NOME = ?, TURMA = ? WHERE ID_ALUNO = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setString(1, aluno.getNome());
        statement.setString(2, aluno.getTurma());
        statement.setInt(3, aluno.getId_disciplina());   
        statement.execute();
    }

	public void removerAluno(int idAluno) throws Exception {
        Connection conexao = BDConfig.getConnection();
 
        String sql = "DELETE FROM TB_ALUNO WHERE ID_ALUNO = ?";
 
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.setInt(1, idAluno);
        statement.execute();
    }
	 
	 
	 
	

}
