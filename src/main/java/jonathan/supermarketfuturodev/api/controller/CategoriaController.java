package jonathan.supermarketfuturodev.api.controller;



import jakarta.validation.Valid;
import jonathan.supermarketfuturodev.api.model.entity.Categoria;
import jonathan.supermarketfuturodev.api.model.service.interfaces.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")

public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> salvar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(this.categoriaService.salvar(categoria));
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> listar() {
        return ResponseEntity.ok(this.categoriaService.listar());
    }

    @PutMapping
    public ResponseEntity<Categoria> atualizar(@RequestBody @Valid Categoria categoria) {
        return ResponseEntity.ok(this.categoriaService.atualizar(categoria));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscar(@PathVariable Long id){
        return ResponseEntity.ok(this.categoriaService.buscar(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        this.categoriaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}