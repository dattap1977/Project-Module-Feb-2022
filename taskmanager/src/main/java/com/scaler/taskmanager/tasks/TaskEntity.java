package com.scaler.taskmanager.tasks;

import com.scaler.taskmanager.notes.NoteEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity(name = "tasks")
public class TaskEntity {

    public TaskEntity(String name) {
        this.name = name;
        this.dueDate = LocalDate.now().plus(7, ChronoUnit.DAYS);
        this.status = false;
    }

    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Long id;

    @Column(nullable = false)
    String name;


    @Column
    LocalDate dueDate;

    @Column(columnDefinition = "boolean default false")
    Boolean status;

    @OneToMany
    List<NoteEntity> listNoteEntity;
}
