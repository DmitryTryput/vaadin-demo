package by.spf.vaadindemo.component;


import com.vaadin.ui.Button;

public class SaveButton extends Button {
    public SaveButton(boolean enable) {
        super();
        setCaption("Сохранить");
        setStyleName(enable ? "v-button-one" : "v-button-disable");
        setEnabled(enable);
    }

    public void setButtonEnable() {
        setEnabled(true);
        setStyleName("v-button-one");
    }

    public void setButtonDisable() {
        setEnabled(false);
        setStyleName("v-button-disable");
    }

}
