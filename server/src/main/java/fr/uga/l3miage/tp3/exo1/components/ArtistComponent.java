package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    public ArtistEntity getArtist(String name) {
        return artistRepository.findById(name).orElseThrow();
    }

    public int getCountArtistsByGenreMusical(GenreMusical genreMusical){
        return artistRepository.countAllByGenreMusical(genreMusical);
    }

    public  ArtistEntity createArtist(ArtistEntity artistEntity) {
        return artistRepository.save(artistEntity);
    }

    public ArtistEntity updateArtist(String name, ArtistEntity artistEntity) {
        ArtistEntity artistEntity_ = artistRepository.findById(name).orElseThrow();
        artistEntity_.setAlbumEntities(artistEntity.getAlbumEntities());
        artistEntity_.setBiography(artistEntity.getBiography());
        artistEntity_.setGenreMusical(artistEntity.getGenreMusical());
        return artistRepository.save(artistEntity_);
    }

    public void deleteArtist(String title) {
        artistRepository.deleteById(title);
    }
}
