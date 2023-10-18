import ma.fstt.Beans.ProductBean;
import ma.fstt.Entities.Category;
import ma.fstt.Entities.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class main {
    public static void main(String[] args) {
        /*Product product = new Product();



        product.setId(0l);
        product.setName("Lait");
        product.setPrice(4.00);
        product.setDescription("best ");
        product.setCategory(category);
        product.setAvailability(true); */

        /*entityManager.getTransaction().begin();
        entityManager.persist(product);
        entityManager.persist(category);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close(); */

        /*
        ProductBean productBean = new ProductBean();

        // Create a Product instance
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(10.0);
        product.setDescription("Test description");

        Category category = new Category();
        category.setName("Test Category");

        product.setCategory(category);

        // Set the productBean properties
        productBean.setName(product.getName());
        productBean.setPrice(product.getPrice());
        productBean.setDescription(product.getDescription());
        productBean.setCategory(category); */

/*
        ProductBean productBean = new ProductBean();

        List<Product> products = productBean.getProducts();

        if (products != null && !products.isEmpty()) {
            for (Product product : products) {
                System.out.println("Product Name: " + product.getName());
                System.out.println("Price: " + product.getPrice());
                System.out.println("Description: " + product.getDescription());

                if (product.getCategory() != null) {
                    System.out.println("Category: " + product.getCategory().getName());
                } else {
                    System.out.println("No category associated with this product.");
                }
            }
        } else {
            System.out.println("No products found in the database.");
        }


        long productId = 1;
        Product producttodelete = productBean.getProductById(productId);

        //productBean.deleteProduct(producttodelete);

       */

        ProductBean productBean = new ProductBean();

        // Get a Product by its ID
        Long productId = 1L;
        Product product = productBean.getProductById(productId);

        if (product != null) {
            // Update the product
            product.setName("Updated Product Name");
            product.setPrice(20.0);
            product.setDescription("Updated product description");

            // Call the updateProduct method to save the changes
            productBean.updateProduct(product);

            System.out.println("Product updated successfully.");
        } else {
            System.out.println("Product with ID " + productId + " not found.");


        }


    }
}

