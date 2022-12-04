package jonathan.supermarketfuturodev.api.controller;


import jakarta.validation.Valid;
import jonathan.supermarketfuturodev.api.model.entity.Produto;
import jonathan.supermarketfuturodev.api.model.service.interfaces.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvar (@RequestBody @Valid Produto produto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.produtoService.salvar(produto));
    }
    @GetMapping
    public ResponseEntity <List<Produto>> listar(){
        return ResponseEntity.ok(this.produtoService.listar());
    }

    @PutMapping
    public ResponseEntity<Produto> atualizar(@RequestBody Produto produto){
        return ResponseEntity.ok(this.produtoService.atualizar(produto));
    }
//    @GetMapping("/valor")
//    public ResponseEntity<List<Produto>> totalComprado(){
//        return ResponseEntity.ok(this.produtoService.)
//    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id){
        return ResponseEntity.ok(this.produtoService.buscar(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir (@PathVariable Long id){
        this.produtoService.excluir(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/comprados")
    public ResponseEntity<List<Produto>> listarComprados(){
        return ResponseEntity.ok(this.produtoService.listarComprados());
    }

}
