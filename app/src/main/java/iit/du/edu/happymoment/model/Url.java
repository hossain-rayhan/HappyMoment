package iit.du.edu.happymoment.model;

/**
 * Created by Rayhan on 4/6/2015.
 */
public class Url {
    private String text;
    private String url;

    public Url(String text, String url) {
        this.text = text;
        this.url = url;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
