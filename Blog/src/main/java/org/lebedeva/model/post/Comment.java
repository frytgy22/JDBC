package org.lebedeva.model.post;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.lebedeva.model.user.User;

@Data
@AllArgsConstructor
public class Comment {
    private User user;
    private String comment;
}
