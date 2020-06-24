package jeju.ac.kr.post.Mapper;

import jeju.ac.kr.post.Domain.UserDto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new UserDto(rs.getInt("id"),
                rs.getString("name"),
                rs.getString("password"),
                rs.getString("phone"),
                rs.getString("email"));
    }
}

