package jeju.ac.kr.post.Controller;


import jeju.ac.kr.post.Domain.UserDto;
import jeju.ac.kr.post.Services.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public void getHome() {

    }

    @GetMapping("/register")
    public void getRegister() {

    }

    @PostMapping("/add/user")
    public String addUser(@RequestParam(value="name",required = true) String name,
                          @RequestParam(value="phone",required = true) String phone,
                          @RequestParam(value="email",required = true) String email,
                          @RequestParam(value="password",required = true) String password, ModelMap userModel) {

        System.out.println(email);
        UserDto user = new UserDto();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setPhone(phone);

        userService.addUser(user);
        userModel.addAttribute("message" ,"회원가입이 완료되었습니다.");
        return "redirect:/";
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(value="email",required = true) String email,
                            @RequestParam(value="password",required = true) String password, ModelMap userModel) {
        String path;
      UserDto user = userService.getUser(email);


      //유저정보가 없을시 다시 홈화면
        if(user == null) {
            userModel.addAttribute("message","회원정보가 없습니다.");
            path="redirect:/";
            //비밀번호가 일치할시 로그인
        } else if (user.getPassword().equals(password)) {
            userModel.addAttribute("message","로그인에 성공하였습니다.");
            path="redirect:/boards";
            //비밀번호가 다를시 다시 홈화면
        } else {
            userModel.addAttribute("message","이메일과 비밀번호가 다릅니다.");
            path="redirect:/";
        }
        return path;
    }

//    @RequestMapping("/exception")
//    public void exception() {
//        throw new RuntimeException("에러입니다.");
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ModelAndView error(Exception e) {
//        System.out.println();
//        ModelAndView modelAndView = new ModelAndView("error");
//        modelAndView.addObject("e",e)
//        return modelAndView;
//    }

}
