package jeju.ac.kr.post;


import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<Board> {
    @Override
    public Board mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Board(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("phone"),
                rs.getString("email"));
    }
}
