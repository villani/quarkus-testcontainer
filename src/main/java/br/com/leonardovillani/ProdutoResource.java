package br.com.leonardovillani;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("produtos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProdutoResource {

    @GET
    public List<Produto> buscarTodosProdutos() {
        return Produto.listAll();
    }

    @POST
    @Transactional
    public void cadastrarProduto(CadastrarProdutoDTO dto) {
        Produto p = new Produto();
        p.nome = dto.getNome();
        p.valor = dto.getValor();
        p.persist();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public void atualizarProduto(@PathParam("id") Long id, CadastrarProdutoDTO dto) {

        Optional<Produto> pOpt = Produto.findByIdOptional(id);

        if (pOpt.isPresent()) {
            Produto p = pOpt.get();
            p.nome = dto.getNome();
            p.valor = dto.getValor();
            p.persist();
        } else {
            throw new NotFoundException();
        }
        
    }

    @DELETE
    @Path("{id}")
    @Transactional
    public void excluirProduto(@PathParam("id") Long id) {

        Optional<Produto> pOpt = Produto.findByIdOptional(id);

        pOpt.ifPresentOrElse(Produto::delete, () -> {
            throw new NotFoundException();
        });
    }
    
}
