package pt.ist.dsi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Entity
public class Character {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String role;
    
    @ManyToOne
    private Movie movie;
    
    @ManyToOne
    private Actor actor;
    
    @Override
    public String toString() {
        return "Character{" + "id=" + id + ", role='" + role + '\'' + ", movie=" + movie + ", actor=" + actor + '}';
    }
    
    public Character(String role, Movie movie, Actor actor) {
        this.role = role;
        this.movie = movie;
        this.actor = actor;
    }
    
    public Character() {
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getRole() {
        return role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public Movie getMovie() {
        return movie;
    }
    
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
    
    public Actor getActor() {
        return actor;
    }
    
    public void setActor(Actor actor) {
        this.actor = actor;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        
        Character that = (Character) o;
        
        if (id != null ? !id.equals(that.id) : that.id != null)
            return false;
        if (role != null ? !role.equals(that.role) : that.role != null)
            return false;
        if (movie != null ? !movie.equals(that.movie) : that.movie != null)
            return false;
        return actor != null ? actor.equals(that.actor) : that.actor == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (movie != null ? movie.hashCode() : 0);
        result = 31 * result + (actor != null ? actor.hashCode() : 0);
        return result;
    }
}