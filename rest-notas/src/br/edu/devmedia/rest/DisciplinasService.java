package br.edu.devmedia.rest;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.devmedia.dao.DisciplinaDAO;
import br.edu.devmedia.entidade.Disciplina;

@Path("/disciplina")
public class DisciplinasService {
	
	 private static final String CHARSET_UTF8 = ";charset=utf-8";
	
	 private DisciplinaDAO disciplinaDAO;
	 
	 @PostConstruct
	 private void init() {
		 
		 disciplinaDAO = new DisciplinaDAO();
		 
	 }
	 
	    @GET
	    @Path("/list")
	    @Produces(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    public List<Disciplina> listarDisciplinas() {
	        List<Disciplina> lista = null;
	        try {
	            lista = disciplinaDAO.listarDisciplinas();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	    
	   
	    
	    
	    
	    
	    @POST
	    @Path("/add")
	    @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
	    @Produces(MediaType.TEXT_PLAIN)
	    public String addDisciplina(Disciplina disciplina) {
	        String msg = "";
	 
	        System.out.println(disciplina.getNome());
	 
	        try {
	            int idGerado = disciplinaDAO.addDisciplina(disciplina);
	 
	            msg = " Nota adicionada com sucesso!";
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
	    public Disciplina buscarPorId(@PathParam("id") int idDisciplina) {
	        Disciplina disciplina = null;
	        try {
	            disciplina = disciplinaDAO.buscarPorId(idDisciplina);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	 
	        return disciplina;
	    }
     
     @PUT
     @Path("/edit/{id}")
     @Consumes(MediaType.APPLICATION_JSON + CHARSET_UTF8)
     @Produces(MediaType.TEXT_PLAIN)
     public String editarDisciplina(Disciplina disciplina, @PathParam("id") int idDisciplina) {
         String msg = "";
          
         System.out.println(disciplina.getNome());
          
         try {
             disciplinaDAO.editarDisciplina(disciplina, idDisciplina);
              
             msg = "Disciplina editada com sucesso!";
         } catch (Exception e) {
             msg = "Erro ao editar a disciplina!";
             e.printStackTrace();
         }
          
         return msg;
     }
     
     @DELETE
     @Path("/delete/{id}")
     @Consumes(MediaType.APPLICATION_JSON)
     @Produces(MediaType.TEXT_PLAIN)
     public String removerDisciplina(@PathParam("id") int idDisciplina) {
         String msg = "";
          
         try {
             disciplinaDAO.removerDisciplina(idDisciplina);
              
             msg = "Disciplina removida com sucesso!";
         } catch (Exception e) {
             msg = "Não é possível remover uma disciplina com aluno vinculado!";
             e.printStackTrace();
         }
          
         return msg;
     }

}
