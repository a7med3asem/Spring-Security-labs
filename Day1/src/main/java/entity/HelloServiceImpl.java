package entity;

public class HelloServiceImpl implements HelloService {

    @Override
    public String onlyUserCanAccess(String message) {

        return "test onlyUserCanAccess(String name) with name " + message;
    }

    @Override
    public String onlyManagerCanAccess(String message) {

        return "test onlyManagerCanAccess(String message) with message " + message;
    }

    @Override
    public String onlyAdminCanAccess(String message) {

        return "test onlyAdminCanAccess(String message) with message " + message;
    }

    @Override
    public String testPermitAll(String message) {
        return "test testPermitAll(String message) with message " + message;
    }

    @Override
    public String testPreAuthorize(String message) {
        return "test testPreAuthorize(String message) with message " + message;
    }

    @Override
    public String testPostAuthorize(String message) {
        return "test testPostAuthorize(String message) with message " + message;
    }
}
