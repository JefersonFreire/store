package dio.santander.store.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "Código do produto", example = "1")
    private Long codigo;

    @Schema (description = "Preço do produto", example = "29.99")
    private BigDecimal preco;

    @Schema(description = "Nome do produto", example = "Lápis")
    private String nome;

    @Schema(description = "Quantidade em estoque", example = "100")
    private int quantidade;

    public Produto() {
    }

    @OneToMany(mappedBy = "produto", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference(value = "produto-compras")
    private List<Compra> compras;

    @JsonCreator
    public Produto(@JsonProperty("nome") String nome, @JsonProperty("preco") BigDecimal preco, @JsonProperty("quantidade") int quantidade ) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public List<Compra> getCompras() {
        return compras;
    }

    public void setCompras(List<Compra> compras) {
        this.compras = compras;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    @JsonProperty("nome")
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
