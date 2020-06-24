package jeju.ac.kr.post.Domain;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

//user값 가져오기 및 생성자 초기화
public class UserDto {

    private int id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public UserDto() {

    }

    public UserDto(int id, String name,  String phone, String email, String password) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.password = password;
    }
}
