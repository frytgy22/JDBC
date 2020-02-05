package org.lebedeva.model.user;

import lombok.*;

@Data
@Builder
public class User {
    private Integer id;
    @NonNull
    private String login;
    @NonNull
    private String password;
}
