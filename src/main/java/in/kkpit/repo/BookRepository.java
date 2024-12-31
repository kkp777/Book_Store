package in.kkpit.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.kkpit.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

}
