import java.util.Date;

public class Swimming extends Activity {

    public Swimming(Date date, double time, double distance, double avHeartRate) {
        super(date, time, distance, avHeartRate);
    }

    @Override
    public String toString() {
        return "\n=======\n" + "Swimming\n" + super.toString();
        //return super.toString() + "Swimming\t\t" + super.getTime() + "\t\t" + super.getDistance() + "\t\t" + super.getDateString() + "\t\t" + super.getAvHeartRate();
    }
}
