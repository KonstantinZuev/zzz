package model;

public class AddToShoppingListRequest {
    private String item;
    private String aisle;
    private boolean parse;

    public AddToShoppingListRequest(String item, String aisle, boolean parse) {
        this.item = item;
        this.aisle = aisle;
        this.parse = parse;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public boolean isParse() {
        return parse;
    }

    public void setParse(boolean parse) {
        this.parse = parse;
    }
}
