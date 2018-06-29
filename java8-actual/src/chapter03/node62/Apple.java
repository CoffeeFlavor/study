package chapter03.node62;

/**
 * @author : jennie
 * @date: 2018/6/26
 * @Time: 15:30
 */
public class Apple extends Fruit{


    private String color;

    public Apple(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    private Integer weight;



    public Apple(){
        super();
    }
    public Apple(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
