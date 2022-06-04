package demo.springbootmongodb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.springbootmongodb.entity.GroceryItem;
import demo.springbootmongodb.repository.ItemRepository;

@Service
public class ItemService {

	@Autowired
	ItemRepository groceryItemRepo;
	
	public void createGroceryItems() {
        System.out.println("Data creation started...");
        groceryItemRepo.save(new GroceryItem("Whole Wheat Biscuit", "Whole Wheat Biscuit", 5, "snacks"));
        groceryItemRepo.save(new GroceryItem("Kodo Millet", "XYZ Kodo Millet healthy", 2, "millets"));
        groceryItemRepo.save(new GroceryItem("Dried Red Chilli", "Dried Whole Red Chilli", 2, "spices"));
        groceryItemRepo.save(new GroceryItem("Pearl Millet", "Healthy Pearl Millet", 1, "millets"));
        groceryItemRepo.save(new GroceryItem("Cheese Crackers", "Bonny Cheese Crackers Plain", 6, "snacks"));
        System.out.println("Data creation complete...");
    }
	
	public List<GroceryItem> getAllGroceryItem(){
		return groceryItemRepo.findAll();
	}
	
	public long findCountOfGroceryItems() {
        return groceryItemRepo.count();
    }
	
	public GroceryItem getGroceryItemByName(String name) {
        return groceryItemRepo.findItemByName(name);
    }
    
    public List<GroceryItem> getItemsByCategory(String category) {
        return groceryItemRepo.findAll(category);
    }
}
