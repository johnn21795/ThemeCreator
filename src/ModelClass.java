import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class ModelClass {
    private final SimpleIntegerProperty num;
    private final SimpleStringProperty col1;
    private final SimpleStringProperty col2;
    private final SimpleStringProperty col3;
    private final SimpleBooleanProperty checked;



    public ModelClass(int num, String col1, String col2, String col3, boolean checked){
        this.num = new SimpleIntegerProperty(num);
        this.col1 = new SimpleStringProperty(col1);
        this.col2 = new SimpleStringProperty(col2);
        this.col3 = new SimpleStringProperty(col3);
        this.checked = new SimpleBooleanProperty(checked);



    }

    public int getNum() {
        return num.get();
    }
    public void setNum(int num) {
        this.num.set(num);
    }

    public String getCol1() {
        return col1.get();
    }
    public void setCol1(String col1) {
        this.col1.set(col1);
    }

    public String getCol2() {
        return col2.get();
    }
    public void setCol2(String col2) {
        this.col2.set(col2);
    }

    public String getCol3() {
        return col3.get();
    }
    public void setCol3(String col3) {
        this.col3.set(col3);
    }

    public boolean getChecked() {
        return checked.get();
    }
    public void setChecked(boolean checked) {
        this.checked.set(checked);
    }
    public BooleanProperty checkedProperty(){
        return checked;
    }
}
