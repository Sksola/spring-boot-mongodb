package demo.springbootmongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import demo.springbootmongodb.entity.Customer;


public interface CustomerRepository extends MongoRepository<Customer, String> {
    
    public Optional<Customer> findByName(String name);
    
    public List<Customer> findByAge(int age);          
}
