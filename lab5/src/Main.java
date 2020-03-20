import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import nodes.FirstNode;
import nodes.SecondNode;


@SuppressWarnings("FieldCanBeLocal")
public class Main extends Application {
    private TabPane tabPane;

    private HBox firstNode;
    private HBox secondNode;

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.centerOnScreen();
        stage.setTitle("Регулярные выражения");

        firstNode = new FirstNode();
        firstNode.setAlignment(Pos.CENTER);

        secondNode = new SecondNode();
        secondNode.setAlignment(Pos.CENTER);

        tabPane = new TabPane(new Tab("First", firstNode), new Tab("Second", secondNode));

        stage.setScene(new Scene(tabPane, 400, 400));

        stage.show();
    }
}
