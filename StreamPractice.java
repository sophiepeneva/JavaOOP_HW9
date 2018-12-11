# JavaOOP_HW9

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPractice {
    public static void main(String[] args) {
        Stream<String> stream = Stream.of("d", "abc", "ef", "123456");
        List<String> list = stream.map(s -> s.toUpperCase()).sorted().collect(Collectors.toList());
        for (String l : list) {
            System.out.println(l);
        }

        IntStream.rangeClosed(1, 100).mapToObj(i -> i + "").reduce((s, t) -> s + "#" + t).ifPresent(System.out::println);

        List<Integer> randomNums = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int number = random.nextInt(31);
            randomNums.add(number);
        }
        Supplier<Stream<Integer>> streamSupplier = () -> randomNums.stream();

        streamSupplier.get().forEach(System.out::println);
        System.out.println(streamSupplier.get().anyMatch(a -> a % 5 == 0));
        System.out.println(streamSupplier.get().allMatch(a -> a < 15));
        System.out.println(streamSupplier.get().filter(a -> a > streamSupplier.get().mapToInt(Integer::intValue).average().getAsDouble()).count() > 5);

        Stream<Integer> sortingCheck = Stream.of(5,4,6,8,7);
        sortingCheck.sorted((s1,s2)->{
            System.out.printf("sorting %d and %d\n", s1, s2);
            return s1.compareTo(s2);
        }).forEach(System.out::println);


        Stream.of("d2","a2","b1","b3","c").filter(s -> {
            System.out.println("filtering : " + s);
            return true;
        }).forEach(s->System.out.println("for each : " + s));
    }
}
