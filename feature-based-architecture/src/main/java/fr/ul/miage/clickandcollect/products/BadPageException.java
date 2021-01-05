package fr.ul.miage.clickandcollect.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadPageException extends RuntimeException {

    public BadPageException(int page) {
        super("Page cannot have the value " + page + ", valid pages should start with zero");
    }
}
