package tech.becoming.codearchitecture.featurebased.user;

public class UserController {


    private final UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    public void postBuild() {
        userFacade.buildAll();
    }
}
