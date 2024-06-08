package dio.santander.store.controller;

import dio.santander.store.entity.Produto;
import dio.santander.store.service.ProdutoService;
import dio.santander.store.service.implementations.ProdutoServiceImpl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;
    private final ProdutoServiceImpl produtoServiceImpl;

    public ProdutoController(ProdutoService produtoService, ProdutoServiceImpl produtoServiceImpl) {
        this.produtoService = produtoService;
        this.produtoServiceImpl = produtoServiceImpl;
    }

    @GetMapping
    public ResponseEntity<Iterable<Produto>> listarProdutos() {
        return ResponseEntity.ok(produtoService.listarProdutos());
    }

    @GetMapping("/{nome}")
    public ResponseEntity<List<Produto>> buscarProdutoPorNome(@PathVariable ("nome") String nome) {
        List<Produto> produtos =  produtoService.buscarProdutoNome(nome);
        return ResponseEntity.ok(produtos);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Produto> cadastrarProduto(@RequestBody Produto produto) {
        produtoService.cadastrarProduto(produto);
        return ResponseEntity.ok(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        produtoService.atualizarProduto(id, produto);
        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable Long id) {
        produtoService.excluirProduto(id);
        return ResponseEntity.noContent().build();
    }
}
