package library.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by trainee on 11.12.14.
 */
@Entity
@Table(name = "AUTHOR")
public class AuthorObject {
    @Column(name = "id")
    @Id
    @GeneratedValue
    private Integer id;
    @Column(name = "full_name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "biography")
    private String biography;

    //    @OneToMany(mappedBy = "author")
    @OneToMany(targetEntity = BookObject.class)
    @JoinColumn(name = "author_id")
//    @JoinTable(name = "book",
//            joinColumns = @JoinColumn(name = "id"),
//            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<BookObject> booksAuthorList = new HashSet<BookObject>();

    public AuthorObject(Integer id, String name, Date birthday, String biography) {
        this.name = name;
        this.id = id;
        this.birthday = birthday;
        this.biography = biography;
    }

    public AuthorObject(String name, Date birthday, String biography) {

        this(null, name, birthday, biography);
    }

    public AuthorObject(Integer id, String name) {

        this(id, name, null, null);
    }

    public AuthorObject() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Set<BookObject> getBooksAuthorList() {
        return booksAuthorList;
    }

    public void setBooksAuthorList(Set<BookObject> booksAuthorList) {
        this.booksAuthorList = booksAuthorList;
    }
}



