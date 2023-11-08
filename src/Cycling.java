import java.util.Date;

public class Cycling extends Activity {

    public Cycling(Date date, double time, double distance, double avHeartRate) {
        super(date, time, distance, avHeartRate);
    }

    @Override
    public String toString() {
        return "\n=======\n" + "Cycling\n" + super.toString();
        //return super.toString() + "Cycling\t\t" + super.getTime() + "\t\t" + super.getDistance() + "\t\t" + super.getDateString() + "\t\t" + super.getAvHeartRate();
    }

}
