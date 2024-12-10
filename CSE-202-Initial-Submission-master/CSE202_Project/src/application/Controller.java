package application;

import event.lib.DataHandler;
import event.lib.TourPackage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import event.lib.Event;

public class Controller implements Initializable {
    Pane root;
    Stage stage;
    Scene scene;


    //   Reya's code start
    public void customerHomeBtn(ActionEvent e) // customer home a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("CustomerHome.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();

            stage.setTitle("Home");

        } catch (Exception er) {
//            System.out.println("Error in customerHomeBtn");
        }
    }

    public void employeeHomeBtn(ActionEvent e) // emplyee home a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("EmployeeHome.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Home");
        } catch (Exception ex) {
//            System.out.println("Error in employeeHomeBtn");
        }
    }


    //    request for corporate event start
    public void requestForCorporateEventBtn(ActionEvent e)  // request for corporate event page a niye jabe
    {
        try {
            root = FXMLLoader.load(getClass().getResource("RequestForCorporateEvent.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Home");
        } catch (Exception ex) {
//            System.out.println("Error in requestForCorporateEventBtn");
        }
    }

    @FXML
    TextField eventTitleForRequestForCorporateEvent; // data receive korbe

    @FXML
    DatePicker eventDateForRequestForCorporateEvent; // data receive korbe , Lacal Date type

    @FXML
    TextField customerContactForRequestForCorporateEvent; // data receive korbe

    @FXML
    TextField durationDaysForRequestForCorporateEvent; // data receive korbe

    @FXML
    TextField numberOfParticipantsForRequestForCorporateEvent; // data receive korbe

    public void requestForCorporateEventSubmitBtn(ActionEvent e) {
        try {
//            requestedEvents Arraylist a jabe

////            System.out.println(eventTitleForRequestForCorporateEvent.getText() + eventDateForRequestForCorporateEvent.getValue() + customerContactForRequestForCorporateEvent.getText() + durationDaysForRequestForCorporateEvent.getText() + numberOfParticipantsForRequestForCorporateEvent.getText());
//            String title=eventTitleForRequestForCorporateEvent.getText()
//              Main.evp1.requestEvent(eventTitleForRequestForCorporateEvent.getText(),customerContactForRequestForCorporateEvent.getText(),eventDateForRequestForCorporateEvent.getValue(),);
////            System.out.println(eventDateForRequestForCorporateEvent.getValue().getClass().getName());

        } catch (Exception er) {
//            System.out.println("Error in requestForCorporateEventSubmitBtn");
        }
    }

//    request for corporate event end
//    Reya's code start


//    ====================================================================================================================================

    //    Lamia's code start
//    register for tour start
    public void registerForTourBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("RegisterForTour.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
//            System.out.println("Error in registerForTourBtn");
        }
    }

    @FXML
    TextField tourIdForRegisterForTour;
    @FXML
    TextField participantForRegisterForTour;
    @FXML
    TextField contactForRegisterForTour;

    public void registerTourSubmitBtn(ActionEvent e) {
        try {
//            Main.evp1.registerForTour();
//            System.out.println("Done");
        } catch (Exception ex) {
//            System.out.println("Error in registerTourSubmitBtn");
        }
    }

    //    register for tour end
//    pay bill start
    public void payBillBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("PayBill.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
        } catch (Exception ex) {
//            System.out.println("Error in payBillBtn");
        }
    }

    @FXML
    TextField eventIdForPayBill;
    @FXML
    Button totalBillForPayBill;

    public void showTotalBillForPayBill(ActionEvent e) {
        totalBillForPayBill.setText("5000 BDT");
    }

    public void payBillSubmitBtnPayBill(ActionEvent e) {
        try {
//            System.out.println("Done");
        } catch (Exception er) {
//            System.out.println("Error in payBillSubmitBtn");
        }
    }
//    pay bill end
//    Lamia's code end


//    =========================================================================================================================

    //    Osman's code start
//    log out start
    public void logOutBtn(ActionEvent e) {
        try {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Log Out");
            alert.setContentText("Are you sure you want to log out?");
            if(alert.showAndWait().get() == ButtonType.OK) {
                root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
                stage.setScene(scene);
                stage.show();
            }
            DataHandler.saveData(Main.evp1);

        } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
        }
    }

    //    log out end
