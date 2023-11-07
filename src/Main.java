import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class Main {

    public static String getFile() {
        // reference to code https://www.tutorialspoint.com/how-to-get-list-of-all-files-folders-from-a-folder-in-java
        //code references folder and reads file names from it
        File directoryPath = new File("csvFiles");
        String contents[] = directoryPath.list();
        System.out.println("Available Data:");
        for (int i = 0; i < contents.length; i++) {
            System.out.println( i + ": " + contents[i]);
        }

        int fileIndex = -1;
        Scanner keyboard = new Scanner(System.in);
        while (fileIndex < 0 || fileIndex >= contents.length) {
            fileIndex = keyboard.nextInt();

            if (fileIndex < 0 || fileIndex >= contents.length) {
                System.out.println("Invalid!");
            }
        }

        return "csvFiles/" + contents[fileIndex];
    }

    public static void main(String[] args) {
        String fileName = getFile();
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
            System.out.println("\nOption 1: Sort By Date. ");
            System.out.println("Option 2: Sort By Duration. ");
            System.out.println("Option 3: Sort By Distance. ");
            System.out.println("Option 4: Sort By Average Heart Rate. ");
            System.out.println("Option 5: Close Programme. ");

            int input = keyboard.nextInt();
            String ans2;
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
                    ans = ascOrDesc();
                    if (ans == 1)
                    {
                        Collections.sort(activities, new Comparator<Activity>() {
                            @Override
                            public int compare(Activity o1, Activity o2) {
                                if (o1.getDistance()>o2.getDistance())
                                {
                                    return 1;
                                }
                                else if (o1.getDistance()<o2.getDistance())
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
                                if (o1.getDistance()>o2.getDistance())
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
                case 4:
                    ans = ascOrDesc();
                    if (ans == 1)
                    {
                        Collections.sort(activities, new Comparator<Activity>() {
                            @Override
                            public int compare(Activity o1, Activity o2) {
                                if (o1.getAvHeartRate()>o2.getAvHeartRate())
                                {
                                    return 1;
                                }
                                else if (o1.getAvHeartRate()<o2.getAvHeartRate())
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
                                if (o1.getAvHeartRate()>o2.getAvHeartRate())
                                {
                                    return -1;
                                }
                                else if (o1.getAvHeartRate()<o2.getAvHeartRate())
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
                case 5:
                    ans2 = closeCode();
                    if(Objects.equals(ans2, "Y") || Objects.equals(ans2, "y"))
                    {
                        isRunning = false;
                    }
                    else if (Objects.equals(ans2, "N") || Objects.equals(ans2, "n"))
                    {
                        break;
                    }
                    break;
                default:
                    System.out.println("Invalid Input. ");
                    break;
            }
        }
    }

    private static String closeCode()
    {
        System.out.println("Are you sure? = Y: \n Actually No! = N:");
        Scanner keyboard = new Scanner(System.in);
        return  keyboard.nextLine();
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
