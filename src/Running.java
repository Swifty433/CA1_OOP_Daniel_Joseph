import java.util.Date;

public class Running extends Activity{

    @Override
    public String toString() {
        return "Running{}";
    }

    public Running(Date date, double time, double distance, double avHeartRate) {
        super(date, time, distance, avHeartRate);
    }
}
