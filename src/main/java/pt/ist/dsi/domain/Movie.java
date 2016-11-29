package pt.ist.dsi.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
@Entity
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String title;
    
    @OneToMany(mappedBy = "movie", fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Character> characters;
    
    protected Movie() {
        
    }
    
    public Movie(String title) {
        this.title = title;
        this.characters = new HashSet<>();
    }
    
    public Set<Character> getCharacters() {
        return characters;
    }
    
    @Override
    public String toString() {
        return "Movie{" + "id=" + id + ", title='" + title + '\'' + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        
        Movie movie = (Movie) o;
        
        if (id != null ? !id.equals(movie.id) : movie.id != null)
            return false;
        return title != null ? title.equals(movie.title) : movie.title == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
}
