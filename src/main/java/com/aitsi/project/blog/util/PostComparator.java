package com.aitsi.project.blog.util;

import com.aitsi.project.blog.domain.Post;

import java.util.Comparator;

public class PostComparator implements Comparator<Post> {
    @Override
    public int compare(Post post1, Post post2) {
        return post1.getTitle().compareTo(post2.getTitle());
    }
}
