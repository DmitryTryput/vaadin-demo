package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.ReturnButton;
import by.spf.vaadindemo.component.SavedTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;


public class SavedLayout extends CustomVerticalLayout {

    public SavedLayout(String domainTextField, String classTextField) {
        super();
        setField(domainTextField, "Категория сферы услуг");
        setField(classTextField, "Категория вида услуг");
        setReturnButton();

    }

    private void setField(String domainTextField, String label) {
        new CustomLabel(label, getFieldsLayout());
        getFieldsLayout().addComponent(new SavedTextField(domainTextField));
        new ErrorLabel(getFieldsLayout());
    }

    private void setReturnButton() {
        Label saveLabel = new Label("Значение сохранено!");
        saveLabel.setStyleName("v-label-save");
        getButtonLayout().addComponent(saveLabel);
        getButtonLayout().setComponentAlignment(saveLabel, Alignment.MIDDLE_CENTER);
        ReturnButton returnButton = new ReturnButton();
        getButtonLayout().addComponent(returnButton);
    }
}
