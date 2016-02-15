package administrate;

import administrate.entity.User;
import administrate.service.UserService;
import administrate.service.impl.UserServiceImpl;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by USER on 15.02.2016.
 */
public class Table extends Application { /*docs.oracle.com/javafx/2/ui_controls/table-view.htm*/

    private UserService userService = new UserServiceImpl();
    private TableView table = new TableView();

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        final ObservableList<User> data = FXCollections.observableArrayList(userService.setUsers());

        Scene scene = new Scene(new Group());
        stage.setTitle("Table Simple");
        stage.setWidth(300);
        stage.setHeight(500);

        final Label label = new Label("Address Book");
        label.setFont(new Font("Arial",20));

        table.setEditable(false);

        TableColumn id = new TableColumn("Id");
        id.setCellValueFactory(new PropertyValueFactory<User,Long>("id"));
        TableColumn firstName = new TableColumn("First Name");
        firstName.setCellValueFactory(new PropertyValueFactory<User,String>("firstName"));
        TableColumn lastName = new TableColumn("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<User,String>("lastName"));

        table.setItems(data);
        table.getColumns().addAll(id,firstName,lastName);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10,0,0,10));
        vbox.getChildren().addAll(label,table);

        ((Group) scene.getRoot()).getChildren().addAll(vbox);

        stage.setScene(scene);
        stage.show();


    }
}
