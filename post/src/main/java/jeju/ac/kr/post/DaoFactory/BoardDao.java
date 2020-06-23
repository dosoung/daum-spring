package jeju.ac.kr.post.DaoFactory;

import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.BoardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



//data accesss object
@Transactional
@Component
public class BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BoardDto getBoard(final int id) {
        BoardDto board = jdbcTemplate.queryForObject("select * from board where id=?", new Object[] {id},
                new BoardRowMapper());
        return board;
    }

    public List<BoardDto> getBoards() {
        List<BoardDto> boards = jdbcTemplate.query("select * from board", new BoardRowMapper());
        return boards;
    }

    public void addBoard(final BoardDto board) {
        jdbcTemplate.update("insert into board(name,phone,email) values(?,?,?)",
                new Object[] {board.getName(),board.getPhone(),board.getEmail()});
    }

    public void updateBoard(final BoardDto board) {
        jdbcTemplate.update("update board set name = ?, phone = ?, email=? where id = ?",
                new Object[] { board.getName(), board.getPhone(),board.getEmail(), board.getId() });
    }



    public void deleteBoard(final int id) {
        jdbcTemplate.update("delete from board where id =?", new Object[] {id});
    }
}
