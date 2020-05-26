package model;

public class Product {
    private String productName;
    private int productPrice;
    private int productQuantity;
    private String productColour;
    private String productDescription;
    private String categoryName;

    public Product(String productName,
                   int productPrice,
                   int productQuantity,
                   String productColour,
                   String productDescription,
                   String categoryName) {
        this.productName=productName;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
        this.productColour=productColour;
        this.productDescription=productDescription;
        this.categoryName=categoryName;
    }

    public Product(int productId, String productName, int productPrice) {
        this.productId=productId;
        this.productName=productName;
        this.productPrice=productPrice;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    private int productId;

    public Product(){};

    public Product(int productId,
                   String productName,
                   int productPrice,
                   int productQuantity,
                   String productColour,
                   String productDescription,
                   String categoryName) {
        this.productId = productId;
        this.productName=productName;
        this.productPrice=productPrice;
        this.productQuantity=productQuantity;
        this.productColour=productColour;
        this.productDescription=productDescription;
        this.categoryName=categoryName;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getProductColour() {
        return productColour;
    }

    public void setProductColour(String productColour) {
        this.productColour = productColour;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }
}
