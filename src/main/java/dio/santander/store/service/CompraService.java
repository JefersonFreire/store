package dio.santander.store.service;

import dio.santander.store.entity.Compra;
import dio.santander.store.entity.Produto;

public interface CompraService {

    Iterable<Compra> listarCompras();
    Compra realizarCompra(Compra compra);
}
