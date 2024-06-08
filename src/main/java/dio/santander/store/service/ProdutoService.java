package dio.santander.store.service;

import dio.santander.store.entity.Produto;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProdutoService {
    Iterable<Produto> listarProdutos();

    @Query(value = "select u from Produto u where u.nome like %?1%")
    List<Produto> buscarProdutoNome(String nome);

    void cadastrarProduto(Produto produto);
    void atualizarProduto(Long id, Produto produto);
    void excluirProduto(Long id);
}
