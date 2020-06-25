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

    public boolean matchPW(final String email, final String password) {
        UserDto user = userDao.getUser(email);

        System.out.println(user.getPassword());
        System.out.println(password);
        String bcryptPw = user.getPassword();

        //앞에가 받아온 비밀번호 뒤에가 인크립트 비밀번호
        boolean isPasswordMatch = passwordEncoder.matches(password,bcryptPw);
        System.out.println("++++++++++++++++++++++++++++++++++++"+isPasswordMatch);
        return isPasswordMatch;
    }

    public UserDto getUser(final String email) {
        UserDto user = userDao.getUser(email);
        return user;
    }

    public UserDto setUser(String name,String phone, String email, String password) {
        password = passwordEncoder.encode(password);
        return userDao.setUser(name,phone,email,password);
    }

    public void addUser(final UserDto user) {
        userDao.addUser(user);
    }
}
