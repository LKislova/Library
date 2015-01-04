package library.entity;

import javax.persistence.*;

/**
 * Created by trainee on 29.12.14.
 */
@MappedSuperclass
public abstract class BaseObject<T> {
    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer id;
    public BaseObject(){}
        public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }


}
