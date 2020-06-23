package jeju.ac.kr.post;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/test2")
    public void something() {

    }


}
