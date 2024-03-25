package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity getSong(String title) {
        return songRepository.findById(title).orElseThrow();
    }

    public SongEntity getSongBetweenDurationInterval(Duration d1, Duration d2) {
        return songRepository.findByDurationBetween(d1, d2);
    }

    public  SongEntity createSong(SongEntity songEntity) {
        return songRepository.save(songEntity);
    }

    public SongEntity getSongEntity (Duration duration1, Duration duration2){
        return songRepository.findByDurationBetween(duration1, duration2);
    }

    public SongEntity updateSong(String title, SongEntity songEntity) {
        SongEntity songEntity_ = songRepository.findById(title).orElseThrow();

        songEntity_.setAlbumEntity(songEntity.getAlbumEntity());
        songEntity_.setArtistEntity(songEntity.getArtistEntity());
        songEntity_.setDuration(songEntity.getDuration());
        songEntity_.setTitle(title);
        return songRepository.save(songEntity_);
    }

    public void deleteSong(String title) {
        songRepository.deleteById(title);
    }
}
