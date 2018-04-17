package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.AddTextField;
import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.SaveButton;
import by.spf.vaadindemo.mapping.DomainCategoryMapper;
import by.spf.vaadindemo.util.RestClientServiceProvider;
import com.vaadin.data.HasValue;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@UIScope
@SpringComponent
public class AddDomainAndClassCategoryLayout extends CustomVerticalLayout {

    @Autowired
    private RestClientServiceProvider restClientServiceProvider;

    private AddTextField domainCategoryTextField;
    private AddTextField classCategoryTextField;

    private SaveButton saveButton;
    private ErrorLabel domainErrorLabel;
    private ErrorLabel classErrorLabel;

    @PostConstruct
    public void init() {
        setDomainField();
        setClassField();
        setSaveButton();
    }


    private void setDomainField() {
        new CustomLabel("Категория сферы услуг", getFieldsLayout());
        domainCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        domainCategoryTextField.addValueChangeListener(this::valueChange);
        getFieldsLayout().addComponent(domainCategoryTextField);
        domainErrorLabel = new ErrorLabel(getFieldsLayout());
    }

    private void setClassField() {
        new CustomLabel("Категория вида услуг", getFieldsLayout());
        classCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        getFieldsLayout().addComponent(classCategoryTextField);
        classCategoryTextField.addValueChangeListener(this::valueChange);
        classErrorLabel = new ErrorLabel(getFieldsLayout());
    }

    public void setSaveButton() {
        saveButton = new SaveButton(true);
        getButtonLayout().addComponent(saveButton);
        getButtonLayout().setComponentAlignment(saveButton, Alignment.BOTTOM_RIGHT);
    }

    private void valueChange(HasValue.ValueChangeEvent<String> e) {
        domainCategoryTextField.hideError();
        classCategoryTextField.hideError();
        domainErrorLabel.hideError();
        classErrorLabel.hideError();
    }
}
