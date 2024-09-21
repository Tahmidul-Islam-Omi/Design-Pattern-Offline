package Problem1;

import java.util.Scanner;

interface Microcontroller {
    String getDetails();
}

class ATMega32 implements Microcontroller {
    public String getDetails() {
        return "ATMega32 Microcontroller";
    }
}

class ArduinoMega implements Microcontroller {
    public String getDetails() {
        return "ArduinoMega Microcontroller";
    }
}

class RaspberryPi implements Microcontroller {
    public String getDetails() {
        return "RaspberryPi Microcontroller";
    }
}

// Display

interface Display {
    String getDetails();
}

class TouchScreen implements Display {
    public String getDetails() {
        return "TouchScreen Display";
    }
}

class OLED implements Display {
    public String getDetails() {
        return "OLED Display";
    }
}

class LED implements Display {
    public String getDetails() {
        return "LED Display";
    }
}

class LCD implements Display {
    public String getDetails() {
        return "LCD Display";
    }
}

interface Identification {
    String getDetails();
}

class RFID implements Identification {
    public String getDetails() {
        return "RFID Card Identification";
    }
}

class NFC implements Identification {
    public String getDetails() {
        return "NFC Card Identification";
    }
}

class PaymentTerminal {
    public String getDetails() {
        return "Payment Terminal";
    }
}

interface InternetConnection {
    String getDetails();
}

class WiFi implements InternetConnection {
    public String getDetails() {
        return "WiFi Connection";
    }
}

class GSM implements InternetConnection {
    public String getDetails() {
        return "GSM SIM Card Connection";
    }
}

class Ethernet implements InternetConnection {
    public String getDetails() {
        return "Ethernet Connection";
    }
}

interface Storage {
    String getDetails();
}

class SDCard implements Storage {
    public String getDetails() {
        return "SDCard Storage";
    }
}

class InternalStorage implements Storage {
    public String getDetails() {
        return "Internal Storage";
    }
}

interface Controller {
    String getDetails();
}

class TouchScreenController implements Controller {
    public String getDetails() {
        return "TouchScreen Controller";
    }
}

class ExternalController implements Controller {
    public String getDetails() {
        return "External Controller";
    }
}

interface WebServer {
    String getDetails();
}

class Django implements WebServer {
    public String getDetails() {
        return "Django WebServer";
    }
}

class NodeJS implements WebServer {
    public String getDetails() {
        return "NodeJS WebServer";
    }
}

class Ruby implements WebServer {
    public String getDetails() {
        return "Ruby WebServer";
    }
}

interface Builder {
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

class TicketingSystemBuilder implements Builder {
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

class TicketingSystem {
    private Microcontroller microcontroller;
    private Display display;
    private Identification identification;
    private PaymentTerminal paymentTerminal;
    private InternetConnection internetConnection;
    private Storage storage;
    private Controller controller;
    private WebServer webServer;

    public TicketingSystem(Microcontroller microcontroller, Display display, Identification identification,
            PaymentTerminal paymentTerminal, InternetConnection internetConnection, Storage storage,
            Controller controller, WebServer webServer) {
        this.microcontroller = microcontroller;
        this.display = display;
        this.identification = identification;
        this.paymentTerminal = paymentTerminal;
        this.internetConnection = internetConnection;
        this.storage = storage;
        this.controller = controller;
        this.webServer = webServer;
    }

    public String getDetails() {
        return "Ticketing System with " + microcontroller.getDetails() + ", " + display.getDetails() + ", "
                + identification.getDetails() + ", " + paymentTerminal.getDetails() + ", "
                + internetConnection.getDetails() + ", " + storage.getDetails() + ", " + controller.getDetails() + ", "
                + webServer;
    }
}

interface Package {
    String getDetails();
}

class BasicPackage implements Package {
    Builder builder;

