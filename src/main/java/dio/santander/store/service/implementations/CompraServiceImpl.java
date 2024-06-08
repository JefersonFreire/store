package dio.santander.store.service.implementations;

import dio.santander.store.entity.Compra;
import dio.santander.store.entity.Produto;
import dio.santander.store.repository.CompraRepository;
import dio.santander.store.service.CompraService;
import org.springframework.stereotype.Service;

@Service
public class CompraServiceImpl implements CompraService {

    private final CompraRepository compraRepository;
    public CompraServiceImpl(CompraRepository compraRepository) {
        this.compraRepository = compraRepository;
    }

    @Override
    public Iterable<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    @Override
    public Compra realizarCompra(Compra compra) {
        return compraRepository.save(compra);
    }
}
