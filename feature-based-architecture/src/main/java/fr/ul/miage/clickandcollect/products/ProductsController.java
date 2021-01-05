package fr.ul.miage.clickandcollect.products;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.badRequest;
import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductsController {

    private final ProductService service;

    @GetMapping
    public Iterable<Product> getAllProducts(@RequestParam(defaultValue = "0") int page,
                                            @RequestParam(defaultValue = "50") int size) {

        return service.findPaged(page, size);
    }

    @GetMapping("{id}")
    public Product getById(@PathVariable Long id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product p) {
        return service
                .create(p)
                .map(ResponseEntity::ok)
                .getOrElseGet(t -> badRequest().build());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {

    }

    @PutMapping("{id}")
    public Product update(@RequestBody Product p, @PathVariable Long id) {
        return null;
    }
}
