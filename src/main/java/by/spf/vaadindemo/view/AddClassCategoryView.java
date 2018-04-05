package by.spf.vaadindemo.view;

import by.spf.vaadindemo.component.layout.AddClassCategoryLayout;
import by.spf.vaadindemo.component.layout.NavigationLayout;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.GridLayout;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

@UIScope
@SpringView(name = AddClassCategoryView.VIEW_NAME)
public class AddClassCategoryView extends GridLayout implements View {
    static final String VIEW_NAME = "addClassCategory";

    private NavigationLayout navigationLayout;

    @Autowired
    private AddClassCategoryLayout addClassCategoryLayout;


    @PostConstruct
    void init() {
        setView();
        setLayouts();
    }

    private void setView() {
        setColumns(5);
        setRows(4);
        setDefaultComponentAlignment(Alignment.TOP_RIGHT);
        setWidth(100.0f, Unit.PERCENTAGE);
        setHeight(80.0f, Unit.PERCENTAGE);
    }

    private void setLayouts() {
        addComponent(addClassCategoryLayout,0,0,2,3);
        addClassCategoryLayout.setSaveButton(this, addClassCategoryLayout, navigationLayout);
        navigationLayout = new NavigationLayout("Искомая категория сферы услуг отсутсвует?",
                "Создать категорию сферы услуг",
                "addDomainAndClassCategory");
        addComponent(navigationLayout,3,0);
        setComponentAlignment(navigationLayout, Alignment.BOTTOM_CENTER);
    }

    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
    }

}
