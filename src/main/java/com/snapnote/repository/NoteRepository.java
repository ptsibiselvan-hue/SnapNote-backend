package com.snapnote.repository;

import com.snapnote.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    // 🔥 Get notes only for a specific user
    List<Note> findByUser_Id(Long userId);

}
