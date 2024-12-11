package application;

import event.lib.DataHandler;
import event.lib.Task;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

import event.lib.Event;
import javafx.util.StringConverter;
import javafx.util.converter.IntegerStringConverter;

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
            Main.evp1.requestEvent(eventTitleForRequestForCorporateEvent.getText(),
                    customerContactForRequestForCorporateEvent.getText(),
                    eventDateForRequestForCorporateEvent.getValue(),
                    Integer.parseInt(durationDaysForRequestForCorporateEvent.getText()),
                    Integer.parseInt(numberOfParticipantsForRequestForCorporateEvent.getText())
            );
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
            Main.evp1.registerForTour(tourIdForRegisterForTour.getText(), Integer.parseInt(participantForRegisterForTour.getText()), contactForRegisterForTour.getText());
//            System.out.println("Done");
            tableRefresh();
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
    @FXML
    Button billPaymentBtn;

    public void showTotalBillForPayBill(ActionEvent e) {
        try {
            System.out.println(eventIdForPayBill.getText());
            double tmp = Main.evp1.payBill(eventIdForPayBill.getText());
            System.out.println(tmp);
            if ((int) tmp > 0) {
                totalBillForPayBill.setText("Total bill: " + tmp);
                totalBillForPayBill.setVisible(true);
                billPaymentBtn.setVisible(true);
                totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
                totalBillForPayBill.setDisable(true);
//                totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            } else {
                totalBillForPayBill.setText("Bill Not Found");
                totalBillForPayBill.setVisible(true);
                totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
                totalBillForPayBill.setDisable(true);
//                totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
            }
        } catch (Exception ex) {
            totalBillForPayBill.setVisible(true);
            totalBillForPayBill.setText(ex.getMessage());
            totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
            totalBillForPayBill.setDisable(true);
//            totalBillForPayBill.setPrefWidth(Toolkit.getDefaultToolkit().getScreenSize().getWidth());
        }
    }

    public void payBillSubmitBtnPayBill(ActionEvent e) {
        try {
            totalBillForPayBill.setText("Payment Done.");
            totalBillForPayBill.setStyle("-fx-background-color: #0af02d");
        } catch (Exception er) {
            totalBillForPayBill.setText("Payment Failed.");
            totalBillForPayBill.setStyle("-fx-background-color: #FF5733");
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
            if (alert.showAndWait().get() == ButtonType.OK) {
                root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                scene = new Scene(root, Toolkit.getDefaultToolkit().getScreenSize().getWidth(), Toolkit.getDefaultToolkit().getScreenSize().getHeight());
                stage.setScene(scene);
                stage.show();

            }
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
    Button massageBoxOfferBtn = new Button();

    public void offerTourPackageSubmitBtn(ActionEvent e) {
        try {
            String tourId = Main.evp1.offerTourPackage(
                    eventTitleForOfferTourPackage.getText(),
                    eventDateForOfferTourPackage.getValue(),
                    Integer.parseInt(durationDaysForOfferTourPackage.getText()),
                    Integer.parseInt(numberOfParticipantsForOfferTourPackage.getText()),
                    Integer.parseInt(perPersonForOfferTourPackage.getText()));
            massageBoxOfferBtn.setText("Offered tour successfully.");
            massageBoxOfferBtn.setStyle("-fx-background-color: #13ea31 ");
            massageBoxOfferBtn.setVisible(true);
            massageBoxOfferBtn.setDisable(true);
////            System.out.println(Main.evp1.getEvents());
        } catch (Exception er) {
            massageBoxOfferBtn.setText(er.getMessage());
            massageBoxOfferBtn.setStyle("-fx-background-color: #FF5733");
            massageBoxOfferBtn.setVisible(true);
            massageBoxOfferBtn.setDisable(true);
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
    Button messgaeBoxAcceptEvent = new Button();

    public void acceptEvent(ActionEvent event) {
        try {

            Main.evp1.acceptEvent(eventIdAcceptEvent.getText());
//            eventStatus.setText(Main.evp1.showRequestedEvents());
            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
            messgaeBoxAcceptEvent.setText("Accepted Event.");
            messgaeBoxAcceptEvent.setVisible(true);
            messgaeBoxAcceptEvent.setStyle("-fx-background-color: #13ea31;-fx-alignment: center;-fx-font-size: 16;-fx-font-weight: bold; ");
            messgaeBoxAcceptEvent.setDisable(true);
            tableRefresh();
        } catch (Exception e) {
            messgaeBoxAcceptEvent.setText(e.getMessage());
            messgaeBoxAcceptEvent.setVisible(true);
            messgaeBoxAcceptEvent.setStyle("-fx-background-color: #FF5733 ;-fx-alignment: center;-fx-font-size: 16;-fx-font-weight: bold;");
            messgaeBoxAcceptEvent.setDisable(true);
//            eventStatus.setText(Main.evp1.showRequestedEvents());
//            eventStatus.setStyle("-fx-font-size:16;-fx-font-weight:bold;-fx-alignment: center");
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
    Button messgaeBoxTaskManage;

    public void manageTasks(ActionEvent event) {
        try {
            if (addTaskRadioBtn.isSelected()) {
                try {
                    Main.evp1.addEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText(), taskDescriptionTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task added successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                } catch (Exception e) {
//                    System.out.println(eventIdTaskManage.getText() + " " + taskTitleTaskManage.getText() + " " + taskDescriptionTaskManage.getText());
                    messgaeBoxTaskManage.setText(e.getMessage().toString());
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                }
                tableRefresh();
            } else if (startTaskRadioBtn.isSelected()) {
////                System.out.println("Star Task");
                try {
                    Main.evp1.startEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task start successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                } catch (Exception e) {
                    messgaeBoxTaskManage.setText(e.toString());
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                }
                tableRefresh();
            } else if (endTaskRadioBtn.isSelected()) {
////                System.out.println("End Btn");
                try {
                    Main.evp1.completeEventTask(eventIdTaskManage.getText(), taskTitleTaskManage.getText());
                    messgaeBoxTaskManage.setText("Task completed successfully.");
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#13ea31; -fx-font-weight: bold; -fx-font-size: 16;");
                } catch (Exception e) {
//                    System.out.println(e.toString());
                    messgaeBoxTaskManage.setText(e.getMessage().toString());
                    messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
                }
                tableRefresh();
            } else {
                messgaeBoxTaskManage.setText("Please select one of the following actions: Add task, Start task, End task.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
            }
        } catch (Exception e) {
            messgaeBoxTaskManage.setText(e.getMessage().toString());
            messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733");
        }
    }

    public void disableTaskDescription(ActionEvent event) {
        try {
            if(startTaskRadioBtn.isSelected() || endTaskRadioBtn.isSelected()) {
                taskDescriptionTaskManage.setDisable(true);
                messgaeBoxTaskManage.setText("Please enter correct event id and task title.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
            } else {
                taskDescriptionTaskManage.setDisable(false);
                messgaeBoxTaskManage.setText("Please enter correct event id.");
                messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
            }
        } catch (Exception e) {
            messgaeBoxTaskManage.setText("Please enter correct event id and task title.");
            messgaeBoxTaskManage.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
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
    @FXML
    Button messageBoxForAssignEventManager;

    public void assignEventManager(ActionEvent event) {
        try {
            Main.evp1.assignEventManager(eventIdAssignEventManager.getText(), managerNameAssignEventManager.getText());
            messageBoxForAssignEventManager.setText("Assign Event Manager");
            messageBoxForAssignEventManager.setStyle("-fx-background-color:#13ea31 ;-fx-font-weight: bold;-fx-font-size: 16");
            messageBoxForAssignEventManager.setDisable(true);
            messageBoxForAssignEventManager.setVisible(true);
            tableRefresh();

        } catch (Exception e) {
            messageBoxForAssignEventManager.setText(e.getMessage());
            messageBoxForAssignEventManager.setStyle("-fx-background-color:#FF5733;-fx-font-weight: bold;-fx-font-size: 16");
            messageBoxForAssignEventManager.setDisable(true);
            messageBoxForAssignEventManager.setVisible(true);
        }
    }

    //    Assign Event manager end


    // Table view for customer start
    @FXML
    TableView<TourPackage> eventTableViewForCustomer = new TableView<>();

    @FXML
    TableColumn<TourPackage, String> eventIdTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, String> eventTitleTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, LocalDate> eventDateTableViewForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, Integer> eventDurationDaysForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, Integer> perPersonPriceForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, Integer> eventNumOfParticipantsForCustomer = new TableColumn<>();

    @FXML
    TableColumn<TourPackage, String> totalRegisteredForCustomer = new TableColumn<>();

    // Table view for customer end


    //  Table view for employee start
    @FXML
    TableView<Event> eventTableViewForEmployee = new TableView<>();

    @FXML
    TableColumn<Event, String> eventIdTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> eventTitleTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, LocalDate> eventDateTableViewForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> eventDurationDaysForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> perPersonPriceForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, Integer> eventNumOfParticipantsForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, ArrayList<Task>> allTaskListForEmployee = new TableColumn<>();
    @FXML
    TableColumn<Event, String> eventManagerForEmployee = new TableColumn<>();

    //  Table view for employee end

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableRefresh();
    }


    public void tableRefresh() {
        try {
            System.out.println("table refresh called");
            if (Main.evp1.getEvents().size() < 1) {
                eventTableViewForCustomer.getItems().clear();
                eventTableViewForEmployee.getItems().clear();
            } else {
                eventTableViewForCustomer.getItems().clear();
                eventTableViewForEmployee.getItems().clear();
                for (Event e : Main.evp1.getEvents()) {
                    if (e instanceof TourPackage) {
                        eventTableViewForCustomer.getItems().add((TourPackage) e);
                        System.out.println(((TourPackage) e).getNumOfRegisteredParticipants());
                    }
                    eventTableViewForEmployee.getItems().add(e);
                }
            }

// Table view for customer start
            eventIdTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            eventTitleTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            eventDateTableViewForCustomer.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            eventDurationDaysForCustomer.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));
            perPersonPriceForCustomer.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            totalRegisteredForCustomer.setCellValueFactory(new PropertyValueFactory<>("numOfRegisteredParticipants"));
            eventNumOfParticipantsForCustomer.setCellValueFactory(new PropertyValueFactory<>("numOfParticipants"));
//            eventTableViewForCustomer.setItems(eventListForCustomer);
//  Table view for customer end

//  Table view for employee start
            eventTableViewForEmployee.setEditable(true);
            eventIdTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventId"));
            eventIdTableViewForEmployee.setEditable(false);

            eventTitleTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventTitle"));
            eventTitleTableViewForEmployee.setCellFactory(TextFieldTableCell.forTableColumn());
            eventTitleTableViewForEmployee.setEditable(true);

            eventDateTableViewForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventDate"));
            eventDurationDaysForEmployee.setCellValueFactory(new PropertyValueFactory<>("durationInDays"));

            perPersonPriceForEmployee.setCellValueFactory(new PropertyValueFactory<>("unitPrice"));
            perPersonPriceForEmployee.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            perPersonPriceForEmployee.setEditable(true);

            eventNumOfParticipantsForEmployee.setCellValueFactory(new PropertyValueFactory<>("numOfParticipants"));
            eventNumOfParticipantsForCustomer.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
            eventNumOfParticipantsForCustomer.setEditable(true);


            eventManagerForEmployee.setCellValueFactory(new PropertyValueFactory<>("eventManager"));
            eventManagerForEmployee.setCellFactory(TextFieldTableCell.forTableColumn());
            eventManagerForEmployee.setEditable(true);

            allTaskListForEmployee.setCellValueFactory(new PropertyValueFactory<>("tasks"));
//            eventListForEmployee.addAll(Main.evp1.getEvents());

            eventTitleTableViewForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, String> event) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setEventTitle(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }

            });

            perPersonPriceForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, Integer> event) -> {
                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setUnitPrice(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }
            });

            eventNumOfParticipantsForEmployee.setOnEditCommit((TableColumn.CellEditEvent<Event, Integer> event) -> {

                try {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Confirmation.");
                    alert.setContentText("Are you want to change the information?");
                    if (alert.showAndWait().get() == ButtonType.OK) {
                        event.getRowValue().setNumOfParticipants(event.getNewValue());
                    }
                } catch (Exception ex) {
//            System.out.println("Error in logOutBtn");
                }
            });


//  Table view for employee end

        } catch (Exception e) {
//            System.out.println("Error in initialize");
        }
    }
//    Aranna's code end

    public void searchForTourBtn(ActionEvent event) {
        try {
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
