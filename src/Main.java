import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        String fileName = "activity_data_10.csv";
        ArrayList<Activity> activities = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try (Scanner sc = new Scanner(new File(fileName)))
        {
            if(sc.hasNextLine())
                sc.nextLine();


            while (sc.hasNextLine())
            {
                String line = sc.nextLine();
                String [] tokens = line.split(",");

                String type = tokens[0];
                Date date = null;
                try{
                    date = dateFormat.parse(tokens[1]);
                }
                catch(ParseException e){
                    System.out.println("Date Error!");
                }

                double duration = Double.parseDouble(tokens[2]);
                double distance = Double.parseDouble(tokens[3]);
                double avHeartRate = Double.parseDouble(tokens[4]);


                if(type.equals("Running"))
                    activities.add(new Running(date ,duration, distance, avHeartRate));
                else if(type.equals("Cycling"))
                    activities.add(new Cycling(date ,duration, distance, avHeartRate));
                else if(type.equals("Swimming"))
                    activities.add(new Swimming(date ,duration, distance, avHeartRate));

            }

        } catch (FileNotFoundException exception)
        {
            System.out.println("FileNotFoundException caught. The file " +fileName+ " may not exist." + exception);
        }

        System.out.println(activities.toString());
        Collections.sort(activities);
        System.out.println(activities.toString());

        Scanner keyboard = new Scanner(System.in);
        boolean isRunning = true;
        while(isRunning){
            System.out.println("Option 1: Sort By Date. ");
            System.out.println("Option 2: Sort By Duration. ");
            System.out.println("Option 3: Sort By Distance. ");
            System.out.println("Option 4: Sort By Average Heart Rate. ");

            int input = keyboard.nextInt();
            int ans;
            switch (input){
                case 1:
                    ans = ascOrDesc();
                    if (ans == 1)
                    {
                        Collections.sort(activities);
                        printActivities(activities);
                    }
                    else if(ans == 2)
                    {
                        Collections.sort(activities);
                        Collections.reverse(activities);
                        printActivities(activities);
                    }
                    else
                    {
                        System.out.println("Invalid Input");
                    }
                    break;
                case 2:
                    ans = ascOrDesc();
                    if (ans == 1)
                    {
                        Collections.sort(activities, new Comparator<Activity>() {
                            @Override
                            public int compare(Activity o1, Activity o2) {
                                if (o1.getTime()>o2.getTime())
                                {
                                    return 1;
                                }
                                else if (o1.getTime()<o2.getTime())
                                {
                                    return -1;
                                }
                                return 0;
                            }
                        });
                        printActivities(activities);
                    }
                    else if(ans == 2)
                    {
                        Collections.sort(activities, new Comparator<Activity>() {
                            @Override
                            public int compare(Activity o1, Activity o2) {
                                if (o1.getTime()>o2.getTime())
                                {
                                    return -1;
                                }
                                else if (o1.getTime()<o2.getTime())
                                {
                                    return 1;
                                }
                                return 0;
                            }
                        });
                        printActivities(activities);
                    }
                    else
                    {
                        System.out.println("Invalid Input");
                    }
                    break;
                case 3:


                    break;
                case 4:

                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid Input. ");
                    break;
            }
        }
    }

    private static int ascOrDesc()
    {
        System.out.println("Option 1: Sort By Ascending.");
        System.out.println("Option 2: Sort By Descending.");
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextInt();
    }

    private static void printActivities(ArrayList <Activity> activities){
        for (Activity activity : activities)
        {
            System.out.println(activity.toString());
        }
    }

}
