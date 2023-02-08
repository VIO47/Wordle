package Client;

import Client.Scenes.*;
import com.google.inject.Guice;
import com.google.inject.Injector;
import java.io.IOException;
import java.net.URISyntaxException;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class of the client application.
 */
public class Main extends Application {

    private static final Injector INJECTOR = Guice.createInjector(new MyModule());
    private static final MyFXML FXML = new MyFXML(INJECTOR);

    /**
     * The start point of the client application.
     *
     * @param args the command line arguments passed to the application.
     * @throws URISyntaxException if a string could not be parsed as a URL reference.
     * @throws IOException        if an IOException occurred.
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
        launch();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void start(Stage primaryStage) throws IOException {
        var entry = FXML.load(EntryCtrl.class, "Client", "Scenes", "StartScene.fxml");
        var instructions = FXML.load(InstructionsCtrl.class, "Client", "Scenes", "InstructionsScene.fxml");
        var name = FXML.load(NameCtrl.class, "Client", "Scenes", "NameScene.fxml");

        primaryStage.setMinWidth(450);
        primaryStage.setMinHeight(600);

        var mainCtrl = INJECTOR.getInstance(MainCtrl.class);
        mainCtrl.initialize(primaryStage, entry, instructions, name);
    }
}

