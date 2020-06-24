package jeju.ac.kr.post.Domain;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
//board 값 가져오기 및 생성자로 초기
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
