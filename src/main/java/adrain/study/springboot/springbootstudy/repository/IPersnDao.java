package adrain.study.springboot.springbootstudy.repository;

import adrain.study.springboot.springbootstudy.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPersnDao extends JpaRepository<Person, Long> {
}
