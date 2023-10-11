package objects;

public class Store {
     int id;

    public int getId() {
        return id;
    }

    public Store(){}
    public Store(int id, String author, String category, float price, String title) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.price = price;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public float getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    String author;
    String category;
    float price;
     String  title;

}
