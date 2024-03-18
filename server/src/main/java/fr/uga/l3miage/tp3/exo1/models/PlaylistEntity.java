package fr.uga.l3miage.tp3.exo1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PlaylistEntity {
    @Id
    private String name;

    private String description;

    private Duration totalDuration;

    @OneToMany
    private Set<SongEntity> songEntities;
}
