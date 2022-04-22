import net.weever.interview.WayFair;
import org.junit.Test;

import java.time.Instant;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class WayfairTest {

    char[][] grid1 = {
            {'c', 'c', 'x', 't', 'i', 'b'},
            {'c', 'c', 'a', 't', 'n', 'i'},
            {'a', 'c', 'n', 'n', 't', 't'},
            {'t', 'c', 's', 'i', 'p', 't'},
            {'a', 'o', 'o', 'o', 'a', 'a'},
            {'o', 'a', 'a', 'a', 'o', 'o'},
            {'k', 'a', 'i', 'c', 'k', 'i'}
    };
    String word1 = "catnip";
    String word2 = "cccc";
    String word3 = "s";
    String word4 = "bit";
    String word5 = "aoi";
    String word6 = "ki";
    String word7 = "aaa";
    String word8 = "ooo";

    char[][] grid2 = {{'a'}};
    String word9 = "a";

    @Test
    public void test() {
        // List<int[]> res = new WayFair().find(grid1, word1);


        Instant time = Instant.parse("2020-03-31T08:00:00Z");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        time.atZone(ZoneOffset.UTC);
        String timeStr = String.format("[%s]", formatter.format(time));
        System.out.println(timeStr + " " + "event");
    }
}
