package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getSong(String name) {
        return playlistRepository.findById(name).orElseThrow();
    }

    public  PlaylistEntity createSong(PlaylistEntity playlistEntity) {
        return playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity updateSong(String name, PlaylistEntity playlistEntity) {
        PlaylistEntity playlistEntity_ = playlistRepository.findById(name).orElseThrow();
        playlistEntity_.setName(name);
        playlistEntity_.setSongEntities(playlistEntity.getSongEntities());
        playlistEntity_.setDescription(playlistEntity.getDescription());
        playlistEntity_.setTotalDuration(playlistEntity.getTotalDuration());
        return playlistRepository.save(playlistEntity_);
    }

    public void deleteSong(String title) {
        playlistRepository.deleteById(title);
    }
}
