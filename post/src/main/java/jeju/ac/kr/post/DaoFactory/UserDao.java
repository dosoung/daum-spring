package jeju.ac.kr.post.DaoFactory;


import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.Domain.UserDto;
import jeju.ac.kr.post.Mapper.BoardRowMapper;
import jeju.ac.kr.post.Mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.attribute.UserDefinedFileAttributeView;


//data access object DB query db 작동 방
@Transactional
@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public UserDto getUser(final String email) {
        UserDto user = jdbcTemplate.queryForObject("select * from user where email=?", new Object[] {email},
                new UserRowMapper());
        return user;
    }

    public void addUser(final UserDto user) {
        jdbcTemplate.update("insert into user(name,phone,email,password) values(?,?,?,?)",
                new Object[] {user.getName(),user.getPhone(),user.getEmail(),user.getPassword()});
    }

    public UserDto updateUser(final UserDto user) {
        jdbcTemplate.update("update user set name=?,password=?,phone=?,email=? where id=?",new Object[]
                {user.getName(),user.getPassword(),user.getPhone(),user.getEmail()});
        return user;
    }

    public void deleteUser(final int id) {
        jdbcTemplate.update("delete from user where id=?",new Object[] {id});
    }

}
