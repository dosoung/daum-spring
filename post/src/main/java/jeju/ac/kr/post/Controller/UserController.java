package jeju.ac.kr.post.Controller;


import jeju.ac.kr.post.Services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/home")
    public void getHome() {

    }

    @GetMapping("/register")
    public void getRegister() {

    }
}
