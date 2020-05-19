package sw2.lab5.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sw2.lab5.Entity.post;

@Repository
public interface PostRepository extends JpaRepository<post,Integer> {
}
