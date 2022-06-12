package demo.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springbootmongodb.dto.CustomerDto;
import demo.springbootmongodb.entity.Customer;
import demo.springbootmongodb.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(tags = "Customers 相關api")
@RestController
@RequestMapping(value="/api/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

	@ApiOperation(value = "查詢全部", notes = "查詢全部")
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<CustomerDto> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
	@ApiOperation(value = "依id查詢", notes = "依id查詢")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "客戶id", required = true)
    })
    @GetMapping(value="/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

	@ApiOperation(value = "依name查詢", notes = "依name查詢")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "用戶名稱", required = true)
    })
    @GetMapping(value="/name/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

	@ApiOperation(value = "新增一筆用戶資料", notes = "新增一筆用戶資料")
    @PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer customer) {
    	Customer newCustomer = customerService.createCustomer(customer);
        return newCustomer;
    }
    
    @ApiOperation(value = "依id刪除", notes = "依id刪除")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用戶id", required = true)
    })
    @DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomerById(@PathVariable String id) {
    	customerService.deleteCustomerById(id);
    }
}
