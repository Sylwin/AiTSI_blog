package com.aitsi.project.blog.util;


import com.aitsi.project.blog.domain.Blog;

import java.util.Comparator;

public class BlogComparator  implements Comparator<Blog> {
    @Override
    public int compare(Blog blog1, Blog blog2) {
        return blog1.getSubtitle().compareTo(blog2.getSubtitle());
    }
}
