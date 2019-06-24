package adrain.study.springboot.springbootstudy;

import adrain.study.springboot.springbootstudy.controller.HelloController;
import adrain.study.springboot.springbootstudy.domain.Person;
import adrain.study.springboot.springbootstudy.repository.IPersnDao;
import adrain.study.springboot.springbootstudy.service.impl.IEmpService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author AdrainHuang
 * @Date 2019/6/22 23:41
 **/
@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private IPersnDao iPersnDao;
	
	@MockBean
	private IEmpService iEmpService;
	
	@Test
	public void testAddPerson() throws Exception {
		Person person1 = new Person();
		person1.setAge(121);
		person1.setName("321");
		List l = Mockito.mock(List.class);
		given(l.size()).willReturn(33);
		given(iPersnDao.save(any(Person.class)))
		.willReturn(person1)
		;
		Person person = mock(Person.class);
		System.out.println(this.mockMvc.perform(
		post("/person")
		.param("name", "Tom")
		.param("age", "12")
		).andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString());
		verify(iPersnDao).save(any(Person.class));
	}
}
