package demo.springbootmongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.springbootmongodb.entity.GroceryItem;
import demo.springbootmongodb.service.ItemService;

@RestController
@RequestMapping(value="/api/groceryitems")
public class ItemController {

	@Autowired
	ItemService itemService;
	
	@PostMapping(value="/initial", produces=MediaType.APPLICATION_JSON_VALUE)
    public void createCustomer() {
		itemService.createGroceryItems();
    }
	
	@GetMapping(value="/all", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<GroceryItem> getAllGroceryItem() {
		return itemService.getAllGroceryItem();
    }
	
	@GetMapping(value="/count", produces=MediaType.APPLICATION_JSON_VALUE)
    public long findCountOfGroceryItems() {
		return itemService.findCountOfGroceryItems();
    }
	
	@GetMapping(value="/item/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
    public GroceryItem getGroceryItemByName(@PathVariable String name) {
		return itemService.getGroceryItemByName(name);
    }
	
	@GetMapping(value="/items/{category}", produces=MediaType.APPLICATION_JSON_VALUE)
    public List<GroceryItem> getItemsByCategory(@PathVariable String category) {
		return itemService.getItemsByCategory(category);
    }
}
