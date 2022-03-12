package com.scaler.taskmanager.tasks;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
public class UpdateTaskRequestBody {
    String name;
    LocalDate dueDate;
    String status;
}
