package pl.furmanj.oiw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.furmanj.oiw.model.Note;

import java.util.List;

//Komunikacja z poszczegolnymi modulami poprzez serwis
@Component
public class NoteService {
    private NoteRepo noteRepo;

    @Autowired
    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public void saveNote(Note note) {
        noteRepo.save(note);
    }

    public void saveNote(long id,Note note) {
        Note newNote =noteRepo.findAllById(id);
        newNote.setText(note.getText());
        newNote.setTitle(note.getTitle());
        newNote.setAuthor(note.getAuthor());
        newNote.setCategories(note.getCategories());
        noteRepo.save(newNote);
    }

    public List<Note> findAllNote() {
        List<Note> note = noteRepo.findAll();
        return note;
    }

    public Note findNoteByID(Long id) {
        Note note = noteRepo.findAllById(id);
        return note;
    }

    public void deleteNote(long id) {
        noteRepo.deleteById(id);
    }

    public List<Note> findByCategory(String name){
        return noteRepo.findAllByCategoriesContains(name);
    }
}

