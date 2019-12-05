package pl.wlodarczyk.notatnik.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.wlodarczyk.notatnik.model.Note;

@Repository
public interface NoteRepo extends JpaRepository<Note, Long> {


}
