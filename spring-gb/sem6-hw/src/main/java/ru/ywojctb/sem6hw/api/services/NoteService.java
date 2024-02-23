package ru.ywojctb.sem6hw.api.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.aspectj.weaver.ast.Not;
import org.springframework.stereotype.Service;
import ru.ywojctb.sem6hw.api.exceptions.BadRequestException;
import ru.ywojctb.sem6hw.store.entities.Note;
import ru.ywojctb.sem6hw.store.repositories.NoteRepository;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional
public class NoteService {

    private final NoteRepository noteRepository;

    public Note getNoteById(Long id) {
        return getNoteOrThrowException(id);
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    public Note createNote(Note note) {
        Note noteToSave = new Note();
        noteToSave.setTitle(note.getTitle());
        noteToSave.setDescription(note.getDescription());
        noteRepository.saveAndFlush(noteToSave);
        return noteToSave;
    }

    public Note updateNote(Long id, Note note) {
        Note noteFromDb = getNoteOrThrowException(id);

        noteFromDb.setTitle(note.getTitle());
        noteFromDb.setDescription(note.getDescription());

        return noteRepository.saveAndFlush(noteFromDb);
    }

    public void deleteNote(Long id) {
        noteRepository.deleteById(id);
    }

    private Note getNoteOrThrowException(Long id) {
        return noteRepository
                .findById(id)
                .orElseThrow(() -> new BadRequestException("Bad id"));
    }

}
