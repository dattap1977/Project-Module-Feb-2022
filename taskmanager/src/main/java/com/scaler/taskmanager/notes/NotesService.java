package com.scaler.taskmanager.notes;

import com.scaler.taskmanager.tasks.TaskEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class NotesService {
    @Autowired
    private NotesRepository notesRepository;

    private EntityManager em;

    public List<NoteEntity> getAllNotes() {
        return notesRepository.findAll();
    }

    public List<NoteEntity> findByTask(TaskEntity taskEntity) {
        List<NoteEntity> listNoteEntity = taskEntity.getListNoteEntity();
        return listNoteEntity;
    }
}
