package pl.wlodarczyk.notatnik.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pl.wlodarczyk.notatnik.Service.NoteService;
import pl.wlodarczyk.notatnik.model.Note;

import javax.validation.Valid;
import java.util.List;

@Controller
public class NoteController {
    private NoteService noteService;

    @Autowired
    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/shownotes")
    public String note(Model model) {
        List<Note> noteList = noteService.getNoteRepo().findAll();
        model.addAttribute("note", noteList);
        return "shownotes";
    }

    @GetMapping("/add")
    public String add(Note note, Model model) {
        return "addnote";
    }


    @PostMapping("/addnote")
    public String noteAdd(@Valid Note note, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addnote";
        }
        noteService.getNoteRepo().save(note);
        List<Note> noteList = noteService.getNoteRepo().findAll();
        model.addAttribute("note", noteList);
        return "shownotes";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") long id, Model model) {
        Note note = noteService.getNoteRepo().findById(id).get();
        if (note != null) model.addAttribute("note", note);
        return "updatenote";
    }

    @PostMapping("/update/{id}")
    public String updateNote(@PathVariable("id") long id, @Valid Note note, BindingResult result, Model model) {
        if (result.hasErrors()) {
            note.setId(id);
            return "updatenote";
        }
        noteService.getNoteRepo().save(note);
        List<Note> noteList = noteService.getNoteRepo().findAll();
        model.addAttribute("note", noteList);
        return "shownotes";
    }

    @GetMapping("/delete/{id}")
    public String deleteNote(@PathVariable("id") long id, Model model) {
        noteService.getNoteRepo().deleteById(id);
        List<Note> noteList = noteService.getNoteRepo().findAll();
        model.addAttribute("note", noteList);
        return "shownotes";
    }

}
