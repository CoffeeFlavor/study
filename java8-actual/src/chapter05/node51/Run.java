package chapter05.node51;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : jennie
 * @date: 2018/6/29
 * @Time: 16:39
 */
public class Run {
    public static void main(String[] args) {
        Trader raou1 = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario", "Milan");
        Trader alan = new Trader("Alan", "Cambridge");
        Trader brian = new Trader("Brian", "Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raou1, 2012, 1000),
                new Transaction(raou1, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

//        (1)
        List<Transaction> list = transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        System.out.println(list);

//        (2)
        List<String> citys = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .collect(Collectors.toList());
        System.out.println(citys);
//        (3)

        List<Trader> traders = transactions.stream()
                .map(Transaction::getTrader)
                .sorted(Comparator.comparing(Trader::getName))
                .collect(Collectors.toList());
        System.out.println(traders);

//        (4)
        List<String> names = transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getName)
                .sorted(String::compareTo)
                .collect(Collectors.toList());
        System.out.println(names);
        //(5)
        List<Trader> traders1 = transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Milan"))
                .collect(Collectors.toList());
        System.out.println(traders1);

        //(6)
        int sum = transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .reduce(0, Integer::sum);
        System.out.println(sum);

//        (7)
        transactions.stream()
                .max((o1, o2) -> {
                    if (o1.getValue() > o2.getValue()) {
                        return 1;
                    } else if (o1.getValue() == o2.getValue()) {
                        return 0;
                    } else {
                        return -1;
                    }
                }).ifPresent(transaction -> System.out.println(transaction.getValue()));

        transactions.stream()
                .max(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(transaction -> System.out.println(transaction.getValue()));

        transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo)
                .ifPresent(System.out::println);
       int max= transactions.stream()
                .map(Transaction::getValue)
                .reduce(0,Integer::max);
        System.out.println(max);

        //(8)
        transactions.stream()
                .min(Comparator.comparingInt(Transaction::getValue))
                .ifPresent(System.out::println);


    }

}
