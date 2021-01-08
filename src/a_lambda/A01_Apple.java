package a_lambda;

public class A01_Apple {
    private Integer weight;

    private String country;

    private String color;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public A01_Apple(Integer weight, String country) {
        this.weight = weight;
        this.country = country;

    }

    public A01_Apple() {
    }
}
