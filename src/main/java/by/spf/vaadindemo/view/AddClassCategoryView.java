package by.spf.vaadindemo.view;

import by.spf.vaadindemo.domain.ClassCategory;
import by.spf.vaadindemo.domain.DomainCategory;
import by.spf.vaadindemo.util.RestClientServiceProvider;
import com.vaadin.navigator.Navigator;
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
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@SpringView(name = AddClassCategoryView.VIEW_NAME)
public class AddClassCategoryView extends GridLayout implements View {
    static final String VIEW_NAME = "addClassCategory";

    @Autowired
    private RestClientServiceProvider restClientServiceProvider;

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
        ComboBox<DomainCategory> domainCategory = new ComboBox<>();
        domainCategory.setItems(restClientServiceProvider.getDomainCategories());
        domainCategory.setTextInputAllowed(false);
        domainCategory.setPlaceholder("Выбрать категорию сферы услуг");
        domainCategory.setItemCaptionGenerator(DomainCategory::getName);
        domainCategory.setEmptySelectionAllowed(false);
        domainCategory.setWidth(100.0f, Unit.PERCENTAGE);
        addComponent(domainCategory, 1, 2, 3, 2);

        Label classLabel = new Label("Категория вида услуг");
        addComponent(classLabel, 1, 3);
        setComponentAlignment(classLabel, Alignment.MIDDLE_LEFT);

        TextField textSearch = new TextField();
        textSearch.setWidth("100%");
        textSearch.setPlaceholder("Укажите категорию вида услуг");
        textSearch.setStyleName("v-textfield-provider-search");
        addComponent(textSearch, 1, 4, 3, 4);

        Label findLabel = new Label("Искомая категория сферы услуг отсутсвует?");
        addComponent(findLabel, 5, 2);

        Button button = new Button("Создать категорию сферы услгу");
        button.setStyleName("link");
        button.addClickListener(e -> getUI().getNavigator().navigateTo("addDomainAndClassCategory"));
        addComponent(button, 5, 3);


        Button save = new Button("Сохранить");

        save.setWidth("100%");
        save.addStyleName("v-button-one");
        save.addClickListener(e -> {
            Notification.show("Value changed:",
                    String.valueOf(domainCategory.getValue()),
                    Notification.Type.TRAY_NOTIFICATION);
        });
        addComponent(save, 2, 6,3,6);
        setComponentAlignment(save, Alignment.BOTTOM_CENTER);

    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
