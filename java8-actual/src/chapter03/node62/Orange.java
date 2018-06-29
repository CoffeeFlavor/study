package chapter03.node62;

/**
 * @author : jennie
 * @date: 2018/6/27
 * @Time: 11:32
 */
public class Orange extends Fruit {

    private String color;

    private Integer weight;

    public Orange(Integer weight) {
        this.weight = weight;
    }

    public Orange(String color, Integer weight) {
        this.color = color;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Orange{" +
                "color='" + color + '\'' +
                ", weight=" + weight +
                '}';
    }
}
