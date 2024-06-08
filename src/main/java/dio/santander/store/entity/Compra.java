package dio.santander.store.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID da compra", example = "1")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    @JsonBackReference(value = "cliente-compras")
    @Schema(description = "Cliente que realizou a compra")
    private Cliente cliente;

    @ManyToOne
    @JsonBackReference(value = "produto-compras")
    @Schema(description = "Produto adquirido")
    @JoinColumn(name = "produto_id")
    private Produto produto;

    @Schema(description = "Quantidade adquirida", example = "2")
    private int quantidade;

    @Schema(description = "Data da compra", example = "2024-06-07T20:47:21.950Z")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private Date dateCompra;

    public Compra(){}

    public Compra(Cliente cliente, Produto produto, int quantidade) {
        this.cliente = cliente;
        this.produto = produto;
        this.quantidade = quantidade;
        this.dateCompra = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Date getDateCompra() {
        return dateCompra;
    }

    public void setDateCompra(Date dateCompra) {
        this.dateCompra = dateCompra;
    }
}
