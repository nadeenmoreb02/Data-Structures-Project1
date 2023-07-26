package application;

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class Main extends Application {
	Scene menuScene, flightsScene;
	LinkedList passengersLL = new LinkedList();
	LinkedList flightsLL = new LinkedList();

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();

			Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();

			VBox vb1 = new VBox(10);

			Text welcome1 = new Text("WELCOME TO THE INTERNATIONAL");
			welcome1.setFont(new Font("Arial", 30));
			welcome1.setFill(Color.WHITE);
			welcome1.setStyle("-fx-font-size:30px; -fx-font-weight:bold; -fx-font-family:Lucida Sans Unicode");

			Text welcome2 = new Text(" AIRLINES GROUP");
			welcome2.setFont(new Font("Arial", 30));
			welcome2.setFill(Color.WHITE);
			welcome2.setStyle("-fx-font-size:30px; -fx-font-weight:bold; -fx-font-family:Lucida Sans Unicode");

			vb1.getChildren().addAll(welcome1, welcome2);
			root.setLeft(vb1);
			vb1.setAlignment(Pos.CENTER_LEFT);
			vb1.setPadding(new Insets(0, 0, 0, 50));

			// menu
			VBox vb2 = new VBox(10);
			Button menu = new Button();
			menu.setStyle("-fx-background-color:Transparent; ");
			menu.setPrefSize(50, 50);
			Image img = new Image("file:menu-three-outlined-rounded-lines-symbol_icon-icons.com_73215.png");
			ImageView imgV = new ImageView(img);
			imgV.setPreserveRatio(true);
			imgV.setFitWidth(50);
			imgV.setFitHeight(50);
			imgV.setPreserveRatio(true);
			menu.setGraphic(imgV);

			menu.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					menu.setStyle("-fx-background-color:LIGHTYELLOW; ");
				}
			});
			menu.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					menu.setStyle("-fx-background-color:Transparent; ");
				}
			});

			vb2.getChildren().addAll(menu);
			root.setRight(vb2);
			vb2.setLayoutX(100);
			vb2.setLayoutY(0);
			vb2.setAlignment(Pos.BASELINE_CENTER);
			vb2.setPadding(new Insets(100, 100, 0, 50));

			//
			GaussianBlur g = new GaussianBlur();
			HBox pane = new HBox();
			pane.setMinSize(50, 50);
			pane.setEffect(g);
			pane.setStyle("-fx-background-image:  url('file:bafe7add5c6f62d293a1cbc1a5e4408e.gif')");
			pane.setAlignment(Pos.CENTER);
			root.setCenter(pane);

			//
			HBox hb1 = new HBox();
			hb1.setPrefSize(800, 50);

			// display all flights button
			Button flights = new Button("");
			flights.setStyle("-fx-background-color:Transparent; ");
			flights.setPrefSize(50, 50);
			Image flightImg = new Image("file:airplane-departure_icon-icons.com_55634.png");
			ImageView flightImgV = new ImageView(flightImg);
			flightImgV.setPreserveRatio(true);
			flightImgV.setFitWidth(100);
			flightImgV.setFitHeight(100);
			flightImgV.setPreserveRatio(true);
			flights.setGraphic(flightImgV);
			hb1.setAlignment(Pos.BOTTOM_CENTER);
			vb1.getChildren().add(hb1);
			hb1.getChildren().addAll(flights);

			flights.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					flights.setStyle("-fx-background-color:LIGHTYELLOW; ");
				}
			});
			flights.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					flights.setStyle("-fx-background-color:Transparent; ");
				}
			});

			// background
			Image rootImg = new Image("file:wallpapersden.com_airport-waiting-man_1920x1080.jpg");
			BackgroundImage rootBImg = new BackgroundImage(rootImg, BackgroundRepeat.NO_REPEAT,
					BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
			Background rootBGround = new Background(rootBImg);
			root.setBackground(rootBGround);

//MENU SCENE
			BorderPane menuPane = new BorderPane();
			menuPane.setBackground(rootBGround);
			VBox menuVB = new VBox(10);

			Label Menu = new Label("Menu");
			Menu.setStyle(
					"-fx-font-size:35px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif';-fx-font-weight:bold;");
			Menu.setTextFill(Color.WHITE);

			// exit Button in menu scene
			Button exit = new Button();
			Image eimg = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgV = new ImageView(eimg);
			eimgV.setPreserveRatio(true);
			eimgV.setFitWidth(50);
			eimgV.setFitHeight(50);
			eimgV.setPreserveRatio(true);
			exit.setGraphic(eimgV);
			exit.setStyle("-fx-background-color: Transparent;");
			exit.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exit.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exit.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exit.setStyle("-fx-background-color:Transparent; ");
				}
			});

			HBox hb2 = new HBox(60);
			hb2.getChildren().addAll(exit, Menu);

			// home button in menu scene
			Button home = new Button();
			Image himg = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgV = new ImageView(himg);
			himgV.setPreserveRatio(true);
			himgV.setFitWidth(50);
			himgV.setFitHeight(50);
			himgV.setPreserveRatio(true);
			home.setGraphic(himgV);
			home.setStyle("-fx-background-color: Transparent;");
			home.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					home.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			home.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					home.setStyle("-fx-background-color:Transparent; ");
				}
			});

			VBox vb4 = new VBox(20);
			vb4.getChildren().addAll(hb2, home);
			vb4.setAlignment(Pos.TOP_LEFT);
			menuPane.setLeft(vb4);
			vb4.setPadding(new Insets(20, 0, 0, 20));

			//
			Button read = new Button("Read Data");
			read.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif';");
			read.setTextFill(Color.WHITE);
			read.setOnMouseMoved(event -> {
				read.setTextFill(Color.BROWN);
			});
			read.setOnMouseExited(event -> {
				read.setTextFill(Color.WHITE);
			});

			// read scene
			BorderPane readPane = new BorderPane();
			readPane.setBackground(rootBGround);
			VBox readVb = new VBox(50);
			Label readLabel = new Label();
			readLabel.setStyle("-fx-font-size:30;");
			TextArea readArea = new TextArea();
			readArea.setPrefWidth(50);
			readVb.getChildren().addAll(readLabel, readArea);
			readVb.setAlignment(Pos.CENTER);
			readVb.setPadding(new Insets(0, 150, 0, 150));
			readPane.setCenter(readVb);
			Scene readScene = new Scene(readPane, screenSize.getWidth(), screenSize.getHeight());

			// exit button in read scene
			Button exitRead = new Button();
			Image eimgRead = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVRead = new ImageView(eimgRead);
			eimgVRead.setPreserveRatio(true);
			eimgVRead.setFitWidth(50);
			eimgVRead.setFitHeight(50);
			eimgVRead.setPreserveRatio(true);
			exitRead.setGraphic(eimgVRead);
			exitRead.setStyle("-fx-background-color: Transparent;");
			exitRead.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitRead.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitRead.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitRead.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in read scene
			Button homeRead = new Button();
			Image himgRead = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVRead = new ImageView(himgRead);
			himgVRead.setPreserveRatio(true);
			himgVRead.setFitWidth(50);
			himgVRead.setFitHeight(50);
			himgVRead.setPreserveRatio(true);
			homeRead.setGraphic(himgVRead);
			homeRead.setStyle("-fx-background-color: Transparent;");
			homeRead.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeRead.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homeRead.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeRead.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox readVb1 = new VBox(20);
			readVb1.getChildren().addAll(exitRead, homeRead);
			readPane.setLeft(readVb1);
			readVb1.setPadding(new Insets(20, 0, 0, 20));

			read.setOnAction(e -> {
				// create a File chooser
				FileChooser fil_chooser = new FileChooser();
				File file = fil_chooser.showOpenDialog(primaryStage);

				if (file != null) {

					// label.setText(file.getAbsolutePath()
					// get the file selected
					System.out.println(file.getAbsolutePath() + "  selected");
					if (file.getAbsolutePath().indexOf("passengers") > 0) {
						readLabel.setText("Passengers file is selected!");

					}
					if (file.getAbsolutePath().indexOf("Flights") > 0) {
						readLabel.setText("Flights file is selected!");
					}
					Scanner readLines;
					String printInfo = new String("");
					try {
						readLines = new Scanner(file);
						while (readLines.hasNext()) {
							String line = readLines.nextLine();
							printInfo += line + "\n";
							String[] arr = line.split(",");
							if (file.getAbsolutePath().indexOf("Flights") > 0) {
								int number = Integer.parseInt(arr[0]);
								int capacity = Integer.parseInt(arr[4]);
								Flight flight = new Flight(number, arr[1], arr[2], arr[3], capacity);
								flightsLL.insertAtLastFlight(flight);

							}
							if (file.getAbsolutePath().indexOf("passengers") > 0) {
								String[] dateString = arr[5].split("/");
								int dd = Integer.parseInt(dateString[0]);
								int mm = Integer.parseInt(dateString[1]);
								int yy = Integer.parseInt(dateString[2]);
								Passenger passenger = new Passenger(Integer.parseInt(arr[0]), Integer.parseInt(arr[1]),
										arr[2], arr[3], arr[4], new Date(dd, mm, yy));
								passengersLL.insertAtLastPass(passenger);
							}
						}

						flightsLL.sortFList();
						passengersLL.sortPList();
						passengersLL.printPassList();
						flightsLL.printFlightList();
						readLines.close();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					primaryStage.setScene(readScene);
					readArea.setText(printInfo);

				}

			});

			Button fDisplay = new Button("Display Flights' Information");
			fDisplay.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			fDisplay.setTextFill(Color.WHITE);
			fDisplay.setOnMouseMoved(event -> {
				fDisplay.setTextFill(Color.BROWN);
			});
			fDisplay.setOnMouseExited(event -> {
				fDisplay.setTextFill(Color.WHITE);
			});

			// flights display scene
			BorderPane displayPane = new BorderPane();
			displayPane.setBackground(rootBGround);
			VBox displayVb = new VBox(50);
			Label displayLabel = new Label("Flights");
			displayLabel.setStyle("-fx-font-size:30;");
			TextArea displayArea = new TextArea();
			displayArea.setPrefWidth(50);
			displayVb.getChildren().addAll(displayLabel, displayArea);
			displayVb.setAlignment(Pos.CENTER);
			displayVb.setPadding(new Insets(0, 150, 0, 150));
			displayPane.setCenter(displayVb);
			Scene displayScene = new Scene(displayPane, screenSize.getWidth(), screenSize.getHeight());

			Button exitdisplay = new Button();
			Image eimgdisplay = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVdisplay = new ImageView(eimgdisplay);
			eimgVdisplay.setPreserveRatio(true);
			eimgVdisplay.setFitWidth(50);
			eimgVdisplay.setFitHeight(50);
			eimgVdisplay.setPreserveRatio(true);
			exitdisplay.setGraphic(eimgVdisplay);
			exitdisplay.setStyle("-fx-background-color: Transparent;");
			exitdisplay.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitdisplay.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitdisplay.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitdisplay.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in display flights scene
			Button homedisplay = new Button();
			Image himgdisplay = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVdisplay = new ImageView(himgdisplay);
			himgVdisplay.setPreserveRatio(true);
			himgVdisplay.setFitWidth(50);
			himgVdisplay.setFitHeight(50);
			himgVdisplay.setPreserveRatio(true);
			homedisplay.setGraphic(himgVdisplay);
			homedisplay.setStyle("-fx-background-color: Transparent;");
			homedisplay.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homedisplay.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homedisplay.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homedisplay.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox displayVb1 = new VBox(20);
			displayVb1.getChildren().addAll(exitdisplay, homedisplay);
			displayPane.setLeft(displayVb1);
			displayVb1.setPadding(new Insets(20, 0, 0, 20));

			fDisplay.setOnAction(e -> {
				primaryStage.setScene(displayScene);
				displayArea.setText(flightsLL.returnFlightList());
			});

			Button pDisplay = new Button("Display Passengers' Information");
			pDisplay.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			pDisplay.setTextFill(Color.WHITE);
			pDisplay.setOnMouseMoved(event -> {
				pDisplay.setTextFill(Color.BROWN);
			});
			pDisplay.setOnMouseExited(event -> {
				pDisplay.setTextFill(Color.WHITE);
			});

			// Display Passengers of a specific flight scene
			BorderPane passDisplayPane = new BorderPane();
			passDisplayPane.setBackground(rootBGround);
			VBox PDisplayVb = new VBox(30);
			Label PDisplayLabel = new Label("Enter Flight Number to Display Its Passengers:");
			PDisplayLabel.setStyle("-fx-font-size:27;");
			HBox PDisplayHb = new HBox(10);
			TextField PDisplayTf = new TextField();
			PDisplayTf.setPrefHeight(30);
			PDisplayTf.setPrefWidth(300);
			PDisplayTf.setPromptText("Type in Flight Number Here");
			Button displayButton = new Button("Display");
			displayButton.setPrefHeight(30);
			// displayButton.setStyle("-fx-background-color: Transparent;");
			displayButton.setStyle("-fx-font-weight: bold;");
			PDisplayHb.getChildren().addAll(PDisplayTf, displayButton);
			TextArea pDisplayArea = new TextArea();
			PDisplayVb.getChildren().addAll(PDisplayLabel, PDisplayHb, pDisplayArea);
			PDisplayVb.setAlignment(Pos.CENTER);
			passDisplayPane.setCenter(PDisplayVb);
			PDisplayVb.setPadding(new Insets(0, 200, 0, 200));

			// main function of this button
			displayButton.setOnAction(e -> {
				try {
					int num = Integer.parseInt(PDisplayTf.getText());
					String printPass = passengersLL.printSpecificFlightPass(num);
					if (printPass == "") {
						pDisplayArea.setText("flight not found or empty");
					} else
						pDisplayArea.setText(printPass);
				} catch (NumberFormatException ex) {
					System.out.println("User input was not a number.");
					pDisplayArea.setText("User input was not a number.");
				} catch (Exception ex) {
					System.out.println("flight not found or empty");
					pDisplayArea.setText("flight not found or empty");

				}
			});

			Scene pDisplayScene = new Scene(passDisplayPane, screenSize.getWidth(), screenSize.getHeight());
			pDisplay.setOnAction(e -> primaryStage.setScene(pDisplayScene));

			Button exitPdisplay = new Button();
			Image eimgPdisplay = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVPdisplay = new ImageView(eimgPdisplay);
			eimgVPdisplay.setPreserveRatio(true);
			eimgVPdisplay.setFitWidth(50);
			eimgVPdisplay.setFitHeight(50);
			eimgVPdisplay.setPreserveRatio(true);
			exitPdisplay.setGraphic(eimgVPdisplay);
			exitPdisplay.setStyle("-fx-background-color: Transparent;");
			exitPdisplay.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitPdisplay.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitPdisplay.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitPdisplay.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in display passengers scene
			Button homePdisplay = new Button();
			Image himgPdisplay = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVPdisplay = new ImageView(himgPdisplay);
			himgVPdisplay.setPreserveRatio(true);
			himgVPdisplay.setFitWidth(50);
			himgVPdisplay.setFitHeight(50);
			himgVPdisplay.setPreserveRatio(true);
			homePdisplay.setGraphic(himgVPdisplay);
			homePdisplay.setStyle("-fx-background-color: Transparent;");
			homePdisplay.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homePdisplay.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homePdisplay.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homePdisplay.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox pDisplayVb1 = new VBox(20);
			pDisplayVb1.getChildren().addAll(exitPdisplay, homePdisplay);
			passDisplayPane.setLeft(pDisplayVb1);
			pDisplayVb1.setPadding(new Insets(20, 0, 0, 20));

			//
			Button add = new Button("Add/Edit Flight");
			add.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			add.setTextFill(Color.WHITE);
			add.setOnMouseMoved(event -> {
				add.setTextFill(Color.BROWN);
			});
			add.setOnMouseExited(event -> {
				add.setTextFill(Color.WHITE);
			});

			// add/edit Scene
			BorderPane editPane = new BorderPane();
			editPane.setBackground(rootBGround);

			VBox editVb = new VBox(40);

			HBox editHb = new HBox(10);
			Label editLbl = new Label("Flight Number:");
			editLbl.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			TextField editTf = new TextField();
			editTf.setPromptText("Type Flight Number Here");
			editTf.setPrefHeight(30);
			editTf.setPrefWidth(300);

			Button editFind = new Button("Find");
			editFind.setStyle("-fx-font-weight: bold;");

			editHb.getChildren().addAll(editLbl, editTf, editFind);

			TextArea editTa = new TextArea();

			Label editLbl1 = new Label("Number:");
			editLbl1.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label editLbl2 = new Label("Name:");
			editLbl2.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label editLbl3 = new Label("Source:");
			editLbl3.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label editLbl4 = new Label("Destination:");
			editLbl4.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label editLbl5 = new Label("Capacity:");
			editLbl5.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");

			VBox editlblVb = new VBox(8);
			editlblVb.getChildren().addAll(editLbl1, editLbl2, editLbl3, editLbl4, editLbl5);

			TextField editTf1 = new TextField();
			editTf1.setPromptText("Enter Flight Number");
			TextField editTf2 = new TextField();
			editTf2.setPromptText("Enter Flight Name");
			TextField editTf3 = new TextField();
			editTf3.setPromptText("Enter Flight Source");
			TextField editTf4 = new TextField();
			editTf4.setPromptText("Enter Flight Destination");
			TextField editTf5 = new TextField();
			editTf5.setPromptText("Enter Capacity");

			if (editTa.getText() == "User input was not a number." || editTa.getText() == null
					|| editTa.getText().isEmpty()) {
				editTf1.setDisable(true);
				editTf2.setDisable(true);
				editTf3.setDisable(true);
				editTf4.setDisable(true);
				editTf5.setDisable(true);
			}

			editFind.setOnAction(e -> {
				try {
					int userNumber = Integer.parseInt(editTf.getText());
					if (flightsLL.searchFlight(userNumber) == null) {
						editTa.setText("Flight Not Found");
					} else {
						editTa.setText(flightsLL.searchFlight(userNumber).toString());
					}

					if (editTa.getText() != "User input was not a number." && editTa.getText() != null) {

						editTf1.setDisable(false);
						editTf2.setDisable(false);
						editTf3.setDisable(false);
						editTf4.setDisable(false);
						editTf5.setDisable(false);

					}

				} catch (NumberFormatException ex) {
					System.out.println("User input was not a number.");
					editTa.setText("User input was not a number.");
					editTf1.setDisable(true);
					editTf2.setDisable(true);
					editTf3.setDisable(true);
					editTf4.setDisable(true);
					editTf5.setDisable(true);
				} catch (NullPointerException ex) {
					System.out.println("Flight Not Found");
					editTa.setText("Flight Not Found");
					editTf1.setDisable(false);
					editTf2.setDisable(false);
					editTf3.setDisable(false);
					editTf4.setDisable(false);
					editTf5.setDisable(false);
				}
			});

			VBox editTfVb = new VBox(5);
			editTfVb.getChildren().addAll(editTf1, editTf2, editTf3, editTf4, editTf5);

			HBox editHb2 = new HBox(10);
			editHb2.getChildren().addAll(editlblVb, editTfVb);

			Button editSubmit = new Button("Submit");
			editSubmit.setStyle("-fx-font-weight: bold;");

			editSubmit.setOnAction(e -> {
				try {
					int number = Integer.parseInt(editTf1.getText());
					String name = editTf2.getText();
					String source = editTf3.getText();
					String destination = editTf4.getText();
					int capacity = Integer.parseInt(editTf5.getText());
					Flight editFlight = new Flight(number, name, source, destination, capacity);
					try {
						flightsLL.editFlight(Integer.parseInt(editTf.getText()), editFlight);
						passengersLL.editFlightNumberInPassengers(Integer.parseInt(editTf.getText()), number);
					} catch (Exception ex) {
						System.out.println("User input was not a number.");
					}
					flightsLL.sortFList();
				} catch (Exception x) {
					System.out.println("Somethig Went Wrong");
				}

			});

			editVb.getChildren().addAll(editHb, editTa, editHb2, editSubmit);

			editVb.setAlignment(Pos.CENTER);
			editPane.setCenter(editVb);
			editVb.setPadding(new Insets(0, 350, 0, 350));

			Scene editScene = new Scene(editPane, screenSize.getWidth(), screenSize.getHeight());

			add.setOnAction(e -> primaryStage.setScene(editScene));

			// exit button in add/edit scene

			Button exitAdd = new Button();
			Image eimgAdd = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVAdd = new ImageView(eimgAdd);
			eimgVAdd.setPreserveRatio(true);
			eimgVAdd.setFitWidth(50);
			eimgVAdd.setFitHeight(50);
			eimgVAdd.setPreserveRatio(true);
			exitAdd.setGraphic(eimgVAdd);
			exitAdd.setStyle("-fx-background-color: Transparent;");
			exitAdd.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitAdd.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitAdd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitAdd.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in edit/add scene
			Button homeAdd = new Button();
			Image himgAdd = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVAdd = new ImageView(himgAdd);
			himgVAdd.setPreserveRatio(true);
			himgVAdd.setFitWidth(50);
			himgVAdd.setFitHeight(50);
			himgVAdd.setPreserveRatio(true);
			homeAdd.setGraphic(himgVAdd);
			homeAdd.setStyle("-fx-background-color: Transparent;");
			homeAdd.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeAdd.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homeAdd.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeAdd.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox addVb2 = new VBox(20);
			addVb2.getChildren().addAll(exitAdd, homeAdd);
			editPane.setLeft(addVb2);
			addVb2.setPadding(new Insets(20, 0, 0, 20));

			//
			Button reserve = new Button("Reserve a Ticket");
			reserve.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			reserve.setTextFill(Color.WHITE);
			reserve.setOnMouseMoved(event -> {
				reserve.setTextFill(Color.BROWN);
			});
			reserve.setOnMouseExited(event -> {
				reserve.setTextFill(Color.WHITE);
			});

			// reserve scene
			BorderPane reservePane = new BorderPane();
			reservePane.setBackground(rootBGround);

			VBox reserveVb1 = new VBox(40);
			VBox reserveVb2 = new VBox(30);
			HBox reserveHb = new HBox(20);
			VBox reserveVb3 = new VBox();

			Label reserveLb1 = new Label("Flight Number:");
			reserveLb1.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label reserveLb2 = new Label("Ticket Number:");
			reserveLb2.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label reserveLb3 = new Label("Full Name:");
			reserveLb3.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label reserveLb4 = new Label("Passport:");
			reserveLb4.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label reserveLb5 = new Label("Nationality:");
			reserveLb5.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label reserveLb6 = new Label("Birth Date:");
			reserveLb6.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			try {
				reserveVb1.getChildren().addAll(reserveLb1, reserveLb2, reserveLb3, reserveLb4, reserveLb5, reserveLb6);
			} catch (NullPointerException f) {
				System.out.println("error: null pointer");
			}
			TextField reserveTf1 = new TextField();
			reserveTf1.setPromptText("Type in Flight Number");
			reserveTf1.setPrefHeight(30);
			reserveTf1.setStyle("-fx-font-size:15;");
			TextField reserveTf2 = new TextField();
			reserveTf2.setPromptText("Flight Number is generated");
			reserveTf2.setPrefHeight(30);
			reserveTf2.setStyle("-fx-font-size:15;");
			TextField reserveTf3 = new TextField();
			reserveTf3.setPromptText("Type in Full Name");
			reserveTf3.setPrefHeight(30);
			reserveTf3.setStyle("-fx-font-size:15;");
			TextField reserveTf4 = new TextField();
			reserveTf4.setPromptText("Type in Passport Number");
			reserveTf4.setPrefHeight(30);
			reserveTf4.setStyle("-fx-font-size:15;");
			TextField reserveTf5 = new TextField();
			reserveTf5.setPromptText("Type in Nationality");
			reserveTf5.setPrefHeight(30);
			reserveTf5.setStyle("-fx-font-size:15;");
			DatePicker reserveTf6 = new DatePicker();
			reserveTf6.setPromptText("Set Birth Date");
			reserveTf6.setPrefHeight(30);
			reserveTf6.setStyle("-fx-font-size:15;");

			Button reserveButton = new Button("reserve now!");
			reserveButton.setPrefHeight(40);
			reserveButton.setStyle("-fx-font-weight:bold;");
			reserveButton.setOnAction(e -> {
				try {
					int fNumberRes = Integer.parseInt(reserveTf1.getText());
					if (passengersLL.checkCapacity(fNumberRes, passengersLL, flightsLL)) {
						reserveTf2.setText("" + passengersLL.reserveTicket(fNumberRes));
					}
					String resName = reserveTf3.getText();
					String resPassport = reserveTf4.getText();
					String resNationality = reserveTf5.getText();
					String resDate = "" + reserveTf6.getValue();
					String[] resDateArr = resDate.split("-");
					int resDay = Integer.parseInt(resDateArr[2]);
					int resMonth = Integer.parseInt(resDateArr[1]);
					int resYear = Integer.parseInt(resDateArr[0]);
					Passenger resPassenger = new Passenger(fNumberRes, passengersLL.reserveTicket(fNumberRes), resName,
							resPassport, resNationality, new Date(resDay, resMonth, resYear));
					passengersLL.insertAtLastPass(resPassenger);
					passengersLL.sortPList();

				} catch (NumberFormatException v) {
					System.out.println("This Was Not a Number");
				} catch (Exception v) {
					System.out.println("Flight Not Found");
				}
			});

			reserveVb2.getChildren().addAll(reserveTf1, reserveTf2, reserveTf3, reserveTf4, reserveTf5, reserveTf6,
					reserveButton);

			reserveHb.getChildren().addAll(reserveVb1, reserveVb2);

			reserveVb3.getChildren().add(reserveHb);

			reserveVb3.setAlignment(Pos.CENTER);
			reservePane.setCenter(reserveVb3);
			reserveVb3.setPadding(new Insets(0, 350, 0, 350));

			Scene reserveScene = new Scene(reservePane, screenSize.getWidth(), screenSize.getHeight());

			reserve.setOnAction(e -> primaryStage.setScene(reserveScene));

//exit button in reserve scene

			Button exitReserve = new Button();
			Image eimgReserve = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVReserve = new ImageView(eimgReserve);
			eimgVReserve.setPreserveRatio(true);
			eimgVReserve.setFitWidth(50);
			eimgVReserve.setFitHeight(50);
			eimgVReserve.setPreserveRatio(true);
			exitReserve.setGraphic(eimgVReserve);
			exitReserve.setStyle("-fx-background-color: Transparent;");
			exitReserve.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitReserve.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitReserve.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitReserve.setStyle("-fx-background-color:Transparent; ");
				}
			});

			// home button in reserve scene
			Button homeReserve = new Button();
			Image himgReserve = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVReserve = new ImageView(himgReserve);
			himgVReserve.setPreserveRatio(true);
			himgVReserve.setFitWidth(50);
			himgVReserve.setFitHeight(50);
			himgVReserve.setPreserveRatio(true);
			homeReserve.setGraphic(himgVReserve);
			homeReserve.setStyle("-fx-background-color: Transparent;");
			homeReserve.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeReserve.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homeReserve.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeReserve.setStyle("-fx-background-color:Transparent; ");
				}
			});

			VBox reserveVb4 = new VBox(20);
			reserveVb4.getChildren().addAll(exitReserve, homeReserve);
			reservePane.setLeft(reserveVb4);
			reserveVb4.setPadding(new Insets(20, 0, 0, 20));

			//
			Button cancel = new Button("Cancel a Reservation");
			cancel.setStyle("-fx-font-size:25px;-fx-background-color:Transparent; -fx-font-family:'Sans Serif';");
			cancel.setTextFill(Color.WHITE);
			cancel.setOnMouseMoved(event -> {
				cancel.setTextFill(Color.BROWN);
			});
			cancel.setOnMouseExited(event -> {
				cancel.setTextFill(Color.WHITE);
			});

			// cancel scene
			BorderPane cancelPane = new BorderPane();
			cancelPane.setBackground(rootBGround);

			VBox cancelVb1 = new VBox(40);

			Label cancelLb1 = new Label("Flight Number:");
			cancelLb1.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label cancelLb2 = new Label("Passenger Full Name:");
			cancelLb2.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");

			TextField cancelTf1 = new TextField();
			cancelTf1.setPromptText("Type in Flight Number");
			cancelTf1.setPrefHeight(30);
			cancelTf1.setStyle("-fx-font-size:15;");
			TextField cancelTf2 = new TextField();
			cancelTf2.setPromptText("Type in Full Name");
			cancelTf2.setPrefHeight(30);
			cancelTf2.setStyle("-fx-font-size:15;");

			TextArea cancelTa = new TextArea();
			cancelTa.setPrefHeight(50);
			cancelTa.setPrefWidth(50);

			Button cancelButton = new Button("Cancel Ticket!");
			cancelButton.setPrefHeight(40);
			cancelButton.setStyle("-fx-font-weight:bold;");
			cancelButton.setOnAction(e -> {
				try {
					int cancelFNumber = Integer.parseInt(cancelTf1.getText());
					passengersLL.cancelReservation(cancelFNumber, cancelTf2.getText());
					cancelTa.setText("Passenger's Reservation Got Canceled!");
				} catch (NumberFormatException c) {
					System.out.println("User input was not a number");
					cancelTa.setText("User input was not a number");
				} catch (Exception c) {
					System.out.println("Could Not Find Passenger's Reservation");
					cancelTa.setText("Could Not Find Passenger's Reservation");
				}
			});

			cancelVb1.getChildren().addAll(cancelLb1, cancelTf1, cancelLb2, cancelTf2, cancelButton, cancelTa);

			cancelVb1.setAlignment(Pos.CENTER);
			cancelPane.setCenter(cancelVb1);
			cancelVb1.setPadding(new Insets(0, 500, 0, 500));

			Scene cancelScene = new Scene(cancelPane, screenSize.getWidth(), screenSize.getHeight());

			cancel.setOnAction(e -> primaryStage.setScene(cancelScene));

			// exit button in cancel scene

			Button exitCancel = new Button();
			Image eimgCancel = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVCancel = new ImageView(eimgCancel);
			eimgVCancel.setPreserveRatio(true);
			eimgVCancel.setFitWidth(50);
			eimgVCancel.setFitHeight(50);
			eimgVCancel.setPreserveRatio(true);
			exitCancel.setGraphic(eimgVCancel);
			exitCancel.setStyle("-fx-background-color: Transparent;");
			exitCancel.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitCancel.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitCancel.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitCancel.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in cancel scene
			Button homeCancel = new Button();
			Image himgCancel = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVCancel = new ImageView(himgCancel);
			himgVCancel.setPreserveRatio(true);
			himgVCancel.setFitWidth(50);
			himgVCancel.setFitHeight(50);
			himgVCancel.setPreserveRatio(true);
			homeCancel.setGraphic(himgVCancel);
			homeCancel.setStyle("-fx-background-color: Transparent;");
			homeCancel.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeCancel.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homeCancel.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeCancel.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox cancelVb4 = new VBox(20);
			cancelVb4.getChildren().addAll(exitCancel, homeCancel);
			cancelPane.setLeft(cancelVb4);
			cancelVb4.setPadding(new Insets(20, 0, 0, 20));

			//
			Button check = new Button("Check a Ticket");
			check.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			check.setTextFill(Color.WHITE);
			check.setOnMouseMoved(event -> {
				check.setTextFill(Color.BROWN);
			});
			check.setOnMouseExited(event -> {
				check.setTextFill(Color.WHITE);
			});

			// check scene
			BorderPane checkPane = new BorderPane();
			checkPane.setBackground(rootBGround);

			VBox checkVb1 = new VBox(40);

			Label checkLb1 = new Label("Flight Number:");
			checkLb1.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			Label checkLb2 = new Label("Passenger Full Name:");
			checkLb2.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");

			TextField checkTf1 = new TextField();
			checkTf1.setPromptText("Type in Flight Number");
			checkTf1.setPrefHeight(30);
			checkTf1.setStyle("-fx-font-size:15;");
			TextField checkTf2 = new TextField();
			checkTf2.setPromptText("Type in Full Name");
			checkTf2.setPrefHeight(30);
			checkTf2.setStyle("-fx-font-size:15;");

			TextArea checkTa = new TextArea();
			checkTa.setPrefHeight(50);
			checkTa.setPrefWidth(50);

			Button checkButton = new Button("Check reservation!");
			checkButton.setPrefHeight(40);
			checkButton.setStyle("-fx-font-weight:bold;");
			checkButton.setOnAction(e -> {
				try {
					int checkFNumber = Integer.parseInt(checkTf1.getText());
					passengersLL.checkReservation(checkFNumber, checkTf2.getText());
					checkTa.setText("Passenger's Reservation Is Found!" + "\n");
					checkTa.setText(passengersLL.searchPassenger(checkTf2.getText()).toString());
				} catch (NumberFormatException c) {
					System.out.println("User input was not a number");
					checkTa.setText("User input was not a number");
				} catch (Exception c) {
					System.out.println("Could Not Find Passenger's Reservation");
					checkTa.setText("Could Not Find Passenger's Reservation");
				}

			});

			checkVb1.getChildren().addAll(checkLb1, checkTf1, checkLb2, checkTf2, checkButton, checkTa);

			checkVb1.setAlignment(Pos.CENTER);
			checkPane.setCenter(checkVb1);
			checkVb1.setPadding(new Insets(0, 500, 0, 500));

			Scene checkScene = new Scene(checkPane, screenSize.getWidth(), screenSize.getHeight());

			check.setOnAction(e -> primaryStage.setScene(checkScene));

			// exit button in check scene

			Button exitCheck = new Button();
			Image eimgCheck = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVCheck = new ImageView(eimgCheck);
			eimgVCheck.setPreserveRatio(true);
			eimgVCheck.setFitWidth(50);
			eimgVCheck.setFitHeight(50);
			eimgVCheck.setPreserveRatio(true);
			exitCheck.setGraphic(eimgVCheck);
			exitCheck.setStyle("-fx-background-color: Transparent;");
			exitCheck.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitCheck.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitCheck.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitCheck.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in check scene
			Button homeCheck = new Button();
			Image himgCheck = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVCheck = new ImageView(himgCheck);
			himgVCheck.setPreserveRatio(true);
			himgVCheck.setFitWidth(50);
			himgVCheck.setFitHeight(50);
			himgVCheck.setPreserveRatio(true);
			homeCheck.setGraphic(himgVCheck);
			homeCheck.setStyle("-fx-background-color: Transparent;");
			homeCheck.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeCheck.setStyle("-fx-background-color:PALEGOLDENRO+++D; ");
				}
			});
			homeCheck.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeCheck.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox checkVb4 = new VBox(20);
			checkVb4.getChildren().addAll(exitCheck, homeCheck);
			checkPane.setLeft(checkVb4);
			checkVb4.setPadding(new Insets(20, 0, 0, 20));

			//
			Button search = new Button("Find Passenger");
			search.setStyle("-fx-font-size:25px;-fx-background-color:Transparent;-fx-font-family:'Sans Serif'");
			search.setTextFill(Color.WHITE);
			search.setOnMouseMoved(event -> {
				search.setTextFill(Color.BROWN);
			});
			search.setOnMouseExited(event -> {
				search.setTextFill(Color.WHITE);
			});

			// search passenger Scene
			BorderPane searchPane = new BorderPane();
			searchPane.setBackground(rootBGround);

			VBox searchVb = new VBox(40);

			HBox searchHb = new HBox(10);
			Label searchLbl = new Label("Passenger Name:");
			searchLbl.setStyle("-fx-font-weight: bold; -fx-text-fill:white; -fx-font-size:15;");
			TextField searchTf = new TextField();
			searchTf.setPromptText("Type Name Here");
			searchTf.setPrefHeight(30);
			searchTf.setPrefWidth(300);

			Button searchFind = new Button("Find");
			searchFind.setStyle("-fx-font-weight: bold;");

			searchHb.getChildren().addAll(searchLbl, searchTf, searchFind);

			TextArea searchTa = new TextArea();

			searchFind.setOnAction(e -> {
				try {
					String userName = searchTf.getText();
					if (passengersLL.searchPassenger(userName).equals(null)) {
						searchTa.setText("Passenger Not Found");
					} else {
						searchTa.setText(passengersLL.searchPassenger(userName).toString());
					}
				} catch (NumberFormatException ex) {
					System.out.println("User input is not a number");
					searchTa.setText("User input is not a number");
				} catch (Exception ex) {
					System.out.println("Passenger Not Found");
					searchTa.setText("Passenger Not Found");
				}

			});

			searchVb.getChildren().addAll(searchHb, searchTa);

			searchVb.setAlignment(Pos.CENTER);
			searchPane.setCenter(searchVb);
			searchVb.setPadding(new Insets(0, 350, 0, 350));

			Scene searchScene = new Scene(searchPane, screenSize.getWidth(), screenSize.getHeight());

			search.setOnAction(e -> primaryStage.setScene(searchScene));

			// exit button in search scene

			Button exitSearch = new Button();
			Image eimgSearch = new Image("file:close_badged_cross_delete_remove_circle_button_icon_142902.png");
			ImageView eimgVSearch = new ImageView(eimgSearch);
			eimgVSearch.setPreserveRatio(true);
			eimgVSearch.setFitWidth(50);
			eimgVSearch.setFitHeight(50);
			eimgVSearch.setPreserveRatio(true);
			exitSearch.setGraphic(eimgVSearch);
			exitSearch.setStyle("-fx-background-color: Transparent;");
			exitSearch.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitSearch.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			exitSearch.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					exitSearch.setStyle("-fx-background-color:Transparent; ");
				}
			});
			// home button in search scene
			Button homeSearch = new Button();
			Image himgSearch = new Image("file:3643769-building-home-house-main-menu-start_113416.png");
			ImageView himgVSearch = new ImageView(himgSearch);
			himgVSearch.setPreserveRatio(true);
			himgVSearch.setFitWidth(50);
			himgVSearch.setFitHeight(50);
			himgVSearch.setPreserveRatio(true);
			homeSearch.setGraphic(himgVSearch);
			homeSearch.setStyle("-fx-background-color: Transparent;");
			homeSearch.addEventHandler(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeSearch.setStyle("-fx-background-color:PALEGOLDENROD; ");
				}
			});
			homeSearch.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent e) {
					homeSearch.setStyle("-fx-background-color:Transparent; ");
				}
			});
			VBox searchVb2 = new VBox(20);
			searchVb2.getChildren().addAll(exitSearch, homeSearch);
			searchPane.setLeft(searchVb2);
			searchVb2.setPadding(new Insets(20, 0, 0, 20));

			// menu scene
			Scene menuScene = new Scene(menuPane, screenSize.getWidth(), screenSize.getHeight());
			exitRead.setOnAction(e -> primaryStage.setScene(menuScene));
			exitdisplay.setOnAction(e -> primaryStage.setScene(menuScene));
			exitPdisplay.setOnAction(e -> primaryStage.setScene(menuScene));
			exitAdd.setOnAction(e -> primaryStage.setScene(menuScene));
			exitReserve.setOnAction(e -> primaryStage.setScene(menuScene));
			exitCancel.setOnAction(e -> primaryStage.setScene(menuScene));
			exitCheck.setOnAction(e -> primaryStage.setScene(menuScene));
			exitSearch.setOnAction(e -> primaryStage.setScene(menuScene));

			menuVB.getChildren().addAll(read, fDisplay, pDisplay, add, reserve, cancel, check, search);
			menuVB.setAlignment(Pos.CENTER);
			menuPane.setCenter(menuVB);

			menu.setOnAction(e -> primaryStage.setScene(menuScene));

			// pop out window
			Stage popupwindow = new Stage();
			BorderPane popPane = new BorderPane();

			popupwindow.initStyle(StageStyle.TRANSPARENT);

			popPane.setStyle("-fx-background-color: rgba(255, 255, 255, 0.5);"
					+ "-fx-effect: dropshadow(gaussian, gold, 50, 0, 0, 0);" + "-fx-background-insets: 50;");

			Button closeButton = new Button("");
			closeButton.setGraphic(eimgV);
			closeButton.setStyle("-fx-background-color:Transparent; ");
			closeButton.setOnAction(e -> popupwindow.close());

			closeButton.setOnMouseMoved(event -> {
				closeButton.setStyle("-fx-background-color:white; ");
			});

			closeButton.setOnMouseExited(event -> {
				closeButton.setStyle("-fx-background-color:Transparent; ");
			});

			popPane.setTop(closeButton);
			popPane.setAlignment(closeButton, Pos.TOP_RIGHT);

			Scene popScene = new Scene(popPane, 400, 400);
			popScene.setFill(Color.TRANSPARENT);
			popupwindow.setScene(popScene);
			flights.setOnAction(e -> popupwindow.show());

			// file information
			File fil = new File("Flights.txt");
			String fileInfo = "";
			Scanner input;
			try {
				input = new Scanner(new File("C:\\Users\\nadeen\\Desktop\\Flights.txt"));
				while (input.hasNext()) {
					fileInfo += input.nextLine() + "\n";
				}
			} catch (FileNotFoundException ex) {
				System.err.println(ex);
			}
			;
			Text printF = new Text("flights");
			printF.setText(fileInfo);
			popPane.setCenter(printF);

			//
			Scene scene = new Scene(root, screenSize.getWidth(), screenSize.getHeight());
			exit.setOnAction(e -> primaryStage.setScene(scene));
			home.setOnAction(e -> primaryStage.setScene(scene));
			homeRead.setOnAction(e -> primaryStage.setScene(scene));
			homedisplay.setOnAction(e -> primaryStage.setScene(scene));
			homePdisplay.setOnAction(e -> primaryStage.setScene(scene));
			homeAdd.setOnAction(e -> primaryStage.setScene(scene));
			homeReserve.setOnAction(e -> primaryStage.setScene(scene));
			homeCancel.setOnAction(e -> primaryStage.setScene(scene));
			homeCheck.setOnAction(e -> primaryStage.setScene(scene));
			homeSearch.setOnAction(e -> primaryStage.setScene(scene));

			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setMaximized(true);
			primaryStage.setTitle("Airlines");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
