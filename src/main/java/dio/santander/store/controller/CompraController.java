package dio.santander.store.controller;

import dio.santander.store.entity.Compra;
import dio.santander.store.service.CompraService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/compras")
public class CompraController {

    private final CompraService compraService;
    public CompraController(CompraService compraService) {
        this.compraService = compraService;
    }

    @GetMapping
    public ResponseEntity<Iterable<Compra>> listarCompras(){
        return ResponseEntity.ok(compraService.listarCompras());
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Compra> realizarCompra(@RequestBody Compra compra){
        Compra compraRealizada = compraService.realizarCompra(compra);
        return ResponseEntity.ok(compraRealizada);
    }
}
