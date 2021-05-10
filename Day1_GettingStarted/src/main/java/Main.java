import java.nio.file.AccessDeniedException;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class Main {

    public static void main(String[] args) throws AccessDeniedException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Scanner input = new Scanner(System.in);
        System.out.println("Username: ");
        String username = input.nextLine();
        System.out.println("Password: ");
        String password = input.nextLine();
        input.close();

//        System.out.println("Encoding :" + new BCryptPasswordEncoder().encode(password) + "\n");

        try{

            Authentication authenticationToken = new UsernamePasswordAuthenticationToken(username, password);

            AuthenticationManager authenticationManager = context.getBean(AuthenticationManager.class);

            Authentication authenticatedToken = authenticationManager.authenticate(authenticationToken);

            // SecurityContextImpl securityContext = new SecurityContextImpl();
            // securityContext.setAuthentication(authenticatedToken);
            // SecurityContextHolder.setContext(securityContext);

            // HelloService helloService = context.getBean("helloService", HelloService.class);

            // System.out.println("hello .. user");
            // System.out.println(helloService.onlyUserCanAccess(" testUser"));
//            System.out.println(helloService.onlyAdminCanAccess(" testAdmin"));
//            System.out.println(helloService.testPermitAll(" test Permit all"));
//            System.out.println(helloService.testPreAuthorize("PreAndPost method"));
        }
        catch (BadCredentialsException e){
            System.out.println("Not Authenticated");
        }
//        catch (AccessDeniedException e){
//
//        }

        context.close();
    }
}
