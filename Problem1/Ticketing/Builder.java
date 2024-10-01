package Ticketing;
import Controller.*;
import InternetConnection.*;
import Display.*;
import Identification.*;
import Microcontroller.*;
import WebServer.*;
import Storage.*;

public interface Builder {
    void setMicrocontroller(Microcontroller microcontroller);

    void setDisplay(Display display);

    void setIdentification(Identification identification);

    void setPaymentTerminal(PaymentTerminal paymentTerminal);

    void setInternetConnection(InternetConnection internetConnection);

    void setStorage(Storage storage);

    void setController(Controller controller);

    void setWebServer(WebServer webServer);

    TicketingSystem build();
}
