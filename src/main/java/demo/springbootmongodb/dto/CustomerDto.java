package demo.springbootmongodb.dto;

import io.swagger.annotations.ApiModelProperty;

public class CustomerDto {
	
	@ApiModelProperty(value = "姓名", required = true)
	public String id;
	@ApiModelProperty(value = "姓名", required = true)
	public String name;
	@ApiModelProperty(value = "年齡", required = true)
	public int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
