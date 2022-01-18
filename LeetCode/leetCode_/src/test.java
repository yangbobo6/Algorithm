import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        int numRows = 4;
        List<StringBuilder> rows = new ArrayList<StringBuilder>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }
        for (StringBuilder s:rows
             ) {
            System.out.println(s);
        }
    }
}
