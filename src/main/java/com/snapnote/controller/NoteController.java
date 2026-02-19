package com.snapnote.controller;

import com.snapnote.entity.Note;
import com.snapnote.entity.User;
import com.snapnote.repository.NoteRepository;
import com.snapnote.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class NoteController {

    private final NoteRepository noteRepository;
    private final UserRepository userRepository;

    // =========================================
    // GET NOTES FOR SPECIFIC USER
    // =========================================
    @GetMapping("/user/{userId}")
    public List<Note> getUserNotes(@PathVariable Long userId) {
        return noteRepository.findByUser_Id(userId);
    }

    // =========================================
    // CREATE NOTE FOR SPECIFIC USER
    // =========================================
    @PostMapping("/user/{userId}")
    public Note createNote(@PathVariable Long userId,
                           @RequestBody Note note) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        note.setUser(user);

        return noteRepository.save(note);
    }

    // =========================================
    // DELETE NOTE
    // =========================================
    @DeleteMapping("/{id}")
    public void deleteNote(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }
}
