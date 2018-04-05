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
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@UIScope
@SpringComponent
public class AddDomainAndClassCategoryLayout extends VerticalLayout {

    @Autowired
    private RestClientServiceProvider restClientServiceProvider;

    private AddTextField domainCategoryTextField;
    private AddTextField classCategoryTextField;
    private SaveButton saveButton;
    private ErrorLabel domainErrorLabel;
    private ErrorLabel classErrorLabel;

    @PostConstruct
    public void init() {
        setLayout();
        setDomainField();
        setClassField();

    }

    private void setLayout() {
        setSizeFull();
        setDefaultComponentAlignment(Alignment.TOP_LEFT);
    }

    private void setDomainField() {
        new CustomLabel("Категория сферы услуг", this);
        domainCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        domainCategoryTextField.addValueChangeListener(this::valueChange);
        addComponent(domainCategoryTextField);
        domainErrorLabel = new ErrorLabel(this);
    }

    private void setClassField() {
        new CustomLabel("Категория вида услуг", this);
        classCategoryTextField = new AddTextField("Укажите категорию вида услуг", true);
        addComponent(classCategoryTextField);
        classCategoryTextField.addValueChangeListener(this::valueChange);
        classErrorLabel = new ErrorLabel(this);
    }

    public void setSaveButton(Layout rootLayout, Component... removeComponents) {
        saveButton = new SaveButton(true);
        addComponent(saveButton);
        setComponentAlignment(saveButton, Alignment.BOTTOM_RIGHT);
        saveButton.addClickListener(e -> {
            ResponseEntity response = restClientServiceProvider.saveDomainCategoryWithClassCategory(new DomainCategoryMapper(
                    domainCategoryTextField.getValue(),
                    classCategoryTextField.getValue()));
            if (response.getStatusCodeValue() == 201) {
                rootLayout.replaceComponent(this,
                        new SavedLayout(domainCategoryTextField.getValue(),
                                classCategoryTextField.getValue(),
                                "Значение сохранено "));
                Arrays.stream(removeComponents).forEach(rootLayout::removeComponent);
            } else {
                domainCategoryTextField.showError();
                domainErrorLabel.showError();
                classCategoryTextField.showError();
                classErrorLabel.showError();
            }
        });
    }

    private void valueChange(HasValue.ValueChangeEvent<String> e) {
        domainCategoryTextField.hideError();
        classCategoryTextField.hideError();
        domainErrorLabel.hideError();
        classErrorLabel.hideError();
    }
}
