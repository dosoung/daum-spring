package jeju.ac.kr.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/{id}")
    public String getBoard(@PathVariable int id, ModelMap boardModel) {
        Board board = boardService.getBoard(id);
        boardModel.addAttribute("board",board);
        return "board";
    }

    @GetMapping("/boards")
    public String getBoards(ModelMap boardModel) {
        System.out.println("*********************************************");
        List<Board> boards = boardService.getBoards();
       boardModel.addAttribute("boards",boards);
        return "boards";
    }


    @GetMapping("/addBoard")
    public String addBoard() {
        return "add";
    }

    @PostMapping("/add/boardr")
    public String addBoard(@RequestParam(value="name",required=true) String name,
                           @RequestParam(value="name",required=true) String phone,
                           @RequestParam(value="name",required=true) String email, ModelMap boardModel) {

        Board board = new Board();
        board.setName(name);
        board.setPhone(phone);
        board.setEmail(email);
        boardService.addBoard(board);
        boardModel.addAttribute("message","게시글 등록이 완료 되었습니다.");
        List<Board> boards = boardService.getBoards();
        return "redirect:/boards";
    }

//    @GetMapping("/update/teacher")



}
