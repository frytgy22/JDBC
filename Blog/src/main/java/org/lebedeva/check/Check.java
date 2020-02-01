package org.lebedeva.check;

import org.lebedeva.model.post.Category;

public class Check {
    public static boolean checkParameter(String data) {
        return data != null && data.trim().length() > 0;
    }

    public static Category getCategory(String req) {
        Category category = Category.TUTORIALS;

        if (Check.checkParameter(req)) {
            Category[] categories = Category.values();
            if (categories != null) {
                for (Category c : categories) {
                    if (c.toString().equals(req.trim().replaceAll(" ", "_"))) {
                        category = c;
                        break;
                    }
                }
            }
        }
        return category;
    }
}
