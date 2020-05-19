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
    private 
}
