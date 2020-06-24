package jeju.ac.kr.post.Services;


import jeju.ac.kr.post.DaoFactory.UserDao;
import jeju.ac.kr.post.Domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDto getUser(final String email) {
        return userDao.getUser(email);
    }

    public void addUser(final UserDto user) {
        userDao.addUser(user);
    }
}
