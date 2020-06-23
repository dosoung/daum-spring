package jeju.ac.kr.post;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Board {

    private int id;
    private String name;
    private String phone;
    private String email;

    public Board() {

    }


    public Board(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;

    }
}
