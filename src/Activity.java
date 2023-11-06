import java.util.Date;

abstract class Activity implements Comparable<Activity>{

    private Date date;
    private double time, distance, avHeartRate;

    public Activity(Date date, double time, double distance, double avHeartRate) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avHeartRate = avHeartRate;
    }

    @Override
    public int compareTo(Activity o){
        if(this == null && o == null) return 0;
        if(o == null) return 1;
        return this.date.compareTo(o.getDate());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public double getAvHeartRate() {
        return avHeartRate;
    }

    public void setAvHeartRate(double avHeartRate) {
        this.avHeartRate = avHeartRate;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "date=" + date +
                ", time=" + time +
                ", distance=" + distance +
                ", avHeartRate=" + avHeartRate +
                '}';
    }
}
