package com.flowerShop.flowershop.controller;

import java.util.List;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.flowerShop.flowershop.model.Product;
import com.flowerShop.flowershop.repository.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private ProductRepository productRepository;

	@GetMapping
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public Product addProduct(@RequestBody Product product) throws ValidationException {
		return productRepository.save(product);

	}

	@GetMapping("/{id_product}")
	public Product getProductById(@PathVariable("id_product") int idProduct) {
		return productRepository.getOne(idProduct);
	}

	@DeleteMapping("delete/{id_product}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id_product") Integer id_product) {
		Product product = productRepository.getOne(id_product);
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}

	@PutMapping
	@ResponseStatus(HttpStatus.OK)
	public Product updateProduct(int idProduct, @RequestBody String name, @RequestBody String description,
			@RequestBody float price, @RequestBody int stock, @RequestBody String image) {
		Product newProduct = productRepository.getOne(idProduct);
		newProduct.setDescription(description);
		newProduct.setName(name);
		newProduct.setPrice(price);
		newProduct.setStock(stock);
		newProduct.setImage(image);
		return productRepository.save(newProduct);
	}

}
