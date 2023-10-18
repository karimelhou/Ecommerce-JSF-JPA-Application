package ma.fstt.Beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import ma.fstt.Entities.Category;
import ma.fstt.Entities.Product;

import java.util.List;

@Named
@RequestScoped
public class ProductBean {

    private String name;
    private double price;
    private String description;
    private Category category;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private boolean showCreateForm;

    public boolean isShowCreateForm() {
        return showCreateForm;
    }

    public void setShowCreateForm(boolean showCreateForm) {
        this.showCreateForm = showCreateForm;
    }

    public String showCreateForm() {
        showCreateForm = true;
        return null;
    }

    public void createProduct() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDescription(description);
        product.setCategory(category);

        em.getTransaction().begin();
        em.persist(product);
        em.getTransaction().commit();

        em.close();
        emf.close();

        showCreateForm = false;
    }

    public Product getProductById(Long productId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Product product = em.find(Product.class, productId);

        em.getTransaction().commit();

        em.close();
        emf.close();

        return product;
    }

    public List<Product> getProducts() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query query = em.createQuery("select p from Product p", Product.class);
        products = query.getResultList(); // Set the products field

        em.close();
        emf.close();

        return products;
    }

    public void updateProduct(Product product) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(product);
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    public void deleteProduct(Product product) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        Product managedProduct = em.find(Product.class, product.getId());
        if (managedProduct != null) {
            em.remove(managedProduct);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }

    private Long productIdToSearch;
    private Product searchedProduct;

    public Long getProductIdToSearch() {
        return productIdToSearch;
    }

    public void setProductIdToSearch(Long productIdToSearch) {
        this.productIdToSearch = productIdToSearch;
    }

    public Product getSearchedProduct() {
        return searchedProduct;
    }

    public void setSearchedProduct(Product searchedProduct) {
        this.searchedProduct = searchedProduct;
    }

    public String searchProductById(Long productIdToSearch) {
        System.out.println("Searching for product with ID: " + productIdToSearch);
        searchedProduct = getProductById(productIdToSearch);
        return null;
    }

}