//    offer tour package start
    public void offerTourPackageBtn(ActionEvent e) {
        try {
            root = FXMLLoader.load(getClass().getResource("OfferTourPackage.fxml"));
            stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            DataHandler.saveData(Main.evp1);

        } catch (Exception ex) {
//            System.out.println("Error in offerTourBtn");
        }
    }

    @FXML
    TextField eventTitleForOfferTourPackage;
    @FXML
    DatePicker eventDateForOfferTourPackage;
    @FXML
    TextField customerContactForOfferTourPackage;
    @FXML
    TextField durationDaysForOfferTourPackage;
    @FXML
    TextField perPersonForOfferTourPackage;
    @FXML
    TextField numberOfParticipantsForOfferTourPackage;
    @FXML
    Button offerTourPackageSubmitButton = new Button("OfferTourPackage");
    @FXML
    Text massageBoxOfferBtn=new Text();
    public void offerTourPackageSubmitBtn(ActionEvent e) {
        try {
            String tourId = Main.evp1.offerTourPackage(
                    eventTitleForOfferTourPackage.getText(),
                    eventDateForOfferTourPackage.getValue(),
                    Integer.parseInt(durationDaysForOfferTourPackage.getText()),
                    Integer.parseInt(numberOfParticipantsForOfferTourPackage.getText()),
                    Integer.parseInt(perPersonForOfferTourPackage.getText()));
                    massageBoxOfferBtn.setText("Offered tour successfully.");
////            System.out.println(Main.evp1.getEvents());
        } catch (Exception er) {
            massageBoxOfferBtn.setText("Something went wrong");
//            System.out.println("Error in offerTourPackageSubmitBtn");
        }
    }


//    offer tour package end

//    Osman's code end


//    ====================================================================================================================================


    //    Aranna's code start
