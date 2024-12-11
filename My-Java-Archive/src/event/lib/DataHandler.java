package event.lib;

import java.io.*;

public class DataHandler {

    public static File dir = new File("C:\\EventPlanner");
    public static File fName = new File("C:\\EventPlanner\\EventData.txt");

    public static void saveData(EventPlanner planner) {
        try {
            if (!dir.exists()) {
                dir.mkdir();
            }
            if (!fName.exists()) {
                fName.createNewFile();
            }
            System.out.println("Ok");
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fName));
            oos.writeObject(planner);
            oos.close();
        } catch (Exception e) {
            System.out.println("Error saving data");
        }
    }

    public static EventPlanner loadData() {
        try {
            if (!dir.exists()) {
                dir.mkdir();
            }
            if (!fName.exists()) {
                fName.createNewFile();
            }
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fName));
            return (EventPlanner) ois.readObject();
        } catch (Exception e) {
            System.out.println("Error loading data");
        }
        return null;
    }
}
