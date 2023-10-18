package ma.fstt.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "cart_items")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product; // Represents the product associated with this cart item

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private ShoppingCart shoppingCart; // Represents the shopping cart to which this item belongs

    private int quantity; // Quantity of the product in the cart

    public CartItem() {
    }

    public CartItem(int id, Product product, ShoppingCart shoppingCart, int quantity) {
        this.id = id;
        this.product = product;
        this.shoppingCart = shoppingCart;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

