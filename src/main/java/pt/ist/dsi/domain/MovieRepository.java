package pt.ist.dsi.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Sérgio Silva (hello@fenixedu.org).
 */
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
