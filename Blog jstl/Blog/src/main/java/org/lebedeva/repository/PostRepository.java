package org.lebedeva.repository;

import org.lebedeva.model.post.Category;
import org.lebedeva.model.post.Comment;
import org.lebedeva.model.post.Post;
import org.lebedeva.model.user.User;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class PostRepository {
    private List<Post> posts;
    private AtomicInteger id;

    private static volatile PostRepository instance;

    private PostRepository() {
        posts = new CopyOnWriteArrayList<>();
        id = new AtomicInteger(-1);
        init();
    }

    public static PostRepository getInstance() {
        PostRepository localInstance = instance;
        if (localInstance == null) {
            synchronized (PostRepository.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new PostRepository();
                }
            }
        }
        return localInstance;
    }

    public void save(Post post) {
        posts.add(post);
    }

    public void remove(Post post) {
        posts.remove(post);
    }

    public List<Post> getPosts() {
        return posts;
    }

    public int setId() {
        return id.incrementAndGet();

    }

    private void init() {
        User blogger = User.builder().login("blogger").password("123").build();

        List<Comment> comments = new ArrayList<Comment>();
        comments.add(new Comment(blogger, "cool!"));
        comments.add(new Comment(blogger, "Good blog."));
        comments.add(new Comment(blogger, "this nice)"));

        List<String> contents = new ArrayList<String>();
        contents.add("JavaScript is a prototype-based, multi-paradigm, single-threaded, dynamic language, supporting object-oriented, imperative, and declarative (e.g. functional programming) styles. Read more about JavaScript.");
        contents.add("This section is dedicated to the JavaScript language itself, and not the parts that are specific to Web pages or other host environments. For information about APIs specific to Web pages, please see Web APIs and DOM.");
        contents.add("The standard for JavaScript is ECMAScript. As of 2012, all modern browsers fully support ECMAScript 5.1. Older browsers support at least ECMAScript 3. On June 17, 2015, ECMA International published the sixth major version of ECMAScript, which is officially called ECMAScript 2015, and was initially referred to as ECMAScript 6 or ES6.");
        contents.add("Since then, ECMAScript standards are on yearly release cycles. This documentation refers to the latest draft version, which is currently ECMAScript 2020.");
        contents.add("Do not confuse JavaScript with the Java programming language. Both \"Java\" and \"JavaScript\" are trademarks or registered trademarks of Oracle in the U.S. and other countries. However, the two programming languages have very different syntax, semantics, and uses.");

        posts.add(Post.builder()
                .id(setId())
                .title("About JS")
                .subtitle("JavaScript (JS) is a lightweight, interpreted, or just-in-time compiled programming language with first-class functions. While it is most well-known as the scripting language for Web pages, many non-browser environments also use it, such as Node.js, Apache CouchDB and Adobe Acrobat. ")
                .author(blogger)
                .contents(contents)
                .comments(comments)
                .category(Category.JAVA_SCRIPT)
                .publicationDate(new Date()).build());
    }
}

