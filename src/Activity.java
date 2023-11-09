import java.util.Date;

abstract class Activity implements Comparable<Activity> {

    private Date date;
    private Intensity intensity;
    private double time, distance, avHeartRate;
    private String type;
    private double calBurned;



    public void setCalBurned(double calBurned) {
        this.calBurned = calBurned;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Activity(Date date, double time, double distance, double avHeartRate, String type, double calBurned) {
        this.date = date;
        this.time = time;
        this.distance = distance;
        this.avHeartRate = avHeartRate;
        this.type = type;
        intensity = Intensity.VERY_LIGHT;
        this.calBurned = calBurned;

        if(this.type.equals("Swimming")) {
            if (Main.calculateKPH(this) <= 0.5) {
                intensity = Intensity.VERY_LIGHT;
                this.calBurned = 5* this.time;
            } else if (Main.calculateKPH(this) <= 1.25) {
                intensity = Intensity.LIGHT;
                this.calBurned = 6.3* this.time;
            } else if (Main.calculateKPH(this) <= 2) {
                intensity = Intensity.MODERATE;
                this.calBurned = 7.6* this.time;
            } else if (Main.calculateKPH(this) <= 2.75) {
                intensity = Intensity.VIGOROUS;
                this.calBurned = 8.9* this.time;
            } else if (Main.calculateKPH(this) <= 3.5) {
                intensity = Intensity.VERY_VIGOROUS;
                this.calBurned = 10.2* this.time;

            }
        }
        else  if(this.type.equals("Cycling")){
            if(Main.calculateKPH(this)<=8){
                intensity = Intensity.VERY_LIGHT;
                this.calBurned = 2* this.time;
            }
            else if(Main.calculateKPH(this)<=16){
                intensity = Intensity.LIGHT;
                this.calBurned = 5* this.time;
            }
            else if(Main.calculateKPH(this)<=25){
                intensity = Intensity.MODERATE;
                this.calBurned = 7* this.time;
            }
            else if(Main.calculateKPH(this)<=33){
                intensity = Intensity.VIGOROUS;
                this.calBurned = 13* this.time;
            }
            else if(Main.calculateKPH(this)<=40){
                intensity = Intensity.VERY_VIGOROUS;
                this.calBurned = 15* this.time;
            }
        }
        else  if(this.type.equals("Running")){
            if(Main.calculateKPH(this)<=4){
                intensity = Intensity.VERY_LIGHT;
                this.calBurned = 4.1* this.time;
            }
            else if(Main.calculateKPH(this)<=8){
                intensity = Intensity.LIGHT;
                this.calBurned = 7.2* this.time;
            }
            else if(Main.calculateKPH(this)<=12){
                intensity = Intensity.MODERATE;
                this.calBurned = 10* this.time;
            }
            else if(Main.calculateKPH(this)<=16){
                intensity = Intensity.VIGOROUS;
                this.calBurned = 15.4* this.time;

            }
            else if(Main.calculateKPH(this)<=24){
                intensity = Intensity.VERY_VIGOROUS;
                this.calBurned = 20.8* this.time;
            }
        }


    }

    public double getCalBurned() {
        return calBurned;
    }




    @Override
    public int compareTo(Activity o) {
        if (this == null && o == null) return 0;
        if (o == null) return 1;
        return this.date.compareTo(o.getDate());
    }

    public Intensity getIntensity() {
        return intensity;
    }

    public void setIntensity(Intensity intensity) {
        this.intensity = intensity;
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

    public String getDateString(){
        return date.getDate() + "/" + (date.getMonth()+1) + "/" + (date.getYear()+1900);
    }


    @Override
    public String toString() {
        return "Duration: " + time + "\nDistance: " + distance + "\nDate: " + getDateString() + "\nAverage Heart Rate: " + avHeartRate + "\n=======\n";
    }
}