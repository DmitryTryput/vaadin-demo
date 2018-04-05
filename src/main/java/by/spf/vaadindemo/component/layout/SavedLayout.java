package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.ReturnButton;
import by.spf.vaadindemo.component.SavedTextField;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

public class SavedLayout extends VerticalLayout {

    public SavedLayout(String domainTextField, String classTextField, String saveText) {
        setSizeFull();
        setDefaultComponentAlignment(Alignment.TOP_LEFT);
        setField(domainTextField, "Категория сферы услуг");
        setField(classTextField, "Категория вида услуг");
        setReturnButton(saveText);

    }

    private void setField(String domainTextField, String s) {
        new CustomLabel(s, this);
        addComponent(new SavedTextField(domainTextField));
        new ErrorLabel(this);
    }

    private void setReturnButton(String saveText) {
        HorizontalLayout buttonLayout = new HorizontalLayout();
        Label saveLabel = new Label(saveText);
        saveLabel.setStyleName("v-label-save");
        buttonLayout.addComponent(saveLabel);
        buttonLayout.setComponentAlignment(saveLabel, Alignment.MIDDLE_CENTER);
        ReturnButton returnButton = new ReturnButton();
        buttonLayout.addComponent(returnButton);
        addComponent(buttonLayout);
        setComponentAlignment(buttonLayout, Alignment.BOTTOM_RIGHT);
    }
}
