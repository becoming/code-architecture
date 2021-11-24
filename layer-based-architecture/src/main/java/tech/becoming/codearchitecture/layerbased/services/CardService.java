package tech.becoming.codearchitecture.layerbased.services;

public class CardService {

    private final UserService userService;

    public CardService(UserService userService) {
        this.userService = userService;
        userService.callMethod();
    }
}
