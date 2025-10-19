package com.substring.helpdesk.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "help_desk_tickets")
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Ticket implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String summary;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private  String category;

    @Column(length = 1000)
    private  String description;

    @Column(unique = true)
    private String email;

    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

    @Enumerated(EnumType.STRING)
    private Status status;

    @PrePersist
    void preSave(){
        if(this.createdOn == null){
            this.createdOn = LocalDateTime.now();
        }
        this.updatedOn = LocalDateTime.now();
    }

    @PreUpdate
    void preUpdate(){
        this.updatedOn = LocalDateTime.now();
    }

}
