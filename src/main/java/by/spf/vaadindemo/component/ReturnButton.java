package by.spf.vaadindemo.component;

import com.vaadin.ui.Button;

public class ReturnButton extends Button {
    public ReturnButton() {
        super();
        setCaption("Вернуться");
        setStyleName("v-button-saved ");
        addClickListener(event ->
                getUI().getPage().reload());
    }
}
