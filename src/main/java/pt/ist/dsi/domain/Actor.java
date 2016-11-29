package pt.ist.dsi.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */

@Entity
public class Actor {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column
    private String name;
    
    protected Actor() {
        
    }
    
    public Actor(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Long getId() {
        
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        
        Actor actor = (Actor) o;
        
        if (id != null ? !id.equals(actor.id) : actor.id != null)
            return false;
        return name != null ? name.equals(actor.name) : actor.name == null;
    }
    
    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
    
    @Override
    public String toString() {
        return "Actor{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}
