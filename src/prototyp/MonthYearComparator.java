package prototyp;

import java.util.Comparator;
import java.util.Date;

public class MonthYearComparator implements Comparator<Date> {

    public int compare(Date o1, Date o2) {
        // TODO Auto-generated method stub
        return -1*o1.compareTo(o2);
    }

}