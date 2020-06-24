package jeju.ac.kr.post.Mapper;


import jeju.ac.kr.post.Domain.BoardDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BoardRowMapper implements RowMapper<BoardDto> {
    @Override
public BoardDto mapRow(ResultSet rs, int rowNum) throws SQLException {
    return new BoardDto(rs.getInt("id"),
            rs.getString("name"),
            rs.getString("phone"),
            rs.getString("email"));
}
}
