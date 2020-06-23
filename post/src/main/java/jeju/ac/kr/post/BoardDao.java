package jeju.ac.kr.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



//data accesss object
@Transactional
@Component
public class BoardDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Board getBoard(final int id) {
        Board board = jdbcTemplate.queryForObject("select * from board where id=?", new Object[] {id},
                new BoardRowMapper());
        return board;
    }

    public List<Board> getBoards() {
        List<Board> boards = jdbcTemplate.query("select from board", new BoardRowMapper());
        return boards;
    }

    public void addBoard(final Board board) {
        jdbcTemplate.update("insert into board(name,phone,email) values(?,?,?)",
                new Object[] {board.getName(),board.getPhone(),board.getEmail()});
    }

    public void updateBoard(final Board board) {
        jdbcTemplate.update("update board set name = ?, phone = ?, email=? where id = ?",
                new Object[] { board.getName(), board.getPhone(),board.getEmail(), board.getId() });
    }



    public void deleteBoard(final int id) {
        jdbcTemplate.update("delete from board where id =?", new Object[] {id});
    }
}
