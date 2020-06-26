package jeju.ac.kr.post.Controller;


import jeju.ac.kr.post.Domain.UserDto;
import jeju.ac.kr.post.Services.UserService;
import org.apache.catalina.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
                          @RequestParam(value="password",required = true) String password,
                          @RequestParam(value="password2",required = true) String password2,
                          RedirectAttributes rttr) {
        if(name.equals("") || phone.equals("")|| email.equals("") || password.equals("") ||password2.equals("")) {
            rttr.addFlashAttribute("msg",0);
            return "redirect:/register";
        } else if(!password.equals(password2)) {
            rttr.addFlashAttribute("msg",1);
            return "redirect:/register";
        }
            UserDto user = userService.setUser(name, phone, email, password);
            boolean error =  userService.addUser(user);

            if(error==true) {
                rttr.addFlashAttribute("msg",2);
                return "redirect:/register";
            }

            rttr.addFlashAttribute("msg", true);
            return "redirect:/";

    }

    @PostMapping("/login")
    public String loginUser(@RequestParam(value="email",required = true) String email,
                            @RequestParam(value="password",required = true) String password,
                            RedirectAttributes rttr, HttpServletRequest request) {
        HttpSession session = request.getSession();
        UserDto user = userService.getUser(email);
        if(user == null) {
            rttr.addFlashAttribute("msg",false);
            return "redirect:/";
        }
        //비밀번호가 일치할시 로그인
        String path;

        Boolean aBoolean = userService.matchPW(email,password);
        if(aBoolean) {
            session.setAttribute("member",user);
            path="redirect:/boards";
        } else {
            rttr.addFlashAttribute("msg",false);
            session.setAttribute("member",null);
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
