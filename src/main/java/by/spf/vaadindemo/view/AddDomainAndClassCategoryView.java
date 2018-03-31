package by.spf.vaadindemo.view;

import by.spf.vaadindemo.domain.DomainCategory;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

import javax.annotation.PostConstruct;

@SpringView(name = AddDomainAndClassCategoryView.VIEW_NAME)
public class AddDomainAndClassCategoryView extends GridLayout implements View {
    static final String VIEW_NAME = "addDomainAndClassCategory";

    @PostConstruct
    void init() {

        super.setColumns(7);
        super.setRows(7);
        super.setSpacing(true);
        super.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        super.setWidth("100%");

        Label domainLabel = new Label("Категория сферы услуг");
        addComponent(domainLabel, 1, 1);
        setComponentAlignment(domainLabel, Alignment.MIDDLE_LEFT);

        TextField domainField = new TextField();
        domainField.setWidth("100%");
        domainField.setPlaceholder("Укажите категорию сферы услуг");
        domainField.setStyleName("v-textfield-provider-search");
        addComponent(domainField, 1, 2, 3, 2);

        Label classLabel = new Label("Категория вида услуг");
        addComponent(classLabel, 1, 3);
        setComponentAlignment(classLabel, Alignment.MIDDLE_LEFT);

        TextField classField = new TextField();
        classField.setWidth("100%");
        classField.setPlaceholder("Укажите категорию вида услуг");
        classField.setStyleName("v-textfield-provider-search");
        addComponent(classField, 1, 4, 3, 4);

        Label findLabel = new Label("Передумали создавать категорию сферы услуг?");
        addComponent(findLabel, 5, 2);

        Button button = new Button("Выбрать существующую категорию сферы услгу");
        button.setStyleName("link");
        button.addClickListener(e -> getUI().getNavigator().navigateTo("addClassCategory"));
        addComponent(button, 5, 3);


        Button save = new Button("Сохранить");

        save.setWidth("100%");
        save.addStyleName("v-button-one");
        save.addClickListener(e -> {
            Notification.show("Value changed:",
                    String.valueOf(domainField.getValue()),
                    Notification.Type.TRAY_NOTIFICATION);
        });
        addComponent(save, 2, 6,3,6);
        setComponentAlignment(save, Alignment.BOTTOM_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }
}
