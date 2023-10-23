import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Question6 {
    public void solution() {
        int[] a = new int[4];

        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 1;

        List<Integer> list = Arrays.stream(a)
            .boxed()
//            .toList();
//            .collect(Collectors.toList());
            .collect(Collectors.toCollection(ArrayList::new));
        list.add(10);

        a = list.stream()
            .mapToInt(number -> number)
            .toArray();
    }
}
