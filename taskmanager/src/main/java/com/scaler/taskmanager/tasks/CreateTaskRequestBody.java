package com.scaler.taskmanager.tasks;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateTaskRequestBody {
    String name;
    LocalDate dueDate;
    Boolean status;
}
