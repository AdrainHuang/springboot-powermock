package adrain.study.springboot.springbootstudy;

import adrain.study.springboot.springbootstudy.controller.HelloController;
import adrain.study.springboot.springbootstudy.domain.Person;
import adrain.study.springboot.springbootstudy.repository.IPersnDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PowerMockIgnore;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @Author AdrainHuang
 * @Date 2019/6/23 18:16
 **/
@SpringBootTest  // 表明这是一个springboot测试类，会自动加载springboot主启动程序
@RunWith(PowerMockRunner.class) //使用powermock自己的Runner
@PowerMockRunnerDelegate(SpringRunner.class) //将powermock整合到spring容器中
@PowerMockIgnore({"javax.*.*", "com.sun.*", "org.xml.*", "org.apache.*"})
@PrepareForTest({HelloController.class,Person.class})
public class HelloControllerTest2 {
	
	@InjectMocks
	private HelloController helloController;
	
	
	@Mock
	private IPersnDao iPersnDao;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(this.helloController).build();  //构造MockMvc
	}
	
	@Test
	public void testAddPerson() throws Exception {
		Person person = PowerMockito.mock(Person.class);
		person.setAge(121);
		person.setName("321");
		given(iPersnDao.save(any(Person.class)))
		.willReturn(person)
		;
		
		PowerMockito.whenNew(Person.class).withAnyArguments().thenReturn(person);;
		PowerMockito.when(person.getAge()).thenReturn(20);
		Assert.assertEquals("20",this.mockMvc.perform(
		post("/person")
		.param("name", "Tom")
		.param("age", "12")
		).andExpect(status().isOk())
		.andReturn().getResponse().getContentAsString());
		verify(iPersnDao).save(any(Person.class));
		
	}
}
