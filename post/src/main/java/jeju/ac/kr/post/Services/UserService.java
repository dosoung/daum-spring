package jeju.ac.kr.post.Services;


import jeju.ac.kr.post.DaoFactory.BoardDao;
import jeju.ac.kr.post.DaoFactory.UserDao;
import jeju.ac.kr.post.Domain.BoardDto;
import jeju.ac.kr.post.Domain.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public UserDto getUser(final int id ) {
        return userDao.getUser(id);
    }

    public void addUser(final UserDto user) {
        userDao.addUser(user);
    }
}
