package jeju.ac.kr.post.DaoFactory;


import jeju.ac.kr.post.Domain.UserDto;
import jeju.ac.kr.post.Mapper.UserRowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


//data access object DB query db 작동 방
@Transactional
@Component
public class UserDao {

    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public UserDto getUser(final String email) {

        UserDto user = null;
        try {
            user = jdbcTemplate.queryForObject("select * from user where email=?", new Object[] {email},
                    new UserRowMapper());
        } catch (DataAccessException e) {
            e.printStackTrace();
            System.out.println("*****************************");
            System.out.println("**************************"+e);
        }
        return user;
    }

    public UserDto setUser(String name, String phone, String email, String password) {
        UserDto user = new UserDto();
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        user.setPassword(password);

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
