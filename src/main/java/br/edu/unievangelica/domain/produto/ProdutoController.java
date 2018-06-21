package br.edu.unievangelica.domain.produto;

import br.edu.unievangelica.core.controller.ResponseAbstractController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/produto")
public class ProdutoController extends ResponseAbstractController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return jsonResponse(produtoService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findOne(@PathVariable long id) {
        return jsonResponse(produtoService.findOne(id));
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.save(produto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable long id, @RequestBody Produto produto) {
        return new ResponseEntity<>(produtoService.update(id, produto), HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable long id) {
        return jsonResponse(produtoService.delete(id));
    }
}
