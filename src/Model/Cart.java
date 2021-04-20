package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import Model.Item;


public class Cart {
	private HashMap<Integer, Item> cart;

	public Cart() {
		cart = new HashMap<Integer, Item>();
	}
	
	
	public Cart(HashMap<Integer, Item> cart) {
		super();
		this.cart = cart;
	}



	public HashMap<Integer, Item> getCart() {
		return cart;
	}


	public void setCart(HashMap<Integer, Item> cart) {
		this.cart = cart;
	}


	public void AddProduct(int idProduct, Product pr) {
		if(cart.containsKey(idProduct)) {
			Item item = cart.get(idProduct);
			item.setQuantity(item.getQuantity()+1);
		}
		else {
			
			Item item = new Item();
			item.setProduct(pr);
			item.setQuantity(1);
			cart.put(idProduct, item);
		}
	}
	
	public void SubProduct(int idProduct) {
		if(cart.containsKey(idProduct)) {
			Item item = cart.get(idProduct);
			item.setQuantity(item.getQuantity()-1);
			if(item.getQuantity()<1)
				cart.remove(idProduct);
				
		}
		
		
	}
	
	public void RemoveProduct(int idProduct) {
		if(cart.containsKey(idProduct)) {
			cart.remove(idProduct);
		}
		
	}
	
	public int total(HashMap<Integer, Item> map) {
		int sum=0;    
	    Set<Map.Entry<Integer,Item>> set = map.entrySet();
		for (Entry<Integer, Item> i : set) {
			sum = sum + i.getValue().getQuantity() * (i.getValue().getProduct().getPrice()-i.getValue().getProduct().getSale());
		}
		return sum;
	}
	
	public int countItem() {
		return cart.size();
	}
	
	public static void main(String[] args) {
		
		Cart cart = new Cart();
		Product pr = new Product("1",null,"3","4",5,"6",7,8,null,null);
		cart.AddProduct(1, pr);
		HashMap<Integer,Item> map = cart.getCart();
		Set<Map.Entry<Integer,Item>> set = map.entrySet();
		for (Entry<Integer, Item> entry : set) {
			System.out.print(entry.getValue().getProduct().getName_product());
			
			
			
			
		}
		
		
	}
	

}
