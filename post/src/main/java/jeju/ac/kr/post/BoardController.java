package jeju.ac.kr.post;

import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.Services.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BoardController {

    @Autowired
    private BoardService boardService;

    @GetMapping("/board/{id}")
    public String getBoard(@PathVariable int id, ModelMap boardModel) {
        BoardDto board = boardService.getBoard(id);
        boardModel.addAttribute("board",board);
        return "board";
    }

    @GetMapping("/boards")
    public String getBoards(ModelMap boardModel) {
        System.out.println("*********************************************");
        List<BoardDto> boards = boardService.getBoards();
       boardModel.addAttribute("boards",boards);
        return "boards";
    }


    @GetMapping("/addBoard")
    public String addBoard() {
        return "add";
    }

    @PostMapping("/add/board")
    public String addBoard(@RequestParam(value="name",required=true) String name,
                           @RequestParam(value="phone",required=true) String phone,
                           @RequestParam(value="email",required=true) String email, ModelMap boardModel) {

        BoardDto board = new BoardDto();
        board.setName(name);
        board.setPhone(phone);
        board.setEmail(email);
        boardService.addBoard(board);
        boardModel.addAttribute("message","게시글 등록이 완료 되었습니다.");
        List<BoardDto> boards = boardService.getBoards();
        return "redirect:/boards";
    }

    @GetMapping("update/board/{id}")
    public String updatePost(@PathVariable("id") int id, ModelMap boardModel) {
        boardModel.addAttribute("id",id);
        BoardDto board = boardService.getBoard(id);
        boardModel.addAttribute("board",board);
        return "update";
    }

    @PostMapping("/update/board")
    public String updateBoard(@RequestParam int id, @RequestParam(value="name", required=true) String name,
                              @RequestParam(value="phone" ,required=true) String phone,
                              @RequestParam(value="email", required=true) String email, ModelMap boardModel) {
        BoardDto board = new BoardDto(id,name,phone,email);

        boardService.updateBoard(board);
        List<BoardDto> boards = boardService.getBoards();
        boardModel.addAttribute("boards",boards);
        boardModel.addAttribute("id",id);
        boardModel.addAttribute("message","게시판 수정이 완료 되었습니다.");
        return "redirect:/boards";
    }

    @GetMapping("/delete/board/{id}")
    public String deleteBoard(@PathVariable int id, ModelMap boardModel) {
        boardService.deleteBoard(id);
        List<BoardDto> boards = boardService.getBoards();
        boardModel.addAttribute("boards",boards);
        boardModel.addAttribute("messamge","삭제가 완료 되었습니다.");
        return "redirect:/boards";
    }



}
