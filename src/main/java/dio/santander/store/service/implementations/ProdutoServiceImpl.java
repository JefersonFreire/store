package dio.santander.store.service.implementations;

import dio.santander.store.entity.Produto;
import dio.santander.store.repository.ProdutoRepository;
import dio.santander.store.service.ProdutoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;
    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    public Iterable<Produto> listarProdutos() {
        return produtoRepository.findAll();
    }

    @Override
    public List<Produto> buscarProdutoNome(String nome) {
        List<Produto> produtos = new ArrayList<>();
        for (Produto produto : produtoRepository.findAll()) {
            if (produto.getNome().contains(nome)) {
                produtos.add(produto);
            }
        }
        return produtos;
    }

    @Override
    public void cadastrarProduto(Produto produto) {
        produtoRepository.save(produto);
    }

    @Override
    public void atualizarProduto(Long id, Produto produto) {
        Optional<Produto> produto1 = produtoRepository.findById(String.valueOf(id));
        if (produto1.isPresent()) {
            ResponseEntity.ok(produtoRepository.save(produto));
        }
    }

    @Override
    public void excluirProduto(Long id) {
        produtoRepository.deleteById(String.valueOf(id));
    }
}
