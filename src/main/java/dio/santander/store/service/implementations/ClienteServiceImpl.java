package dio.santander.store.service.implementations;

import dio.santander.store.entity.Cliente;
import dio.santander.store.entity.Endereco;
import dio.santander.store.repository.ClienteRepository;
import dio.santander.store.repository.EnderecoRepository;
import dio.santander.store.service.ClienteService;
import dio.santander.store.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService {



    private final EnderecoRepository enderecoRepository;
    private final ClienteRepository clienteRepository;
    private final ViaCepService viaCepService;
    public ClienteServiceImpl(ClienteRepository clienteRepository, EnderecoRepository enderecoRepository, ViaCepService viaCepService) {
        this.clienteRepository = clienteRepository;
        this.enderecoRepository = enderecoRepository;
        this.viaCepService = viaCepService;
    }


    @Override
    public Iterable<Cliente> listarClientes() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente listarClientePorId(Long id) {
        Optional<Cliente> cliente = clienteRepository.findById(id);
        return cliente.get();
    }

    @Override
    public void cadastrarCliente(Cliente cliente) {
        cadastrarClienteCep(cliente);
    }

    @Override
    public void alterarCliente(Long id, Cliente cliente) {
        Optional<Cliente> cliente1 = clienteRepository.findById(id);
        if (cliente1.isPresent()) {
            cadastrarClienteCep(cliente);
        }
    }

    @Override
    public void removerCliente(Long id) {
        clienteRepository.deleteById(id);
    }

    private void cadastrarClienteCep(Cliente cliente) {
        String cep = cliente.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {
        Endereco endereco1 = viaCepService.obterCep(cep);
        enderecoRepository.save(endereco1);
        return endereco1;
        });
        cliente.setEndereco(endereco);
        clienteRepository.save(cliente);
    }
}
