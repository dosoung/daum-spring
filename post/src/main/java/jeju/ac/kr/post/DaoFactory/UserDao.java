package jeju.ac.kr.post.DaoFactory;


import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.Domain.UserDto;
import jeju.ac.kr.post.Mapper.BoardRowMapper;
import jeju.ac.kr.post.Mapper.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Component
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserDto getUser(final int id) {
        UserDto user = jdbcTemplate.queryForObject("select * from user where id=?", new Object[] {id},
                new UserRowMapper());
        return user;
    }

    public void insertUser(final UserDto user) {
        jdbcTemplate.update("insert into user(name,phone,email,password) value=(?,?,?,?) ",
        new Object[] {user.getName(),user.getEmail(),user.getPassword(),user.getPhone()});
    }

    public UserDto updateUser(final UserDto user) {
        jdbcTemplate.update("update user set name=?,password=?,phone=?,email=? where id=?",new Object[]
                {user.getName(),user.getPassword(),user.getPhone(),user.getPhone()});
        return user;
    }

    public void deleteUser(final int id) {
        jdbcTemplate.update("delete from user where id=?",new Object[] {id});
    }

}
