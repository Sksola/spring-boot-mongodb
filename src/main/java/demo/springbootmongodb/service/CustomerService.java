package demo.springbootmongodb.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import demo.springbootmongodb.dto.CustomerDto;
import demo.springbootmongodb.entity.Customer;
import demo.springbootmongodb.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
    private CustomerRepository customerRepo;
	
	/**
     * 查詢全部
     */
    public List<CustomerDto> getAllCustomers() {
    	List<CustomerDto> result = new ArrayList<CustomerDto>();
    	List<Customer> customerList = customerRepo.findAll();
    	customerList.forEach(customer->{
    		CustomerDto customerDto = new CustomerDto();
    		customerDto.setId(customer.getId());
    		customerDto.setName(customer.getName());
    		customerDto.setAge(customer.getAge());
    		result.add(customerDto);
    	});
        return result;
    }
    
    /**
     * 依id查詢
     */
    public Customer getCustomerById(@PathVariable String id) {
        return customerRepo.findById(id).orElse(null);
    }

    /**
     * 依名稱name查詢
     */
    public Customer getCustomerByName(@PathVariable String name) {
        return customerRepo.findByName(name).orElse(null);
    }

    /**
     * 新增一筆資料
     */
    public Customer createCustomer(@RequestBody Customer customer) {
    	Customer newCustomer = customerRepo.save(customer);
        return newCustomer;
    }
    
    /**
     * 依ID刪除資料
     */
    public void deleteCustomerById(@PathVariable String id) {
    	customerRepo.deleteById(id);
    }
}
