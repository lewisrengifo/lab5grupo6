package sw2.lab5.Entity;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Post {
    @Id
    private int id_post;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Usuario author_id;
    private String tittle;
    private String summary;
    private boolean published;
    private String content;

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public Usuario getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(Usuario author_id) {
        this.author_id = author_id;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
