package fr.ul.miage.clickandcollect.products;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "The name should have a value")
public class BadNameException extends RuntimeException {

}
