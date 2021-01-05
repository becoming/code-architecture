package fr.ul.miage.clickandcollect.products;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repo;
    private List<String> strings;

    public Iterable<Product> findPaged(int page, int size) {
        validatePage(page, size);

        return repo
                .findAll(PageRequest.of(page, size))
                .getContent();
    }

    private void validatePage(int page, int size) {
        if (page < 0) {
            throw new BadPageException(page);
        }
    }

    public Try<Product> create(Product p) {
        return Try
            .of(() -> validateProduct(p))
            .andThen(() -> repo.save(p));
    }

    private Product validateProduct(Product p) {
        if (p.getName() == null || p.getName().isBlank()) {
            throw new BadNameException();
        }

        if (p.getDescription() == null || p.getDescription().isBlank()) {
            throw new BadDescriptionException();
        }

        return p;
    }
}
