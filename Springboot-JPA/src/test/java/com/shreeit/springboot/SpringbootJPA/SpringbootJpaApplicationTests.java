package com.shreeit.springboot.SpringbootJPA;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.shreeit.springboot.SpringbootJPA.entity.Brand;
import com.shreeit.springboot.SpringbootJPA.entity.Category;
import com.shreeit.springboot.SpringbootJPA.entity.Product;
import com.shreeit.springboot.SpringbootJPA.service.BrandService;
import com.shreeit.springboot.SpringbootJPA.service.CategoryService;

@SpringBootTest
//@Transactional
class SpringbootJpaApplicationTests {
	
	@Autowired
	BrandService brandService;
	
	@Autowired
	CategoryService categoryService;
	
	@Test
	@DisplayName("List of brands")
	void getBrandList() {
		
		List<Brand> brandList = brandService.getBrandList();
		for (Brand brand2 : brandList) {
			Set<Product> prdList = brand2.getProductList();
			System.out.println("==============================");
			prdList.forEach(prd -> System.out.println(" || Product Name : "+prd.getProductName()));
		}
		
		System.out.println("========================================================");
		//brandList.forEach(brand -> System.out.println("Brand Id - "+brand.getBrandId()+" || Brand Name - "+brand.getBrandName()));
		System.out.println("========================================================");
		
	}
	
	@Test
	@DisplayName("List of Category")
	void getCategoryList() {
		List<Category> categoryList = categoryService.getCategoryList();
		System.out.println("========================================================");
		categoryList.forEach(category -> System.out.println("Category Id -> "+category.getCategoryId()+" || Category Name -> "+category.getCategoryName()));
		System.out.println("========================================================");		
	}
	
	@Test
	@DisplayName("Save category")
	void saveCategory() {
		Category category = new Category();
		category.setCategoryName("Mopped Bike");
		List<Category> categories = new ArrayList<Category>();
		categories.add(category);
		//boolean savedFlag = categoryService.saveCategory(categories);
		//System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+savedFlag);
	}

	

}
