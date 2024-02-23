package ru.ywojctb.sem6hw.store.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ywojctb.sem6hw.store.entities.Note;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

}
