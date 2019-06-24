package adrain.study.springboot.springbootstudy.service.impl;

import adrain.study.springboot.springbootstudy.repository.IEmpDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Adrain
 * @Date 2019/6/22 22:49
 **/
@Slf4j
@Service
public class EmpServiceImpl implements IEmpService {
	
	@Autowired
	private IEmpDao empDao;
	
	@Override
	public List queryEmpAll() {
		log.info("method :{}","queryEmpAll");
		return empDao.findAll();
	}

}
