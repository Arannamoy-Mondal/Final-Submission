package Test;

import event.lib.EventPlanner;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        try{
            EventPlanner evp1 = new EventPlanner("EVP");
            String id = evp1.offerTourPackage("Tour Kaptai", LocalDate.now(), 20, 20, 2000);
            evp1.addEventTask(id,"Hello","Hi");
            System.out.println(evp1);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}