package jeju.ac.kr.post.Domain;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public UserDto() {

    }

    public UserDto(int id, String name, String email, String phone, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
