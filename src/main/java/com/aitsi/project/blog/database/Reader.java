package com.aitsi.project.blog.database;

import com.aitsi.project.blog.dao.Author;
import com.aitsi.project.blog.dao.Headline;
import com.aitsi.project.blog.dao.Post;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Repository;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Reader {

    private JSONObject jsonObject;

    public Reader() {
        JSONParser parser = new JSONParser();
        try {
            URL url = getClass().getResource("/database/db.json");
            Object obj = parser.parse(new FileReader(url.getFile()));
            jsonObject = (JSONObject) obj;
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
    }

    public List<Author> retrieveAuthors() {
        JSONArray authors = (JSONArray) jsonObject.get("authors");
        List<Author> authorsList = new ArrayList<>();
        for (Object author : authors) {
            Author a = mapJsonToAuthorObject((JSONObject) author);
            authorsList.add(a);
        }
        return authorsList;
    }

    private Author mapJsonToAuthorObject(JSONObject author) {
        return new Author(author.get("id").toString(),
                            author.get("firstName").toString(),
                            author.get("lastName").toString(),
                            author.get("description").toString());
    }

    public List<Post> retrievePosts() {
        JSONArray posts = (JSONArray) jsonObject.get("posts");
        List<Post> postsList = new ArrayList<>();
        for (Object post : posts) {
            Post p = mapJsonToPostObject((JSONObject) post);
            postsList.add(p);
        }
        return postsList;
    }

    private Post mapJsonToPostObject(JSONObject post) {
        return new Post(post.get("id").toString(),
                        post.get("title").toString(),
                        post.get("postText").toString());
    }

    public List<Headline> retrieveHeadlines() {
        JSONArray headlines = (JSONArray) jsonObject.get("headlines");
        List<Headline> headlineList = new ArrayList<>();
        for (Object headline : headlines) {
            Headline h = mapJsonToHeadlineObject((JSONObject) headline);
            headlineList.add(h);
        }
        return headlineList;
    }

    private Headline mapJsonToHeadlineObject(JSONObject headline) {
        return new Headline(headline.get("id").toString(),
                            headline.get("title").toString(),
                            headline.get("text").toString());
    }

}
