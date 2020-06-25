package jeju.ac.kr.post.Services;


import jeju.ac.kr.post.DaoFactory.UserDao;
import jeju.ac.kr.post.Domain.UserDto;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserDao userDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto getUser(final String email) {
        return userDao.getUser(email);
    }

    public UserDto setUser(String name,String phone, String email, String password) {
        password = passwordEncoder.encode(password);
        System.out.println("너뭐냐!!!!!!!!!!!!!!!!!!!!"+password);
        return userDao.setUser(name,phone,email,password);
    }

    public void addUser(final UserDto user) {
        userDao.addUser(user);
    }
}
