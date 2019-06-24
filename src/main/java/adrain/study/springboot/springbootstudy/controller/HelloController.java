package adrain.study.springboot.springbootstudy.controller;

import adrain.study.springboot.springbootstudy.domain.Emp;
import adrain.study.springboot.springbootstudy.domain.Person;
import adrain.study.springboot.springbootstudy.repository.IPersnDao;
import adrain.study.springboot.springbootstudy.service.impl.IEmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Adrain on 2018/7/8.
 */
@RestController
@Slf4j
public class HelloController {

	@GetMapping("/person/{id}")
	public Person person(@PathVariable Long id,@RequestParam(required = false)  String name){
		Person person = new Person();
		person.setId(id);
		person.setName(name);
		return person;
	}
	
	@Autowired
	private IEmpService empService;
	
	@Autowired
	private IPersnDao iPersnDao;
	
	@RequestMapping("/queryEmpAll")
	public List queryEmpAll() {
		List<Emp> empList=empService.queryEmpAll();
		for(Emp emp : empList) {
			System.out.println(emp.getEname());
		}
		return empList;
	}
	
	@PostMapping("/person")
	public Integer addPerson(Person person){
		List<String> l = new ArrayList();
		l.add("abc");
		l.add("bcd");
		log.error("l  size : {}",l.size());
		Person person1 = iPersnDao.save(person);
		int age = person1.getAge();
		return age;
	}
}
