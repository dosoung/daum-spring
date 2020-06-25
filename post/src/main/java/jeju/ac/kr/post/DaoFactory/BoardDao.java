package jeju.ac.kr.post.DaoFactory;

import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.Mapper.BoardRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



//data accesss object
@Transactional
@Component
public class BoardDao {

    private final JdbcTemplate jdbcTemplate;

    public BoardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //BoardDto타입으로 함수를 반환한다.
    //쿼리문을 실행하고 new object를 생성 하는데 여기까지가 우리가 기억하는 resultSet이다.
    // 이 resultSet은 아직 의미가 없는 객체이다. 어떻게 사용할지에 대해서 우리가 의미를 부여하는데
    //그것이 BoardRowMapper를 통해서 의미를 부여하는 것이다.
    public BoardDto getBoard(final int id) {
        BoardDto board = jdbcTemplate.queryForObject("select * from board where id=?", new Object[] {id},
                new BoardRowMapper());
        return board;
    }

    public List<BoardDto> getBoards() {
        List<BoardDto> boards = jdbcTemplate.query("select * from board", new BoardRowMapper());
        return boards;
    }




    public void updateBoard(final BoardDto board) {
        jdbcTemplate.update("update board set name = ?, phone = ?, email=? where id = ?",
                new Object[] { board.getName(), board.getPhone(),board.getEmail(), board.getId() });
    }



    public BoardDto setBoard(String name, String phone, String email) {
        BoardDto board = new BoardDto();
        board.setName(name);
        board.setEmail(email);
        board.setPhone(phone);
        return board;
    }

    public void addBoard(final BoardDto board) {
        jdbcTemplate.update("insert into board(name,phone,email) values(?,?,?)",
                new Object[] {board.getName(),board.getPhone(),board.getEmail()});
    }




    public void deleteBoard(final int id) {
        jdbcTemplate.update("delete from board where id =?", new Object[] {id});
    }
}
