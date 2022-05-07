import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Timeconversion {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.ENGLISH); //Specify your locale

    public static long timeConversion(String time) {
        long unixTime = 0;
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT+5:30")); //Specify your timezone
        try {
            unixTime = dateFormat.parse(time).getTime();
            unixTime = unixTime / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return unixTime;
    }

    public static Integer tsToSec8601(String timestamp) {
        if (timestamp == null) return null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
            Date dt = sdf.parse(timestamp);
            long epoch = dt.getTime();
            return (int) (epoch / 1000);
        } catch (ParseException e) {
            return null;
        }

    }
        public static void main(String[] args){
            System.out.println(Timeconversion.tsToSec8601("2020-01-01T00:00:00.000-0000"));
        }


}
