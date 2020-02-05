package org.lebedeva.check;

import org.lebedeva.model.post.Category;

import java.util.Arrays;

public class Check {
    public static boolean checkParameter(String data) {
        return data != null && data.trim().length() > 0;
    }

    public static Category getCategory(String req) {

        if (Check.checkParameter(req)) {
            return Arrays.stream(Category.values())
                    .filter(c -> c != null && c.toString().equals(req.trim().replaceAll(" ", "_")))
                    .findFirst().orElse(Category.TUTORIALS);
        }
        return Category.TUTORIALS;
    }
}
