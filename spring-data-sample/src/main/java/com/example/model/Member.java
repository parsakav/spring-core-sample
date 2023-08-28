package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Table
@Entity
@Setter
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@Getter
public class Member {
    @Id
    @GeneratedValue
    private long id;
    @NonNull
    private String name;
}
