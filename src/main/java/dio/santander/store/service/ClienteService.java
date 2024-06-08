package dio.santander.store.service;

import dio.santander.store.entity.Cliente;

public interface ClienteService {

    Iterable <Cliente> listarClientes();
    Cliente listarClientePorId(Long id);
    void cadastrarCliente(Cliente cliente);
    void alterarCliente(Long id, Cliente cliente);
    void removerCliente(Long id);
}
