package br.edu.devmedia.rest;

import br.edu.devmedia.dao.AlunoDAO;
import br.edu.devmedia.entidade.Aluno;

import javax.annotation.PostConstruct;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/aluno")
public class AlunosService {
	private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	private AlunoDAO alunoDAO;
	
	@PostConstruct
	 private void init() {
		 
		 alunoDAO = new AlunoDAO();
}
	
	  @GET
	    @Path("/list")
	    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    public List<Aluno> listarAluno() {

	        List<Aluno> lista = null;
	        try {
	            lista = alunoDAO.listarAluno();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return lista;
	        
	        //OK
	    }
	  
	    @GET
	    @Path("/listna")
	    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    public List<Aluno> listarNotasAlunos() {
	        List<Aluno> lista = null;
	        try {
	            lista = alunoDAO.listarNotasAlunos();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	    
	  
	  
	    @POST
	    @Path("/add")
	    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    @Produces(MediaType.TEXT_PLAIN)
	    public String addAluno(Aluno aluno) {
	        String msg = "";
	 
	        System.out.println(aluno.getNome());	 
	        
	        try {
	            int idGerado = alunoDAO.addAluno(aluno);
	 
	            msg = " Aluno adicionado com sucesso!";
	        } catch (Exception e) {
	            msg = "Erro ao add a nota!";
	            e.printStackTrace();
	        }
	 
	        return msg;
	    }
	  

	    @GET
	    @Path("/get/{id}")
	    @Consumes(MediaType.TEXT_PLAIN)
	    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    public Aluno buscarPorId(@PathParam("id") int idAluno) {
	        Aluno aluno = null;
	        try {
	            aluno = alunoDAO.buscarAlunoPorId(idAluno);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        return aluno;
	    }
	  
	    @PUT
	     @Path("/edit/{id}")
	     @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	     @Produces(MediaType.TEXT_PLAIN)
	     public String editarAluno(Aluno aluno, @PathParam("id") int idAluno) {
	         String msg = "";
	          
	         System.out.println(aluno.getNome());
	          
	         try {
	             alunoDAO.editarAluno(aluno, idAluno);
	              
	             msg = "Aluno editado com sucesso!";
	         } catch (Exception e) {
	             msg = "Erro ao editar o aluno!";
	             e.printStackTrace();
	         }
	          
	         return msg;
	     }
	    
	    @DELETE
	     @Path("/delete/{id}")
	     @Consumes(MediaType.APPLICATION_JSON)
	     @Produces(MediaType.TEXT_PLAIN)
	     public String removerAluno(@PathParam("id") int idAluno) {
	         String msg = "";
	          
	         try {
	             alunoDAO.removerAluno(idAluno);
	              
	             msg = "Aluno removido com sucesso!";
	         } catch (Exception e) {
	             msg = "Erro ao remover o aluno!";
	             e.printStackTrace();
	         }
	          
	         return msg;
	     }
}
