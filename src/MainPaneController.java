import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
    public JFXColorPicker txtColor;
    public JFXColorPicker bckColor;
    public JFXTextField BckGrad;
    public JFXSlider fntSz;
    public JFXCheckBox isBold;
    public JFXTextField StyName;
    public JFXButton StySave;
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
    private JFXButton ComboBut;

    @FXML
    private JFXButton GlyphBut;

    @FXML
    private JFXButton DateBut;

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

    @FXML
    private JFXColorPicker singlepicker;

    @FXML
    private JFXButton export;


    static String ActiveElement = "";
    Label activeText;
    StringBuilder labelStyle = new StringBuilder();
    static String Color1 ="#FFFFFF ", Color2 ="#FFFFFF ",Color3 ="#FFFFFF ",Color4 ="#FFFFFF ", Slider1 = "0%",  Slider2 = "0%",  Slider3 = "0%",  Slider4 = "0%";

    static String FileLocation = "C:\\Users\\Public\\ThemeCreator\\background.jpg";
    static String OriginalLocation= "";

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void ElementsAction(ActionEvent event){
        if(event.getSource().equals(BackgroundBut)){
            ActiveElement = "Background";
        }

    }


    public void GradientControls(ActionEvent event){

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
        DesignPane.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
        StyleField.setText("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");

    }

    public void SliderControls(MouseEvent event){
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
        DesignPane.setStyle("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");
        StyleField.setText("-fx-background-color: linear-gradient("+Color1+Slider1+", "+Color2+Slider2+", "+Color3+Slider3+","+Color4+Slider4+" )");

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
        DesignPane.setStyle("-fx-background-color: GRAY");
    }

    public void ChooseImage(ActionEvent event) throws IOException {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Select File");
        File file = chooser.showOpenDialog(this.Imagepicker.getScene().getWindow());
        OriginalLocation = file.getAbsolutePath();
        File originalFile = new File(OriginalLocation);
        File copiedFile = new File(FileLocation);
        copiedFile.mkdirs();

        Files.copy(originalFile.toPath(), copiedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        FileLocation = copiedFile.getAbsolutePath();
        Image img = new Image("file:\\"+FileLocation);
        BackgroundSize size = new BackgroundSize(1.0, 1.0, true, true, true, true );
        Background background = new Background(new BackgroundImage(img, BackgroundRepeat.NO_REPEAT , BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, size));
        DesignPane.setBackground(background);
    }

    //LABEL CONTROLS

    public void ActiveText(MouseEvent event){
        SamTxt1.underlineProperty().set(false);
        SamTxt2.underlineProperty().set(false);
        SamTxt3.underlineProperty().set(false);
        SamTxt4.underlineProperty().set(false);
        SamTxt5.underlineProperty().set(false);


        if (event.getSource().equals(SamTxt1)) {
            activeText = SamTxt1;
        }
        if (event.getSource().equals(SamTxt2)) {
            activeText = SamTxt2;
        }
        if (event.getSource().equals(SamTxt3)) {
            activeText = SamTxt3;
        }
        if (event.getSource().equals(SamTxt4)) {
            activeText = SamTxt4;
        }
        if (event.getSource().equals(SamTxt5)) {
            activeText = SamTxt5;
        }
        activeText.underlineProperty().set(true);

    }

    public void LabelControls(ActionEvent event){

        if (event.getSource().equals(txtColor)) {
            labelStyle.append("-fx-text-fill: " + "#").append(txtColor.getValue().toString().substring(2, 8).toUpperCase()).append(";");
        }
        if (event.getSource().equals(bckColor)) {
            labelStyle.append("-fx-background-color: " + "#").append(bckColor.getValue().toString().substring(2, 8).toUpperCase());
        }
        activeText.setStyle(String.valueOf(labelStyle));
    }





}


