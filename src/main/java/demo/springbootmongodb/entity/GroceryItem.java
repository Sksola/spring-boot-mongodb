package demo.springbootmongodb.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

 //We use the annotation @Document to set the collection name that will be used by the model. 
// If the collection doesn’t exist, MongoDB will create it.
@Document("groceryitems")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroceryItem {

		//Specify the MongoDB document’s primary key _id using the @Id annotation. 
		// If we don’t specify anything, MongoDB will generate an _id field while creating the document.
        @Id
        private String id;

        private String name;
        private int quantity;
        private String category;
        
        public GroceryItem(String id, String name, int quantity, String category) {
            super();
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.category = category;
        }

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getQuantity() {
			return quantity;
		}

		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}

		public String getCategory() {
			return category;
		}

		public void setCategory(String category) {
			this.category = category;
		}
}