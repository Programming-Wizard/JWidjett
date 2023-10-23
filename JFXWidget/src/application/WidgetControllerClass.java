package application;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class WidgetControllerClass implements Initializable {
	@FXML
	private Text date_time_text;
	@FXML
	private Text day;
	@FXML
	private Text time;
	LocalDateTime currentDateTime = LocalDateTime.now();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Font customFont = Font.loadFont(getClass().getResourceAsStream("/resources/Anurati-Regular.otf"), 60);
		day.setFont(customFont);

		date_time_text.setText(getDate());
		day.setText(getCurrentDay());
		date_time_text.setFill(Color.WHITE);
		day.setFill(Color.WHITE);
		time.setFill(Color.WHITE);

		Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> updateTime()));
		timeline.setCycleCount(Timeline.INDEFINITE);
		timeline.play();
	}

	private String getDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM, yyyy .");
		String date = currentDateTime.format(formatter);
		return date;
	}

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("- HH : mm : ss -");

	private void updateTime() {
		LocalDateTime currentDateTime = LocalDateTime.now();
		String Time = currentDateTime.format(formatter);
		time.setText(Time);
	}

	private String getCurrentDay() {
		String currentDay = "";
		DayOfWeek dayOfWeek = currentDateTime.getDayOfWeek();
		for (int i = 0; i < dayOfWeek.toString().length(); i++) {
			currentDay = currentDay + dayOfWeek.toString().charAt(i) + " ";
		}
		return currentDay;
	}
}
