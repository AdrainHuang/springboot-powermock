package adrain.study.springboot.springbootstudy.repository;

import adrain.study.springboot.springbootstudy.domain.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpDao  extends JpaRepository<Emp, Integer> {

}
