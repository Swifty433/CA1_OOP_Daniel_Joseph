import java.util.Date;

public class Cycling extends Activity {

    public Cycling(Date date, double time, double distance, double avHeartRate, String type, double calBurned) {
        super(date, time, distance, avHeartRate, type, calBurned);
    }

    @Override
    public String toString() {
        return "\n=======\n" + "Cycling\n" + super.toString();
        //return super.toString() + "Cycling\t\t" + super.getTime() + "\t\t" + super.getDistance() + "\t\t" + super.getDateString() + "\t\t" + super.getAvHeartRate();
    }

}