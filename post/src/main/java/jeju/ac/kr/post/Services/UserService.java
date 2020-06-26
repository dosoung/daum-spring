package jeju.ac.kr.post.Services;


import com.mysql.cj.x.protobuf.Mysqlx;
import jeju.ac.kr.post.DaoFactory.UserDao;
import jeju.ac.kr.post.Domain.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }


    @Transactional
    public UserDto getUser(final String email) {
        UserDto user = userDao.getUser(email);
        return user;
    }

    @Transactional
    public UserDto setUser(String name,String phone, String email, String password) {

        password = passwordEncoder.encode(password);
        return userDao.setUser(name,phone,email,password);
    }

    @Transactional
    public void addUser(final UserDto user) {
        userDao.addUser(user);
    }

    @Transactional
    public boolean matchPW(final String email, final String password) {
        UserDto user = userDao.getUser(email);

        String encodedPw = user.getPassword();

//        앞에가 받아온 비밀번호 뒤에가 인크립트 비밀번호

//        예제
//        String result = encoder.encode("myPassword");
//        assertTrue(encoder.matches("myPassword", result));
        boolean isPasswordMatch = passwordEncoder.matches(password,encodedPw);
        return isPasswordMatch;
    }
}
