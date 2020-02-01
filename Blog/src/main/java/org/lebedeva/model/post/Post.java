package org.lebedeva.model.post;

import lombok.Builder;
import lombok.Data;
import org.lebedeva.model.user.User;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class Post {
    private Integer id;
    private String title;
    private String subtitle;
    private User author;
    private Date publicationDate;
    private List<String> contents;
    private List<Comment> comments;
    private Category category;
}
