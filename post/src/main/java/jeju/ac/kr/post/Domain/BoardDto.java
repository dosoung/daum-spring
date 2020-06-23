package jeju.ac.kr.post.Domain;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardDto {

    private int id;
    private String name;
    private String phone;
    private String email;

    public BoardDto() {

    }


    public BoardDto(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;

    }
}
