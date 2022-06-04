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

import demo.springbootmongodb.entity.Customer;
import demo.springbootmongodb.service.CustomerService;

@RestController
@RequestMapping(value="/api/customers")
public class CustomerController {
	
	@Autowired
    private CustomerService customerService;

	/**
     * 查詢全部
     */
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }
    
    /**
     * 依id查詢
     */
    @GetMapping(value="/id/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    /**
     * 依名稱name查詢
     */
    @GetMapping(value="/name/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer getCustomerByName(@PathVariable String name) {
        return customerService.getCustomerByName(name);
    }

    /**
     * 新增一筆資料
     */
    @PostMapping(value="/add", produces=MediaType.APPLICATION_JSON_VALUE)
    public Customer createCustomer(@RequestBody Customer customer) {
    	Customer newCustomer = customerService.createCustomer(customer);
        return newCustomer;
    }
    
    /**
     * 依ID刪除資料
     */
    @DeleteMapping(value="/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
    public void deleteCustomerById(@PathVariable String id) {
    	customerService.deleteCustomerById(id);
    }
}
