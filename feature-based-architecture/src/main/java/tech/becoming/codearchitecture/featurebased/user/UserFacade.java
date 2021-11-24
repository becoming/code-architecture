package tech.becoming.codearchitecture.featurebased.user;

import tech.becoming.codearchitecture.featurebased.card.CardService;

public class UserFacade {

    private final CardService cardService;
    private final UserService userService;

    public UserFacade(CardService cardService, UserService userService) {
        this.cardService = cardService;
        this.userService = userService;
    }

    public User buildAll() {
        User user = userService.createUser();
        List<Card> cards = cardService.buildTemplateCards(user);

        // .. cards operations

        return user;
    }
}
