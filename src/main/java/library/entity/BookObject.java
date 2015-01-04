package library.entity;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by trainee on 11.12.14.
 */
@Entity
@Table(name = "book")
public class BookObject extends  BaseObject implements Serializable{
    @Column(name = "name")
    private String name;

    @Column(name = "publish_day")
    private Integer publishDate;

    @Column(name = "style")
    private String style;

    @ManyToOne(targetEntity = AuthorObject.class,fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")

    private AuthorObject booksAuthor;

    public BookObject() {
    }
    public BookObject(Integer id, String name, String style, Integer publishDate, AuthorObject booksAuthor) {
        this.name = name;
        this.id = id;
        this.publishDate = publishDate;
        this.style = style;
        this.booksAuthor = booksAuthor;
    }

    public BookObject(Integer id, String name) {
        this(id, name, null, null, null);
    }

    public BookObject(Integer id, String name, String style, Integer publishDate) {
        this(id, name, style, publishDate, null);
    }

    public BookObject(String name, String style, Integer publishDate) {
        this(null, name, style, publishDate, null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Integer publishDate) {
        this.publishDate = publishDate;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public AuthorObject getbooksAuthor() {
        return booksAuthor;
    }

    public void setBooksAuthor(AuthorObject booksAuthor) {
        this.booksAuthor = booksAuthor;
    }

}


