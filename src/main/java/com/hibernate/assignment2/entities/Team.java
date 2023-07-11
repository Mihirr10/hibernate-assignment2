package com.hibernate.assignment2.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "team")
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE, region = "player")
public class Team {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int teamId;
  private String teamName;

  @OneToMany(mappedBy = "team",cascade = CascadeType.ALL)
  private List<Player> players;
}
