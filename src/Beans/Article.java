package Beans;

public class Article {

    private String title;
    private StringBuilder story;
    private int id;
    
    public Article(int id,String title,StringBuilder story) {
        this.title = title;
        this.story = story;
        this.id = id;
    }
    
    public Article(int id,String title,String content) {
        this(id,title,new StringBuilder(content));
    }
    
    public Article(String title,String content) {
        this.title = title;
        this.story = new StringBuilder(content);
    }

    public String getTitle() {
        return title;
    }

    public StringBuilder getStory() {
        return story;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setStory(StringBuilder content) {
        this.story = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return "Title: " + getTitle() + " Id : " + getId();
    }
}
