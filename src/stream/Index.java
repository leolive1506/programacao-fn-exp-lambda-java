package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Index {
  public static void main() {
    List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
    Stream<Integer> st1 = list.stream().map(x -> x * 10);
    System.out.println(Arrays.toString(st1.toArray()));

    Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
    System.out.println(Arrays.toString(st2.toArray()));

    // iterate(primeiro el, fn iteraçao prox el)
    Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
    System.out.println(Arrays.toString(st3.limit(10).toArray()));

    Stream<Long> st4 = Stream.iterate(
      new Long[] {0L, 1L},
      p -> new Long[] {p[1], p[0] + p[1]}
    ).map(p -> p[0]);

    System.out.println(Arrays.toString(st4.limit(10).toArray()));

    // pipeline
    int sum = list.stream().reduce(0, (x, y) -> x + y);
    System.out.println("SUM = " + sum);

    List<Integer> newList = list.stream()
      .filter(x -> x % 2 == 0)
      .map(x -> x * 10)
      .toList();
    System.out.println(Arrays.toString(newList.toArray()));
  }
}
