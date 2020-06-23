package jeju.ac.kr.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

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

    public void deleteBoard(final int id) {
        jdbcTemplate.update("delete from board where id =?", new Object[] {id});
    }
}
