package application;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
public class Main extends Application {
	private double x, y;

	@Override
	public void start(Stage primaryStage) {
		try {

			FXMLLoader loader = new FXMLLoader(getClass().getResource("widget.fxml"));
			Parent root = loader.load();
			primaryStage.iconifiedProperty().addListener((obs, wasIconified, isNowIconfied) ->{
				if(isNowIconfied) {
					Platform.exit();
				}
			});
//			root.setOnMousePressed(event1 -> {
//				x = event1.getSceneX();
//				y = event1.getSceneY();
//			});
//			root.setOnMouseDragged(event2 -> {
//				primaryStage.setX(event2.getScreenX() - x);
//				primaryStage.setY(event2.getScreenY() - y);
//			});
//			root.setOnMouseReleased(event3->{
//				System.out.println(event3.getSceneX());
//				System.out.println(event3.getSceneY());
//			});
			Scene scene = new Scene(root,Color.TRANSPARENT);
//			Scene scene = new Scene(root);
			Image icon = new Image("/resources/logo.png");
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.initStyle(StageStyle.TRANSPARENT);
			primaryStage.setX(460.4);
			primaryStage.setY(80.6);
			primaryStage.getIcons().add(icon);
			primaryStage.setScene(scene);
			primaryStage.setTitle("Custom Time Widget");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