//    Manage Events start
    @FXML
    ListView eventStatus = new ListView();
    public void mangeEventsBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ManageEvent.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Manage Events");
        } catch (Exception e) {
//            System.out.println("Error in mangeEventsBtn");
        }
    }

    @FXML
    TextField eventIdAcceptEvent;
    @FXML
    Text messgaeBoxAcceptEvent;

    @FXML
    ListView requestedEventsList = new ListView();
    @FXML
    ListView allEventsList = new ListView();
    public void acceptEvent(ActionEvent event) {
        try {

            Main.evp1.acceptEvent(eventIdAcceptEvent.getText());
//            eventStatus.setText(Main.evp1.showRequestedEvents());
            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
            messgaeBoxAcceptEvent.setText("Accepted Event.");
////            System.out.println(eventIdAcceptEvent.getText());
            if(Main.evp1.getRequestedEvents().size()<1){
                requestedEventsList.getItems().add("No Event Found");
            }
            else{
                for(Event e:Main.evp1.getRequestedEvents()){
////                    System.out.println(e.toString());
//                    requestedEventsList.getItems().add(e.toString());
                    requestedEventsList.getItems().add(e.getEventId()+" "+e.getEventManager()+" "+e.getEventTitle()+" "+" "+e.getEventDate()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                }
            }
        } catch (Exception e) {
//            eventStatus.setText(Main.evp1.showRequestedEvents());
            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
        }
    }

    //    Manage Events end
    //    Manage Tasks start
    public void manageTasksBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("ManageTask.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Manage Tasks");
        } catch (Exception e) {
//            System.out.println("Error in manageTasksBtn");
        }
    }

    @FXML
    RadioButton addTaskRadioBtn;
    @FXML
    RadioButton startTaskRadioBtn;
    @FXML
    RadioButton endTaskRadioBtn;
    @FXML
    TextField eventIdTaskManage;
    @FXML
    TextField taskTitleTaskManage;
    @FXML
    TextField taskDescriptionTaskManage;
    @FXML
    Text messgaeBoxTaskManage;

    public void manageTasks(ActionEvent event) {
        try {
            if (addTaskRadioBtn.isSelected()) {
                try{
                    Main.evp1.addEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText(), taskDescriptionTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task added successfully.");
                } catch (Exception e) {
                    System.out.println(eventIdTaskManage.getText()+" "+taskTitleTaskManage.getText()+" "+taskDescriptionTaskManage.getText());
                    messgaeBoxTaskManage.setText(e.getMessage().toString());
                }
                if(Main.evp1.getEvents().size()<1){
                    allEventsList.getItems().clear();
                    allEventsList.getItems().add("No Event Found");
                }
                else{
                    allEventsList.getItems().clear();
                    for(Event e:Main.evp1.getEvents()) {
                        allEventsList.getItems().add(e.getEventId()+" "+e.getEventTitle()+" "+e.getEventDate()+" "+e.getEventManager()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                    }
                }
            } else if (startTaskRadioBtn.isSelected()) {
////                System.out.println("Star Task");
                try{
                    Main.evp1.startEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task start successfully.");
                } catch (Exception e) {
                    messgaeBoxTaskManage.setText(e.toString());
                }
                if(Main.evp1.getEvents().size()<1){
                    allEventsList.getItems().clear();
                    allEventsList.getItems().add("No Event Found");
                }
                else{
                    allEventsList.getItems().clear();
                    for(Event e:Main.evp1.getEvents()) {
                        allEventsList.getItems().add(e.getEventId()+" "+e.getEventTitle()+" "+e.getEventDate()+" "+e.getEventManager()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                    }
                }
            } else if (endTaskRadioBtn.isSelected()) {
////                System.out.println("End Btn");
                try{
                    Main.evp1.completeEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task completed successfully.");
                } catch (Exception e) {
//                    System.out.println(e.toString());
                }
                if(Main.evp1.getEvents().size()<1){
                    allEventsList.getItems().clear();
                    allEventsList.getItems().add("No Event Found");
                }
                else{
                    allEventsList.getItems().clear();
                    for(Event e:Main.evp1.getEvents()) {
                        allEventsList.getItems().add(e.getEventId()+" "+e.getEventTitle()+" "+e.getEventDate()+" "+e.getEventManager()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                    }
                }
            } else {
                messgaeBoxTaskManage.setText("Please select one of the following actions: Add task, Start task, End task.");
            }
        } catch (Exception e) {
            messgaeBoxTaskManage.setText("Something went wrong");
            messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733");
        }
    }

    //    Manage Tasks end

    //    Assign Event manager start
    public void assignEventManagerBtn(ActionEvent event) {
        try {
            root = FXMLLoader.load(getClass().getResource("AssignEventManager.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.setMaximized(true);
            stage.setTitle("Assign Event Manager");
        } catch (Exception e) {
//            System.out.println("Error in assignEventManagerBtn");
        }
    }

    @FXML
    TextField eventIdAssignEventManager;
    @FXML
    TextField managerNameAssignEventManager;

    public void assignEventManager(ActionEvent event) {
        try {
            Main.evp1.assignEventManager(eventIdAssignEventManager.getText(), managerNameAssignEventManager.getText());
            if(Main.evp1.getEvents().size()<1){
                allEventsList.getItems().add("No Event Found");
            }
            else{
                allEventsList.getItems().clear();
                for(Event e:Main.evp1.getEvents()) {
                    allEventsList.getItems().add(e.getEventId()+" "+e.getEventTitle()+" "+e.getEventDate()+" "+e.getEventManager()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                }
            }
        } catch (Exception e) {
//            System.out.println("Error in assignEventManager");
        }
    }

    //    Assign Event manager end

    @FXML
    TableView<Event> eventTableViewForCustomer=new TableView<>();

    @FXML
    TableColumn<Event, String> eventIdTableViewForCustomer=new TableColumn<>();

    @FXML
    TableColumn<Event, String> eventTitleTableViewForCustomer=new TableColumn<>();

    @FXML
    TableColumn<Event, LocalDate> eventDateTableViewForCustomer=new TableColumn<>();

    @FXML
    TableColumn<Event, Integer> eventDurationDaysForCustomer =new TableColumn<>();

    @FXML
    TableColumn<Event,Integer> perPersonPriceForCustomer=new TableColumn<>();

    @FXML
    TableColumn<Event, Integer> eventNumOfParticipantsForCustomer=new TableColumn<>();

    @FXML
    TableColumn<Event, String> totalRegisteredForCustomer=new TableColumn<>();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try{

            ObservableList<Event> eventList = FXCollections.observableArrayList();
            if(Main.evp1.getEvents().size()<1){
                allEventsList.getItems().add("No Event Found");
                eventList.clear();
            }
            else{
                allEventsList.getItems().clear();
                eventList.addAll(Main.evp1.getEvents());
                for(Event e:Main.evp1.getEvents()) {
                    allEventsList.getItems().add(e.getEventId()+" "+e.getEventTitle()+" "+e.getEventDate()+" "+e.getEventManager()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                }
            }
            if(Main.evp1.getRequestedEvents().size()<1){
                requestedEventsList.getItems().add("No Event Found");
            }
            else{
                allEventsList.getItems().clear();
                for(Event e:Main.evp1.getRequestedEvents()){
                    requestedEventsList.getItems().add(e.getEventId()+" "+e.getEventManager()+" "+e.getEventTitle()+" "+" "+e.getEventDate()+" "+e.getCustomerContact()+" "+e.getDurationInDays()+" "+e.getNumOfParticipants());
                }
            }
// Table view for customer start
            eventIdTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            eventTitleTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            eventDateTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            eventDurationDaysForCustomer.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));
            perPersonPriceForCustomer.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            eventTableViewForCustomer.setItems(eventList);
//  Table view for customer end

        } catch (Exception e) {
//            System.out.println("Error in initialize");
        }
    }
//    Aranna's code end

    public void searchForTourBtn(ActionEvent event) {
        try{
            root = FXMLLoader.load(getClass().getResource("SearchEvent.fxml"));
            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
            scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
            stage.setScene(scene);
            stage.show();
            stage.setTitle("Search Event");

        } catch (Exception e) {
            System.out.println("Something went wrong");
        }
    }
}
