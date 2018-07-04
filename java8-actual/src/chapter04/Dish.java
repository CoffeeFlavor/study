package chapter04;

import java.util.Arrays;
import java.util.List;

/**
 * @author : jennie
 * @date: 2018/6/28
 * @Time: 11:28
 */
public class Dish {

    private final String name;

    private final boolean vegetarian;

    private final int calories;

    private final Type type;

    private static List<Dish> memu;

    static {
        memu=Arrays.asList(
                new Dish("pork",false,800,Type.MEAR),
                new Dish("beef",false,700,Type.MEAR),
                new Dish("chicken",false,400,Type.MEAR),
                new Dish("french",false,530,Type.OTHER),
                new Dish("rice",true,350,Type.OTHER),
                new Dish("season fruit",true,120,Type.OTHER),
                new Dish("pizza",true,550,Type.OTHER),
                new Dish("prawns",false,300,Type.FISH),
                new Dish("salmon",false,450,Type.FISH)
        );
    }


    public Dish(String name, boolean vegerarian, int colories, Type type) {
        this.name = name;
        this.vegetarian = vegerarian;
        this.calories = colories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isVegetarian() {
        return vegetarian;
    }

    public int getCalories() {
        return calories;
    }

    public Type getType() {
        return type;
    }

    public enum  Type{ MEAR,FISH,OTHER}

    public static List<Dish> getMemu() {
        return memu;
    }

    public static void setMemu(List<Dish> memu) {
        Dish.memu = memu;
    }

    @Override
    public String toString() {
        return "Dish{" +
                "name='" + name + '\'' +
                ", vegetarian=" + vegetarian +
                ", calories=" + calories +
                ", type=" + type +
                '}';
    }

    public enum CaloriceLevel{
        DIET,
        NORMAL,
        FAT
    }
}
