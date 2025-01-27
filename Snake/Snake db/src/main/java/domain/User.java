package domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private int id;
    private String login;
    private String password;
    private int coins;
    private String date;
}
