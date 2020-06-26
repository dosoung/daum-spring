package jeju.ac.kr.post.Services;


import jeju.ac.kr.post.DaoFactory.BoardDao;
import jeju.ac.kr.post.Domain.BoardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//dao에서 받은 데이터를 가공
@Service
public class BoardService {


    private final BoardDao boardDao;

    public BoardService(BoardDao boardDao) {
        this.boardDao = boardDao;
    }

    @Transactional
    public BoardDto getBoard(final int id) {
        return boardDao.getBoard(id);
    }

    @Transactional
    public List<BoardDto> getBoards() {
        return boardDao.getBoards();
    }

    @Transactional
    public BoardDto setBoard(final String name,final String phone,final String email) {
        return boardDao.setBoard(name, phone, email);
    }

    @Transactional
    public void addBoard(final BoardDto board) {
        boardDao.addBoard(board);
    }

    @Transactional
    public void updateBoard(final BoardDto board) {
        boardDao.updateBoard(board);
    }

    @Transactional
    public void deleteBoard(final int id) {
        boardDao.deleteBoard(id);
    }

}
