package adrain.study.springboot.springbootstudy.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * @Author Adrain
 * @Date 2019/6/22 22:45
 **/

@Entity
@Table(name="emp2")
@Data
public class Emp {
	@Id
	@GeneratedValue
	private int eid;
	private String ename;
	private String sex;
	private Date hire;
	private float sar;
	private int did;
}
