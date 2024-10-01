package Ticketing;
import Controller.*;
import InternetConnection.*;
import Display.*;
import Identification.*;
import Microcontroller.*;
import WebServer.*;
import Storage.*;

public class TicketingSystemBuilder implements Builder {
    private Microcontroller microcontroller;
    private Display display;
    private Identification identification;
    private PaymentTerminal paymentTerminal;
    private InternetConnection internetConnection;
    private Storage storage;
    private Controller controller;
    private WebServer webServer;

    public void setMicrocontroller(Microcontroller microcontroller) {
        this.microcontroller = microcontroller;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setIdentification(Identification identification) {
        this.identification = identification;
    }

    public void setPaymentTerminal(PaymentTerminal paymentTerminal) {
        this.paymentTerminal = paymentTerminal;
    }

    public void setInternetConnection(InternetConnection internetConnection) {
        this.internetConnection = internetConnection;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setWebServer(WebServer webServer) {
        this.webServer = webServer;
    }

    public TicketingSystem build() {
        return new TicketingSystem(microcontroller, display, identification, paymentTerminal, internetConnection,
                storage, controller, webServer);
    }
}
