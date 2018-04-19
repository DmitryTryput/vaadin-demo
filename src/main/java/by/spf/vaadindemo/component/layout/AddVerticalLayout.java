package by.spf.vaadindemo.component.layout;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;
import lombok.Getter;

@Getter
public class AddVerticalLayout extends VerticalLayout {

    private VerticalLayout fieldsLayout;
    private HorizontalLayout buttonLayout;

    public AddVerticalLayout() {
        setDefaultComponentAlignment(Alignment.TOP_RIGHT);
        fieldsLayout = new VerticalLayout();
        addComponent(fieldsLayout);
        buttonLayout = new HorizontalLayout();
        buttonLayout.setSpacing(true);
        buttonLayout.setMargin(true);
        buttonLayout.setDefaultComponentAlignment(Alignment.BOTTOM_RIGHT);
        addComponent(buttonLayout);
        setExpandRatio(fieldsLayout, 6.0f);
        setExpandRatio(buttonLayout, 4.0f);
    }
}
