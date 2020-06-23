package jeju.ac.kr.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/teachr/{id}")
    public String getBoard(@PathVariable int id, ModelMap boardModel) {
        Board board = boardService.getBoard(id);
        boardModel.addAttribute("board",board);
        return "board";
    }

    @GetMapping("/boards")
    public String getBoards(ModelMap boardModel) {
        List<Board> boards = boardService.getBoards();
       boardModel.addAttribute("boards",boards);
        return "boards";
    }

    @GetMapping("/addBoard")
    public String addBoard() {
        return "add";
    }

    @PostMapping("/add/teacher")



}
