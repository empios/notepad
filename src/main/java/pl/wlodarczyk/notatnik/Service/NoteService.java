package pl.wlodarczyk.notatnik.Service;

import org.springframework.stereotype.Service;
import pl.wlodarczyk.notatnik.repo.NoteRepo;

@Service
public class NoteService {

    private NoteRepo noteRepo;

    public NoteService(NoteRepo noteRepo) {
        this.noteRepo = noteRepo;
    }

    public NoteRepo getNoteRepo() {
        return noteRepo;
    }
}