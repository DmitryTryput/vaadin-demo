package by.spf.vaadindemo.component;


import com.vaadin.ui.AbstractOrderedLayout;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;

public class CustomLabel extends Label {

    public CustomLabel(String text, AbstractOrderedLayout layout) {
        super(text);
        setStyleName("v-label-text");
        layout.addComponent(this);
        layout.setComponentAlignment(this, Alignment.BOTTOM_LEFT);
    }
}
