package fr.uga.l3miage.tp3.exo1.components;


import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    public AlbumEntity getAlbum(String title) {
        return albumRepository.findById(title).orElseThrow();
    }

    public  AlbumEntity createAlbum(AlbumEntity albumEntity) {
        return albumRepository.save(albumEntity);
    }

    public AlbumEntity updateAlbum(String title, AlbumEntity albumEntity) {
        AlbumEntity albumEntity_ = albumRepository.findById(title).orElseThrow();
        albumEntity_.setArtistEntity(albumEntity.getArtistEntity());
        albumEntity_.setSongEntities(albumEntity.getSongEntities());
        albumEntity_.setReleaseDate(albumEntity.getReleaseDate());
        return albumRepository.save(albumEntity_);
    }

    public void deleteAlbum(String title) {
        albumRepository.deleteById(title);
    }
}
