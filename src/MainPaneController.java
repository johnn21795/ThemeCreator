import com.jfoenix.controls.*;
import com.sun.javafx.css.StyleCache;
import com.sun.javafx.css.StyleManager;
import com.sun.javafx.css.StyleMap;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.css.Styleable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sun.swing.ImageCache;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainPaneController implements Initializable {

    public JFXColorPicker picker4;
    public JFXColorPicker picker3;
    public Slider slider3;
    public Slider slider4;
    public JFXTextField StyleField;
    public JFXButton Reset;
    public JFXButton Imagepicker;
    public VBox BackgroundControls;
    public Group LabelElement;
    public Label SamTxt1;
    public Label SamTxt2;
    public Label SamTxt3;
    public Label SamTxt4;
    public Label SamTxt5;
    public VBox LabelControls;
    public VBox TableControls;
    public JFXColorPicker txtColor;
    public JFXColorPicker bckColor;
    public JFXTextField BckGrad;
    public JFXSlider fntSz;
    public JFXCheckBox isBold;
    public JFXComboBox<String> StyName;
    public JFXButton StySave;
    public ScrollPane scrollPane;
    public JFXComboBox<String> comboBox3;
    public JFXComboBox<String> comboBox2;
    public JFXComboBox<String> comboBox1;
    public JFXTextField textField1;
    public Label saveText1;
    public JFXTextField textField2;
    public Label saveText2;
    public JFXTextField textField3;
    public Label saveText3;
    public JFXDatePicker datePicker1;
    public JFXDatePicker datePicker2;
    public JFXDatePicker datePicker3;
    public JFXProgressBar progressBar;
    public JFXButton nButton1;
    public JFXButton nButton2;
    public JFXButton nButton3;
    public JFXButton gButton1;
    public FontAwesomeIcon glyph1;
    public JFXButton gButton2;
    public FontAwesomeIcon glyph2;
    public JFXButton gButton3;
    public FontAwesomeIcon glyph3;
    public Label mainName;
    public Label mainSubName;
    public Label mainDate;
    public Label mainSubHead;
    public Label defaultText;
    public TableView<ModelClass> Table;
    public TableColumn<ModelClass, ?> col1;
    public TableColumn<ModelClass, ?> col2;
    public TableColumn<ModelClass, ?> col3;
    public TableColumn<ModelClass, ?> col4;
    public AnchorPane rootPane;
    public JFXTabPane TabPane;
    public JFXButton StySaveAs;
    public JFXTextField StyleName;
    public JFXSlider slider6;
    public JFXColorPicker picker6;
    public JFXSlider slider5;
    public JFXColorPicker picker5;
    public JFXButton AppyToTheme;
    public JFXButton ResBut;
    public JFXCheckBox bckTrans;
    public JFXColorPicker headerColor;
    public JFXColorPicker headerText;
    public JFXColorPicker SelectedColor;
    public JFXColorPicker OddRows;
    public JFXColorPicker OddText;
    public JFXColorPicker EvenRows;
    public JFXColorPicker EvenText;
    public JFXTextField TableTxtSize;
    public JFXComboBox<String> ButtonStates;
    public Group GradientGroup;
    public JFXCheckBox useGradient;
    public JFXCheckBox useImage;
    public HBox ImageGroup;
    public HBox TabText;
    public JFXColorPicker txtColor1;
    public Label focusLabel;
    public Label unFocusLabel;
    public Label fillLabel;
    public Group TableGroup;
    public VBox ProgressControls;
    public JFXColorPicker picker7;
    public JFXSlider slider7;
    public JFXSlider slider8;
    public JFXColorPicker picker8;
    public JFXButton ExportBut;
    public JFXTextField ThemeName;
    public JFXButton LoadBut;
    public JFXColorPicker mainColor;
    @FXML
    private AnchorPane DesignPane;

    @FXML
    private JFXButton BackgroundBut;

    @FXML
    private JFXButton LabelBut;

    @FXML
    private JFXButton TableBut;

    @FXML
    private JFXButton ButtonBut;

    @FXML
    private JFXButton TabBut;

    @FXML
    private JFXButton TextFieldBut;


    @FXML
    private JFXButton GlyphBut;



    @FXML
    private JFXButton ScrollBut;

    @FXML
    private JFXButton ProgressBut;

    @FXML
    private JFXColorPicker picker1;

    @FXML
    private Slider slider1;

    @FXML
    private JFXColorPicker picker2;

    @FXML
    private Slider slider2;




    static String ActiveElement = "";

    // Label Controls
    Label activeText;
    String labelText = "";
    String labelBkgrnd = "";
    static String labelWeight = "-fx-font-weight: Normal;";
    static String labelSize = "";




    StringBuilder labelStyle;
    static String Color1 ="#FFFFFF ", Color2 ="#FFFFFF ",Color3 ="#FFFFFF ",Color4 ="#FFFFFF ";
    static String Color5 ="#FFFFFF ", Color6 ="#FFFFFF ",Color7 ="#FFFFFF ",Color8 ="#FFFFFF ";
    static String Slider1 = "0%",  Slider2 = "0%",  Slider3 = "0%",  Slider4 = "0%";
    static String Slider5 = "0%",  Slider6 = "0%",  Slider7 = "0%",  Slider8 = "0%";
    static File backgroundImage = new File("C:\\Users\\Public\\ThemeCreator\\background.jpg");
    static File buttonImage = new File("C:\\Users\\Public\\ThemeCreator\\buttonImage.jpg");

    static File butHover = new File("C:\\Users\\Public\\ThemeCreator\\butHover.jpg");
    static File butFocused = new File("C:\\Users\\Public\\ThemeCreator\\butFocused.jpg");
    static File TabFGround = new File("C:\\Users\\Public\\ThemeCreator\\TabFGround.jpg");
    static File TabBGround = new File("C:\\Users\\Public\\ThemeCreator\\TabBGround.jpg");


    static String OriginalLocation= "";
    Tooltip x = new Tooltip();


    ObservableList<VBox> ElementsControls ;
    static String mainStyle = "file:/"+System.getProperty("user.home").replace("\\", "/" ) + "/Desktop/ThemeCreator/DefaultTheme.css";
    static String tempStyle = "file:/"+System.getProperty("user.home").replace("\\", "/" ) + "/Desktop/ThemeCreator/temp.css";
    static File file2 = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/temp.css");


    static File defaultTheme = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/DefaultTheme.css");
    static FileWriter fileWriter ;
    static List<String> allLines;
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ElementsControls = FXCollections.observableArrayList(BackgroundControls,LabelControls, TableControls, ProgressControls);

        try {

            File f = new File("C:\\Users\\Public\\ThemeCreator\\");

            file2.mkdir();
            f.mkdirs();
            InputStream in = getClass().getClassLoader().getResourceAsStream("./MainPanes/MainStyle.css");
            System.out.println(in.read());

            assert in != null;

            Files.copy(in, defaultTheme.toPath(), StandardCopyOption.REPLACE_EXISTING);

            for(File x : f.listFiles()){
                x.delete();
            }
            Files.copy(defaultTheme.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
            allLines= Files.readAllLines(file2.toPath());
            rootPane.getStylesheets().add(tempStyle);
            setUp();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }

    private void setUp() {

        StyName.setItems(FXCollections.observableArrayList("Bold Text", "Main SUb Head","Main Heading", "Subheading", "Default"));
        ButtonStates.setItems(FXCollections.observableArrayList("Default","Hover","Focused"));
        comboBox1.setItems(FXCollections.observableArrayList("Apple", "Ball", "Cup"));
        comboBox2.setItems(FXCollections.observableArrayList("Apple", "Ball", "Cup"));
        comboBox3.setItems(FXCollections.observableArrayList("Apple", "Ball", "Cup"));
        mainColor.setValue(Color.valueOf("#010365"));
        ButtonStates.getSelectionModel().select(0);
        ButtonStates.setOnAction(event -> {
            try {
                fileWriter = new FileWriter(file2);

                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonImage")) {
                            String l = "\t-fx-background-image:url('file:/\\/\\/"+buttonImage.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                            allLines.set(x, l);
                        }
                    }

                for(String line : allLines){
                    try {
                        fileWriter.write(line);
                        fileWriter.write("\n");
                    } catch (IOException ignored) {

                    }
                }
                fileWriter.close();
                rootPane.getStylesheets().remove(0);
                rootPane.getStylesheets().add(tempStyle);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }

    public void ElementsAction(ActionEvent event) throws Exception{
        x.hide();
        if(event.getSource().equals(useImage)){
            useGradient.setSelected(!useImage.isSelected());
            GradientGroup.setDisable(!useGradient.isSelected());
            ImageGroup.setDisable(!useImage.isSelected());
//            System.out.println("isDefault Button "+isDefaultButtonImage);
//            System.out.println("ButtonStates.getSelectionModel().getSelectedIndex() "+ButtonStates.getSelectionModel().getSelectedIndex());
//            if(isDefaultButtonImage && ButtonStates.getSelectionModel().getSelectedIndex() > 0){
//                GradientGroup.setDisable(true);
//                useGradient.setDisable(true);
//            }
           
        }
        if(event.getSource().equals(useGradient)){
            useImage.setSelected(!useGradient.isSelected());
            ImageGroup.setDisable(!useImage.isSelected());
            GradientGroup.setDisable(!useGradient.isSelected());
//            System.out.println("isDefault G Button "+isDefaultButtonImage);
//            System.out.println("ButtonStates.getSelectionModel().getSelectedIndex() "+ButtonStates.getSelectionModel().getSelectedIndex());
//            if(isDefaultButtonImage && ButtonStates.getSelectionModel().getSelectedIndex() > 0){
//                GradientGroup.setDisable(true);
//                useGradient.setDisable(true);
//            }

        }
        if(event.getSource().equals(BackgroundBut)){
            ActiveElement = "Background";
            ElementsControls.forEach(e-> e.setVisible(false));
            TabPane.getSelectionModel().select(0);
            ButtonStates.setVisible(false);
            BackgroundControls.setVisible(true);
        }
        if(event.getSource().equals(ButtonBut)){
            ActiveElement = "Button";
            ElementsControls.forEach(e-> e.setVisible(false));
            TabPane.getSelectionModel().select(0);
            BackgroundControls.setVisible(true);
        }
        if(ActiveElement.equals("Button")){
            ButtonStates.setVisible(true);
            ButtonStates.setItems(FXCollections.observableArrayList("Default","Hover","Focused"));
            ButtonStates.setPromptText("Button Controls");
            ButtonStates.getSelectionModel().select(0);
        }
        if(event.getSource().equals(TableBut)){
            ActiveElement = "Table";
            focusLabel.setText("Header Color:");
            unFocusLabel.setText("Header TextColor:");
            fillLabel.setText("Selected Color:");
            SelectedColor.setVisible(true);
            TableGroup.setVisible(true);
            loadTable();
            ElementsControls.forEach(e-> e.setVisible(false));
            TableControls.setVisible(true);
            TabPane.getSelectionModel().select(1);
        }
        if(event.getSource().equals(LabelBut)){
            ActiveElement = "Label";
            ElementsControls.forEach(e-> e.setVisible(false));
            LabelControls.setVisible(true);
            TabPane.getSelectionModel().select(0);
        }
        if(event.getSource().equals(TabBut)){
            ActiveElement = "Tab";
            ElementsControls.forEach(e-> e.setVisible(false));
            BackgroundControls.setVisible(true);
            TabPane.getSelectionModel().select(0);
        }
        if(ActiveElement.equals("Tab")){
            ButtonStates.setVisible(true);
            TabText.setVisible(true);
            ButtonStates.setItems(FXCollections.observableArrayList("ForeGround","Background"));
            ButtonStates.setPromptText("Tab Controls");
            ButtonStates.getSelectionModel().select(0);
        }else {
            TabText.setVisible(false);
        }
        if(event.getSource().equals(TextFieldBut)){
            ActiveElement = "TextField";
            focusLabel.setText("Focus Color:");
            unFocusLabel.setText("UnFocus Color");
            fillLabel.setText("Text Color");
            SelectedColor.setVisible(true);
            TableGroup.setVisible(false);
            ElementsControls.forEach(e-> e.setVisible(false));
            TableControls.setVisible(true);
            TabPane.getSelectionModel().select(0);
        }
        if(event.getSource().equals(GlyphBut)){
            ActiveElement = "Glyph";
            focusLabel.setText("Fill Color:");
            unFocusLabel.setText("Stroke Color:");
            fillLabel.setText("");
            SelectedColor.setVisible(false);
            TableGroup.setVisible(false);
            ElementsControls.forEach(e-> e.setVisible(false));
            TableControls.setVisible(true);
            TabPane.getSelectionModel().select(0);
        }
        if(event.getSource().equals(ScrollBut)){
            ActiveElement = "Scroll";
            focusLabel.setText("ForeGround:");
            unFocusLabel.setText("Background:");
            fillLabel.setText("");
            SelectedColor.setVisible(false);
            TableGroup.setVisible(false);
            ElementsControls.forEach(e-> e.setVisible(false));
            TableControls.setVisible(true);
            TabPane.getSelectionModel().select(1);
        }
        if(event.getSource().equals(ScrollBut)){
            ActiveElement = "Scroll";
            focusLabel.setText("ForeGround:");
            unFocusLabel.setText("Background:");
            fillLabel.setText("");
            SelectedColor.setVisible(false);
            TableGroup.setVisible(false);
            ElementsControls.forEach(e-> e.setVisible(false));
            TableControls.setVisible(true);
            TabPane.getSelectionModel().select(1);
        } 
        if(event.getSource().equals(ProgressBut)){
            ActiveElement = "Progress";
            fillLabel.setText("");
            SelectedColor.setVisible(false);
            TableGroup.setVisible(false);
            ElementsControls.forEach(e-> e.setVisible(false));
            ProgressControls.setVisible(true);
            TabPane.getSelectionModel().select(0);
        }



    }



    public void GradientControls(ActionEvent event) throws Exception {

        if (event.getSource().equals(picker1)) {
            Color1 = "#"+picker1.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        if (event.getSource().equals(picker2)) {
            Color2 = "#"+picker2.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        if (event.getSource().equals(picker3)) {
            Color3 = "#"+picker3.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        if (event.getSource().equals(picker4)) {
            Color4 = "#"+picker4.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        if(ActiveElement.equals("Button") ){
            fileWriter = new FileWriter(file2);
            int BState = ButtonStates.getSelectionModel().getSelectedIndex();
            switch (BState){
                case 1:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonHover:")) {
                            String l = "\t\tButtonHover: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("ButHover")) {
                            butHover = new File("C:\\Users\\Public\\ThemeCreator\\butHover2.jpg");
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\ButHover2.jpg');  /* ButHover */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
                case 2:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonFocused:")) {
                            String l = "\t\tButtonFocused: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("ButFocused")) {
                            butFocused = new File("C:\\Users\\Public\\ThemeCreator\\ButFocused2.jpg");
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\ButFocused2.jpg');  /* ButFocused */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
                default:
                   break;
            }
            if(BState > 0){
                nButton1.setStyle("");
                nButton2.setStyle("");
                nButton3.setStyle("");
                gButton1.setStyle("");
                gButton2.setStyle("");
                gButton3.setStyle("");
            }else {

                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonImage")) {
                            buttonImage = new File("C:\\Users\\Public\\ThemeCreator\\buttonImage2.jpg");
                            String l = "/* \t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\buttonImage2.jpg');  /* ButtonImage */ ";
                            allLines.set(x, l);
                        }
                    }

                nButton1.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                nButton2.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                nButton3.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton1.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton2.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton3.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");

            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
      }
        if (ActiveElement.equals("Background")) {
            DesignPane.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
        }
        if(ActiveElement.equals("Tab")){
            fileWriter = new FileWriter(file2);
            int BState = ButtonStates.getSelectionModel().getSelectedIndex();
            switch (BState){
                case 0:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("TabForeGround:")) {
                            String l = "\t\tTabForeGround: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("TabFGround")) {
                            TabFGround = new File("C:\\Users\\Public\\ThemeCreator\\TabFGround2.jpg");
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\TabFGround2.jpg');  /* TabFGround */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
                case 1:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("TabBackground:")) {
                            String l = "\t\tTabBackground: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("TabBGround")) {
                            TabBGround = new File("C:\\Users\\Public\\ThemeCreator\\TabBGround2.jpg");
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\TabBGround2.jpg');  /* TabBGround */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
        }
        if(event.getSource().equals(mainColor)){
            fileWriter = new FileWriter(file2);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("MainColor:")) {
                    String l = "\t\tMainColor: "+  "#"+mainColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
        }

        StyleField.setText("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");

//        applyTheme();

    }

    public void SliderControls(MouseEvent event) throws Exception {
        if(event.getSource().equals(slider1)){
            Slider1 = ((int)slider1.getValue())+"%";
        }
        if(event.getSource().equals(slider2)){
            Slider2 = ((int)slider2.getValue())+"%";
        }
        if(event.getSource().equals(slider3)){
            Slider3 = ((int)slider3.getValue())+"%";
        }
        if(event.getSource().equals(slider4)){
            Slider4 = ((int)slider4.getValue())+"%";
        }
        if(ActiveElement.equals("Button") ){
            fileWriter = new FileWriter(file2);
            int BState = ButtonStates.getSelectionModel().getSelectedIndex();
            switch (BState){
                case 1:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonHover:")) {
                            String l = "\t\tButtonHover: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("ButHover")) {
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\ButHover2.jpg');  /* ButHover */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
                case 2:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonFocused:")) {
                            String l = "\t\tButtonFocused: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("ButFocused")) {
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\ButFocused2.jpg');  /* ButFocused */ ";
                            allLines.set(x, l);
                        }
                    }
                break;
                default:
                   break;
            }
            if(BState > 0){
                nButton1.setStyle("");
                nButton2.setStyle("");
                nButton3.setStyle("");
                gButton1.setStyle("");
                gButton2.setStyle("");
                gButton3.setStyle("");
            }else {

                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("ButtonImage")) {
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\buttonImage2.jpg');  /* ButtonImage */ ";
                            allLines.set(x, l);
                        }
                    }

                nButton1.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                nButton2.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                nButton3.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton1.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton2.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
                gButton3.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");

            }

            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);

        }
        if (ActiveElement.equals("Background")) {
            DesignPane.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
        }
        if(ActiveElement.equals("Tab")){
            fileWriter = new FileWriter(file2);
            int BState = ButtonStates.getSelectionModel().getSelectedIndex();
            switch (BState){
                case 0:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("TabForeGround:")) {
                            String l = "\t\tTabForeGround: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("TabFGround")) {
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\TabFGround2.jpg');  /* TabFGround */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
                case 1:
                    for (int x =0; x < allLines.size() ; x++) {
                        if (allLines.get(x).contains("TabBackground:")) {
                            String l = "\t\tTabBackground: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                            allLines.set(x, l);
                        }
                        if (allLines.get(x).contains("TabBGround")) {
                            String l = "\t\t-fx-background-image:url('file:/\\/\\/C:/\\Users/\\Public/\\ThemeCreator/\\TabBGround2.jpg');  /* TabBGround */ ";
                            allLines.set(x, l);
                        }
                    }
                    break;
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }

            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
        }

        StyleField.setText("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
//        applyTheme();
    }

    public void DragComplete(MouseEvent event)throws Exception{
        fileWriter = new FileWriter(file2);
        if(ActiveElement.equals("Button")){
            if(ButtonStates.getSelectionModel().getSelectedIndex() == 0){
                fileWriter = new FileWriter(file2);
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("ButtonGradient:")) {
                        String l = "\t\tButtonGradient: "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                        allLines.set(x, l);
                    }
                }
            }
        }
        if(ActiveElement.equals("Progress")){
            if(ButtonStates.getSelectionModel().getSelectedIndex() == 0){
                fileWriter = new FileWriter(file2);
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("ProgressGradient:")) {
                        String l = "\t\tProgressGradient: "+ "linear-gradient("+Color7+Slider7+", "+Color8+Slider8+" ); ";
                        allLines.set(x, l);
                    }
                }
            }
        }
        if(ActiveElement.equals("Background")){
                fileWriter = new FileWriter(file2);
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("BackgroundGradient:")) {
                        String l = "\t\tBackgroundGradient" +
                                ": "+ "linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" ); ";
                        allLines.set(x, l);
                    }
                }
        }

        for(String line : allLines){
            try {
                fileWriter.write(line);
                fileWriter.write("\n");
            } catch (IOException ignored) {

            }
        }
        fileWriter.close();
        rootPane.getStylesheets().remove(0);
        rootPane.getStylesheets().add(tempStyle);
        System.out.println("Dragged Complete");
    }

    public void ResetGradient(){
        slider1.setValue(0);
        slider2.setValue(0);
        slider3.setValue(0);
        slider4.setValue(0);
        picker1.setValue(Color.WHITE);
        picker2.setValue(Color.WHITE);
        picker3.setValue(Color.WHITE);
        picker4.setValue(Color.WHITE);
        Color1 ="#FFFFFF "; Color2 ="#FFFFFF ";Color3 ="#FFFFFF ";Color4 ="#FFFFFF "; Slider1 = "0%";  Slider2 = "0%";  Slider3 = "0%";
        StyleField.setText("");
    }

    public void ChooseImage(ActionEvent event) throws Exception {
        if(event.getSource().equals(ExportBut)){
            ThemeName.setVisible(true);
            ExportBut.setText("Export");
            ExportBut.setOnAction(e-> {
                try {
                    SaveTheme();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            return;
        }
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select File");
        File file = chooser.showOpenDialog(this.Imagepicker.getScene().getWindow());
        OriginalLocation = file.getAbsolutePath();
        File originalFile = new File(OriginalLocation);



        if(Objects.equals(ActiveElement, "Background")){
            fileWriter = new FileWriter(file2);
            Image img = new Image("file:\\"+ OriginalLocation);
            BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, true, true );
            Background background = new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
            Files.copy(originalFile.toPath(), backgroundImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
            DesignPane.setBackground(background);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("BackgroundImage")) {
                    backgroundImage = originalFile;
                    Files.copy(originalFile.toPath(), backgroundImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* BackgroundImage */ ";
                    allLines.set(x, l);
                }
            }
            for(String line : allLines){
                try {
                    fileWriter.write(line);
                    fileWriter.write("\n");
                } catch (IOException ignored) {

                }
            }
            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
            file = null;
           }
        if(Objects.equals(ActiveElement, "Button")){
            ButtonControls(file);
         }
        if(Objects.equals(ActiveElement, "Tab")){
            TabControls(file);
        }

    }

    public void SaveTheme()throws Exception{
        fileWriter = new FileWriter(file2);

        //Main Background Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(backgroundImage.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/background.jpg").toPath());
        }catch (Exception ignored){

        }
        //Main buttonImage Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(buttonImage.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/buttonImage.jpg").toPath());

        }catch (Exception ignored){

        }
        //Main butHover Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(butHover.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/butHover.jpg").toPath());
        }catch (Exception ignored){

        }
        //Main butFocused Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(butFocused.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/butFocused.jpg").toPath());
        }catch (Exception ignored){

        }
        //Main TabFGround Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(TabFGround.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/TabFGround.jpg").toPath());
        }catch (Exception ignored){

        }
        //Main TabBGround Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(TabBGround.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/TabBGround.jpg").toPath());
        }catch (Exception ignored){

        }
        for (int x =0; x < allLines.size() ; x++) {
            if (allLines.get(x).contains("BackgroundImage")) {
                String l = "\t-fx-background-image:url('file:/\\/\\/"+backgroundImage.getAbsolutePath().replace("\\","/\\")+"');  /* BackgroundImage */ ";
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButtonImage")) {
                String l = "\t-fx-background-image:url('file:/\\/\\/"+buttonImage.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButHover")) {
                String l = "\t-fx-background-image:url('file:/\\/\\/"+butHover.getAbsolutePath().replace("\\","/\\")+"');  /* ButHover */ ";
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButFocused")) {
                String l = "\t-fx-background-image:url('file:/\\/\\/"+butFocused.getAbsolutePath().replace("\\","/\\")+"');  /* ButFocused */ ";
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("TabFGround")) {
                 String l = "\t-fx-background-image:url('file:/\\/\\/"+TabFGround.getAbsolutePath().replace("\\","/\\")+"');  /* TabFGround */ ";
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("TabBGround")) {
                String l = "\t-fx-background-image:url('file:/\\/\\/"+TabBGround.getAbsolutePath().replace("\\","/\\")+"');  /* TabBGround */ ";
                allLines.set(x, l);
            }
        }
        for(String line : allLines){
            try {
                fileWriter.write(line);
                fileWriter.write("\n");
            } catch (IOException ignored) {

            }
        }
        fileWriter.close();
        Files.copy(file2.toPath(), new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+".css").toPath(), StandardCopyOption.REPLACE_EXISTING);



        x.setText("File Saved Successfully!!");
        x.setWidth(200);
        x.show(ThemeName.getScene().getWindow());
    }

    public void LoadTheme()throws Exception{

        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Css Theme", "*.css"));
        chooser.setInitialDirectory(  new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"));
        chooser.setTitle("Select Theme");
        File file = chooser.showOpenDialog(this.Imagepicker.getScene().getWindow());
        OriginalLocation = file.getAbsolutePath();
        File originalFile = new File(OriginalLocation);

        Files.copy(originalFile.toPath(), file2.toPath(), StandardCopyOption.REPLACE_EXISTING);
        allLines= Files.readAllLines(file2.toPath());

        ThemeName.setText(originalFile.getName().replace(".css", ""));
        File f = new File("C:\\Users\\Public\\ThemeCreator\\");
        for(File x : f.listFiles()){
            x.delete();
        }

        File themeBackgroundImage = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/background.jpg");
        File themeButtonImage = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/buttonImage.jpg");
        File themeButHover = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/butHover.jpg");
        File themeButFocused = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/butFocused.jpg");
        File themeTabFGround = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/tabFGround.jpg");
        File themeTabBGround = new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()+"/tabBGround.jpg");


        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(themeBackgroundImage.toPath(), backgroundImage.toPath(),  StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        //Main buttonImage Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy( themeButtonImage.toPath(),buttonImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        //Main butHover Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy( themeButHover.toPath(), butHover.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        //Main butFocused Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy( themeButFocused.toPath(),butFocused.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        //Main TabFGround Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy( themeTabFGround.toPath(),TabFGround.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        //Main TabBGround Copy
        try{
            new File(System.getProperty("user.home") + "/Desktop/ThemeCreator/"+ThemeName.getText()).mkdirs();
            Files.copy(themeTabBGround.toPath(),TabBGround.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }catch (Exception ignored){

        }
        for (int x =0; x < allLines.size() ; x++) {
            if (allLines.get(x).contains("BackgroundImage")) {
                String l;
                if(backgroundImage.exists()){
                     l = "\t-fx-background-image:url('file:/\\/\\/"+themeBackgroundImage.getAbsolutePath().replace("\\","/\\")+"');  /* BackgroundImage */ ";
                }else {
                     l = "\t-fx-background-image:url('file:/\\/\\/"+backgroundImage.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* BackgroundImage */ ";
                }

                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButtonImage")) {
                String l;
                if(buttonImage.exists()){
                    l = "\t-fx-background-image:url('file:/\\/\\/"+themeButtonImage.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                }else {
                    l = "\t-fx-background-image:url('file:/\\/\\/"+buttonImage.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* ButtonImage */ ";
                }
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButHover")) {
                String l;
                if(butHover.exists()){
                    l = "\t-fx-background-image:url('file:/\\/\\/"+themeButHover.getAbsolutePath().replace("\\","/\\")+"');  /* ButHover */ ";
                }else {
                    l = "\t-fx-background-image:url('file:/\\/\\/"+butHover.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* ButHover */ ";
                }
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("ButFocused")) {
                String l;
                if(butFocused.exists()){
                    l = "\t-fx-background-image:url('file:/\\/\\/"+themeButFocused.getAbsolutePath().replace("\\","/\\")+"');  /* ButFocused */ ";
                }else {
                    l = "\t-fx-background-image:url('file:/\\/\\/"+butFocused.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* ButFocused */ ";
                }
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("TabFGround")) {
                String l;
                if(TabFGround.exists()){
                    l = "\t-fx-background-image:url('file:/\\/\\/"+themeTabFGround.getAbsolutePath().replace("\\","/\\")+"');  /* TabFGround */ ";
                }else {
                    l = "\t-fx-background-image:url('file:/\\/\\/"+TabFGround.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* TabFGround */ ";
                }
                allLines.set(x, l);
            }
            if (allLines.get(x).contains("TabBGround")) {
                String l;
                if(TabBGround.exists()){
                    l = "\t-fx-background-image:url('file:/\\/\\/"+themeTabBGround.getAbsolutePath().replace("\\","/\\")+"');  /* TabBGround */ ";
                }else {
                    l = "\t-fx-background-image:url('file:/\\/\\/"+TabBGround.getAbsolutePath().replace("\\","/\\").replace(".jpg", "2.jpg")+"');  /* TabBGround */ ";
                }
                allLines.set(x, l);
            }
        }
        fileWriter = new FileWriter(file2);
        for(String line : allLines){
            try {
                fileWriter.write(line);
                fileWriter.write("\n");
            } catch (IOException ignored) {

            }
        }
        fileWriter.close();




        rootPane.getStylesheets().remove(0);
        rootPane.getStylesheets().add(tempStyle);

    }

    //LABEL CONTROLS
    public void LabelControls(ActionEvent event) throws Exception{
        labelStyle = new StringBuilder();
        if(event.getSource().equals(StyName)){
            int ind = StyName.getSelectionModel().getSelectedIndex();
            switch (ind){
                case 0:activeText = mainDate;break;
                case 1: activeText = mainSubHead;break;
                case 2:activeText = mainName;break;
                case 3:activeText = mainSubName;break;
                default:activeText = defaultText;
            }
        }

        if (event.getSource().equals(txtColor)) {
            labelText = "-fx-text-fill: " + "#" + txtColor.getValue().toString().substring(2, 8).toUpperCase()+";";
        }
        if(event.getSource().equals(txtColor1)){
            fileWriter = new FileWriter(file2);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("TabText:")) {
                    String l = "\t\tTabText: "+ "#"+txtColor1.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
            return;
        }
        if(event.getSource().equals(picker7) || event.getSource().equals(picker8)){
            Color7 = "#"+picker7.getValue().toString().toUpperCase().substring(2,8)+" ";
            Color8 = "#"+picker8.getValue().toString().toUpperCase().substring(2,8)+" ";
            fileWriter = new FileWriter(file2);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("ProgressGradient:")) {
                    String l = "\t\tProgressGradient: "+ "linear-gradient("+Color7+Slider7+", "+Color8+Slider8+" ); ";
                    allLines.set(x, l);
                }
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);
            return;
        }

        if(event.getSource().equals(ResBut)){
            labelStyle = new StringBuilder();
            txtColor.setValue(Color.WHITE);
            Color5 ="#FFFFFF "; Color6 ="#FFFFFF ";
            labelBkgrnd = "";
            bckColor.setValue(Color.WHITE);
            picker5.setValue(Color.WHITE);
            picker6.setValue(Color.WHITE);
            slider5.setValue(0);
            slider6.setValue(0);
            fntSz.setValue(14.0);
            labelSize = "-fx-font-size: "+(int) fntSz.getValue()+"px;";
            activeText.setStyle(String.valueOf(labelStyle));
            return;
        }

        if (event.getSource().equals(picker5)) {
            Color5 = "#"+picker5.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        if (event.getSource().equals(picker6)) {
            Color6 = "#"+picker6.getValue().toString().toUpperCase().substring(2,8)+" ";
        }
        labelBkgrnd = "-fx-background-color: linear-gradient("+Color5+Slider5+", "+Color6+Slider6+" );";

        if (event.getSource().equals(bckColor)) {
            labelBkgrnd = "-fx-background-color: " + "#" + bckColor.getValue().toString().substring(2, 8).toUpperCase()+";";
        }
        if(bckTrans.isSelected()){
            labelBkgrnd = "";
        }
        if(isBold.isSelected()){
            labelWeight = "-fx-font-weight: bold;";
        }else {
            labelWeight = "-fx-font-weight: Normal;";
        }

        labelStyle.append(labelText).append(labelBkgrnd).append(labelSize).append(labelWeight);
        System.out.println(labelStyle);
        activeText.setStyle(String.valueOf(labelStyle));
    }

    public void LabelControls2(MouseEvent event)throws Exception{
        labelStyle = new StringBuilder();
        System.out.println(ActiveElement);
        if(event.getSource().equals(slider5)){
            Slider5 = ((int)slider5.getValue())+"%";
        }
        if(event.getSource().equals(slider6)){
            Slider6 = ((int)slider6.getValue())+"%";
        }
        if(event.getSource().equals(slider7)){
            Slider7 = ((int)slider7.getValue())+"%";
        }
        if(event.getSource().equals(slider8)){
            Slider8 = ((int)slider8.getValue())+"%";
        }
        if(ActiveElement.equalsIgnoreCase("Progress")){
            fileWriter = new FileWriter(file2);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("ProgressGradient:")) {
                    String l = "\t\tProgressGradient: "+ "linear-gradient("+Color7+Slider7+", "+Color8+Slider8+" ); ";
                    allLines.set(x, l);
                }
            }
            for(String line : allLines){
                fileWriter.write(line);
                fileWriter.write("\n");
            }
            fileWriter.close();
            rootPane.getStylesheets().remove(0);
            rootPane.getStylesheets().add(tempStyle);

            return;
        }
        if(event.getSource().equals(fntSz)){
            labelSize = "-fx-font-size: "+(int) fntSz.getValue()+"px;";
        }
        labelBkgrnd = "-fx-background-color: linear-gradient("+Color5+Slider5+", "+Color6+Slider6+" );";
        if(bckTrans.isSelected()){
            labelBkgrnd = "";
        }
        labelStyle.append(labelText).append(labelBkgrnd).append(labelSize).append(labelWeight);
        System.out.println(labelStyle);
        activeText.setStyle(String.valueOf(labelStyle));
    }

    //Table Controls
    public void loadTable() {
        ObservableList<ModelClass> TableData = FXCollections.observableArrayList();
        TableData.add(new ModelClass(1,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(2,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(3,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(4,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(5,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(6,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(7,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(8,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(9,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(10,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(11,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(12,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(13,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(14,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(15,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(16,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(17,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(18,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(19,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(20,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(21,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(22,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(23,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(24,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(25,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(26,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(27,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(28,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(29,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));
        TableData.add(new ModelClass(30,"James Chukwuedo",	"8142605775",	"3,GANIYU ENITAN STREET OPPOSITE ORCHID HOTEL ,LEKKI 2ND TOLL GATE" ));

        Table.setItems(null);
        col1.setCellValueFactory(new PropertyValueFactory<>("num"));
        col2.setCellValueFactory(new PropertyValueFactory<>("col1"));
        col3.setCellValueFactory(new PropertyValueFactory<>("col2"));
        col4.setCellValueFactory(new PropertyValueFactory<>("col3"));


        Table.setItems(TableData);


    }

    public void TableControls(ActionEvent event) throws Exception{
        fileWriter = new FileWriter(file2);
        if(event.getSource().equals(headerText)){
            if(ActiveElement.equalsIgnoreCase("TextField")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TextUnFocus:")) {
                        String l = "\t\tTextUnFocus: "+ "#"+headerText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }else  if(ActiveElement.equalsIgnoreCase("Glyph")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("GlyphStroke:")) {
                        String l = "\t\tGlyphStroke: "+ "#"+headerText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }else  if(ActiveElement.equalsIgnoreCase("Scroll")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("ScrollBackground:")) {
                        String l = "\t\tScrollBackground: "+ "#"+headerText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            } else {
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TableText:")) {
                        String l = "\t\tTableText: "+ "#"+headerText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }
        }
        if(event.getSource().equals(headerColor)){
            if(ActiveElement.equalsIgnoreCase("TextField")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TextFocus:")) {
                        String l = "\t\tTextFocus: "+ "#"+headerColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }else  if(ActiveElement.equalsIgnoreCase("Glyph")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("GlyphFill:")) {
                        String l = "\t\tGlyphFill: "+ "#"+headerColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }else  if(ActiveElement.equalsIgnoreCase("Scroll")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("ScrollForeGround:")) {
                        String l = "\t\tScrollForeGround: "+ "#"+headerColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            } else  {
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TableHeader:")) {
                        String l = "\t\tTableHeader: "+ "#"+headerColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }


        }
        if(event.getSource().equals(SelectedColor)){
            if(ActiveElement.equalsIgnoreCase("TextField")){
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TextSelected:")) {
                        String l = "\t\tTextSelected: "+ "#"+SelectedColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            } else {
                for (int x =0; x < allLines.size() ; x++) {
                    if (allLines.get(x).contains("TableSelected:")) {
                        String l = "\t\tTableSelected: "+ "#"+SelectedColor.getValue().toString().toUpperCase().substring(2,8)+"; ";
                        allLines.set(x, l);
                    }
                }
            }

        }
        if(event.getSource().equals(OddRows)){
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("OddRow:")) {
                    String l = "\t\tOddRow: "+ "#"+OddRows.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
        }   if(event.getSource().equals(OddText)){
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("OddText:")) {
                    String l = "\t\tOddText: "+ "#"+OddText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
        }   if(event.getSource().equals(EvenRows)){
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("EvenRow:")) {
                    String l = "\t\tEvenRow: "+ "#"+EvenRows.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
        }
        if(event.getSource().equals(EvenText)){
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("EvenText:")) {
                    String l = "\t\tEvenText: "+ "#"+EvenText.getValue().toString().toUpperCase().substring(2,8)+"; ";
                    allLines.set(x, l);
                }
            }
        }
        if(event.getSource().equals(TableTxtSize)){
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("TableSize")) {
                    String l = "-fx-font-size: "+ TableTxtSize.getText()+"px; /* TableSize*/";
                    allLines.set(x, l);
                }
            }
        }



        for(String line : allLines){
            fileWriter.write(line);
            fileWriter.write("\n");
        }
        fileWriter.close();
        rootPane.getStylesheets().remove(0);
        rootPane.getStylesheets().add(tempStyle);



    }

    public void ButtonControls(File originalFile)throws Exception{

        fileWriter = new FileWriter(file2);
        if(ButtonStates.getSelectionModel().getSelectedIndex() == 0){
            Files.copy(originalFile.toPath(), buttonImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("ButtonImage")) {
                    buttonImage = originalFile;
//                    String l = "\t-fx-background-image:url('file:/\\/\\/"+buttonImage.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                    allLines.set(x, l);
                }
            }
        }
        if(ButtonStates.getSelectionModel().getSelectedIndex() == 1){
            Files.copy(originalFile.toPath(), butHover.toPath(), StandardCopyOption.REPLACE_EXISTING);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("ButHover")) {
                    butHover = originalFile;
//                    String l = "\t-fx-background-image:url('file:/\\/\\/"+butHover.getAbsolutePath().replace("\\","/\\")+"');  /* ButHover */ ";
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* ButHover */ ";
                    allLines.set(x, l);
                }
            }
        }
        if(ButtonStates.getSelectionModel().getSelectedIndex() == 2){
            Files.copy(originalFile.toPath(), butFocused.toPath(), StandardCopyOption.REPLACE_EXISTING);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("ButFocused")) {
                    butFocused = originalFile;
//                    String l = "\t-fx-background-image:url('file:/\\/\\/"+butFocused.getAbsolutePath().replace("\\","/\\")+"');  /* ButFocused */ ";
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* ButFocused */ ";
                    allLines.set(x, l);
                }
            }
        }
        for(String line : allLines){
            try {
                fileWriter.write(line);
                fileWriter.write("\n");
            } catch (IOException ignored) {

            }
        }
        fileWriter.close();
        rootPane.getStylesheets().remove(0);
        rootPane.getStylesheets().add(tempStyle);
    }

    public void TabControls(File originalFile) throws Exception{
        fileWriter = new FileWriter(file2);
        if(ButtonStates.getSelectionModel().getSelectedIndex() == 0){
            Files.copy(originalFile.toPath(), buttonImage.toPath(), StandardCopyOption.REPLACE_EXISTING);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("TabFGround")) {
                    TabFGround = originalFile;
//                    String l = "\t-fx-background-image:url('file:/\\/\\/"+buttonImage.getAbsolutePath().replace("\\","/\\")+"');  /* ButtonImage */ ";
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* TabFGround */ ";
                    allLines.set(x, l);
                }
            }
        }
        if(ButtonStates.getSelectionModel().getSelectedIndex() == 1){
            Files.copy(originalFile.toPath(), butHover.toPath(), StandardCopyOption.REPLACE_EXISTING);
            for (int x =0; x < allLines.size() ; x++) {
                if (allLines.get(x).contains("TabBGround")) {
                    TabBGround = originalFile;
//                    String l = "\t-fx-background-image:url('file:/\\/\\/"+butHover.getAbsolutePath().replace("\\","/\\")+"');  /* ButHover */ ";
                    String l = "\t-fx-background-image:url('file:/\\/\\/"+originalFile.getAbsolutePath().replace("\\","/\\")+"');  /* TabBGround */ ";
                    allLines.set(x, l);
                }
            }
        }
        for(String line : allLines){
            try {
                fileWriter.write(line);
                fileWriter.write("\n");
            } catch (IOException ignored) {

            }
        }
        fileWriter.close();
        rootPane.getStylesheets().remove(0);
        rootPane.getStylesheets().add(tempStyle);
    }


}


