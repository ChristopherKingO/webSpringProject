package com.teacherStudent.webSpringProject.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("username")
public class WelcomeController {

    @RequestMapping(value="/",method = RequestMethod.GET)
    public String goToWelcomePage(ModelMap model) {
        model.put("username", getLoggedUsername());
        return "welcome";
    }

    private String getLoggedUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

//    @Autowired
//    private AuthenticationService authenticationService;
//
//    @RequestMapping(value="login",method = RequestMethod.POST)
//    public String goToWelcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
//
//        if (authenticationService.authenticate(username, password)){
//            model.put("username", username);
//            model.put("password", password);
//            return "welcome";
//        }
//        model.put("errorMessage", "Invalid Credentials for username " + username + " please try again");
//        return "login";
//    }

}
