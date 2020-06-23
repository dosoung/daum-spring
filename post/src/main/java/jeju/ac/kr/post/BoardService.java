package jeju.ac.kr.post;


import jeju.ac.kr.post.DaoFactory.BoardDao;
import jeju.ac.kr.post.Domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


//dao에서 받은 데이터를 가공
@Service
public class BoardService {


    @Autowired
    private BoardDao boardDao;

    public BoardDto getBoard(final int id) {
        return boardDao.getBoard(id);
    }

    public List<BoardDto> getBoards() {
        return boardDao.getBoards();
    }

    public void addBoard(final BoardDto board) {
        boardDao.addBoard(board);
    }

    public void updateBoard(final BoardDto board) {
        boardDao.updateBoard(board);
    }

    public void deleteBoard(final int id) {
        boardDao.deleteBoard(id);
    }

}
