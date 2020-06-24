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

//data access object DB query db 작동 방
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public UserDto getUser(final int id) {
        UserDto user = jdbcTemplate.queryForObject("select * from user where id=?", new Object[] {id},
                new UserRowMapper());
        return user;
    }

    //mapper가 없는 이유는 사용하지 않고 디비에만 저장 하기 때문이다.
    public void addUser(final UserDto user) {
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
