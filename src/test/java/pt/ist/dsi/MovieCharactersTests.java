package pt.ist.dsi;

import pt.ist.dsi.domain.Actor;
import pt.ist.dsi.domain.ActorRepository;
import pt.ist.dsi.domain.Character;
import pt.ist.dsi.domain.CharacterRepository;
import pt.ist.dsi.domain.Movie;
import pt.ist.dsi.domain.MovieRepository;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class MovieCharactersTests {
    
    private Logger logger = LoggerFactory.getLogger(MovieCharactersTests.class);
    
    @Autowired
    private MovieRepository movieRepository;
    
    @Autowired
    private ActorRepository actorRepository;
    
    @Autowired
    private CharacterRepository characterRepository;
    
    @Test
    public void testIfOrphanCharactersAreRemovedFromTheDatabase() {
        Movie movie = movieRepository.save(new Movie("Batman"));
        
        Stream.of("John", "Peter", "Mae").map(Actor::new).map(actor -> {
            actor = actorRepository.save(actor);
            Character character = new Character();
            character.setActor(actor);
            character.setRole("Himself");
            character.setMovie(movie);
            movie.getCharacters().add(character);
            return characterRepository.save(character);
        }).collect(Collectors.toList());
        
        Movie fresh = movieRepository.findOne(movie.getId());
        logger.debug("print movie {} characters", fresh.toString());
        fresh.getCharacters().stream().map(Character::toString).forEach(logger::debug);
        logger.debug("end print movie {} characters", fresh.toString());
        
        //fresh.getCharacters().forEach(c -> characterRepository.delete(c));
        fresh.getCharacters().clear();
        
        logger.debug("print movie {} characters", fresh.toString());
        fresh.getCharacters().stream().map(Character::toString).forEach(logger::debug);
        logger.debug("end print movie {} characters", fresh.toString());
        
        movieRepository.saveAndFlush(fresh);
        Assert.assertEquals(0, characterRepository.count());
    }
}