    public BasicPackage(InternetConnection internetConnection, WebServer webServer) {
        builder = new TicketingSystemBuilder();
        builder.setMicrocontroller(new ATMega32());
        builder.setDisplay(new LCD());
        builder.setIdentification(new RFID());
        builder.setPaymentTerminal(new PaymentTerminal());
        builder.setInternetConnection(internetConnection);
        builder.setStorage(new SDCard());
        builder.setController(new ExternalController());
        builder.setWebServer(webServer);
    }

    public String getDetails() {
        return "Basic Package with " + builder.build().getDetails();
    }

}

class StandardPackage implements Package {
    Builder builder;

    public StandardPackage(InternetConnection internetConnection, WebServer webServer) {
        builder = new TicketingSystemBuilder();
        builder.setMicrocontroller(new ATMega32());
        builder.setDisplay(new LCD());
        builder.setIdentification(new RFID());
        builder.setPaymentTerminal(new PaymentTerminal());
        builder.setInternetConnection(internetConnection);
        builder.setStorage(new SDCard());
        builder.setController(new ExternalController());
        builder.setWebServer(webServer);
    }

    public String getDetails() {
        return "Standard Package with " + builder.build().getDetails();
    }

}

class AdvancedPackage implements Package {
    Builder builder;

    public AdvancedPackage(InternetConnection internetConnection, WebServer webServer) {
        builder = new TicketingSystemBuilder();
        builder.setMicrocontroller(new ATMega32());
        builder.setDisplay(new LCD());
        builder.setIdentification(new RFID());
        builder.setPaymentTerminal(new PaymentTerminal());
        builder.setInternetConnection(internetConnection);
        builder.setStorage(new SDCard());
        builder.setController(new ExternalController());
        builder.setWebServer(webServer);
    }

    public String getDetails() {
        return "Advanced Package with " + builder.build().getDetails();
    }

}

class PremiumPackage implements Package {
    Builder builder;

    public PremiumPackage(InternetConnection internetConnection, WebServer webServer) {
        builder = new TicketingSystemBuilder();
        builder.setMicrocontroller(new ATMega32());
        builder.setDisplay(new LCD());
        builder.setIdentification(new RFID());
        builder.setPaymentTerminal(new PaymentTerminal());
        builder.setInternetConnection(internetConnection);
        builder.setStorage(new SDCard());
        builder.setController(new ExternalController());
        builder.setWebServer(webServer);
    }

    public String getDetails() {
        return "Premium Package with " + builder.build().getDetails();
    }

}

class PackageFactory {
    public static Package createPackage(String packageType, InternetConnection internetConnection,
            WebServer webServer) {
        switch (packageType) {
            case "Basic":
                return new BasicPackage(internetConnection, webServer);
            case "Standard":
                return new StandardPackage(internetConnection, webServer);
            case "Advanced":
                return new AdvancedPackage(internetConnection, webServer);
            case "Premium":
                return new PremiumPackage(internetConnection, webServer);
            default:
                return null;
        }
    }
}

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a package (Basic, Standard, Advanced, Premium): ");
        String packageType = scanner.nextLine();

        System.out.println("Choose internet connection type (WiFi, Ethernet, SIM card): ");
        String connectionType = scanner.nextLine();

        InternetConnection internetConnection = null;

        switch (connectionType) {
            case "WiFi":
                internetConnection = new WiFi();
                break;
            case "Ethernet":
                internetConnection = new Ethernet();
                break;
            case "SIM card":
                internetConnection = new GSM();
                break;
            default:
                System.out.println("Invalid connection type");
                return;
        }

        System.out.println("Choose a web server framework (Django, NodeJS, Ruby): ");
        String webServerFramework = scanner.nextLine();

        WebServer webServer = null;

        switch (webServerFramework) {
            case "Django":
                webServer = new Django();
                break;
            case "NodeJS":
                webServer = new NodeJS();
                break;
            case "Ruby":
                webServer = new Ruby();
                break;
            default:
                System.out.println("Not Available");
                return;
        }

        Package selectedPackage = PackageFactory.createPackage(packageType, internetConnection, webServer);

        if (selectedPackage == null) {
            System.out.println("Invalid package type");
            return;
        }

        System.out.println("Package Details:");
        selectedPackage.getDetails();
    }
}
