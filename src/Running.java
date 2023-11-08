import java.util.Date;

public class Running extends Activity {

    @Override
    public String toString() {
        return  "\n=======\n" + "Running\n" + super.toString();
        //return super.toString() + "Running\t\t" + super.getTime() + "\t\t" + super.getDistance() + "\t\t" + super.getDateString() + "\t\t" + super.getAvHeartRate();
    }

    public Running(Date date, double time, double distance, double avHeartRate) {
        super(date, time, distance, avHeartRate);
    }
}
