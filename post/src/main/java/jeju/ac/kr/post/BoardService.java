package jeju.ac.kr.post;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//dao에서 받은 데이터를 가공
@Service
public class BoardService {


    @Autowired
    private BoardDao boardDao;

    public Board getBoard(final int id) {
        return boardDao.getBoard(id);
    }

    public List<Board> getBoards() {
        return boardDao.getBoards();
    }

    public void addBoard(final Board board) {
        boardDao.addBoard(board);
    }

    public void updateBoard(final Board board) {
        boardDao.updateBoard(board);
    }

    public void deleteBoard(final int id) {
        boardDao.deleteBoard(id);
    }

}
