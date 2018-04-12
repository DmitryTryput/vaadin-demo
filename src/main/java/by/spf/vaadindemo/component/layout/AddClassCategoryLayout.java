package by.spf.vaadindemo.component.layout;

import by.spf.vaadindemo.component.AddTextField;
import by.spf.vaadindemo.component.CustomLabel;
import by.spf.vaadindemo.component.ErrorLabel;
import by.spf.vaadindemo.component.SaveButton;
import by.spf.vaadindemo.domain.DomainCategory;
import by.spf.vaadindemo.mapping.ClassCategoryMapper;
import by.spf.vaadindemo.util.RestClientServiceProvider;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.Layout;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@UIScope
@SpringComponent
public class AddClassCategoryLayout extends VerticalLayout {

    @Autowired
    private RestClientServiceProvider restClientServiceProvider;

    private ComboBox<DomainCategory> domainCategoryComboBox;
    private AddTextField classCategoryTextField;
    private SaveButton saveButton;
    private ErrorLabel errorLabel;

    @PostConstruct
    public void init() {
        setLayout();
        setDomainComboBox();
        setClassCategoryField();
    }

    private void setLayout() {
        setDefaultComponentAlignment(Alignment.TOP_RIGHT);
    }

    private void setDomainComboBox() {
        new CustomLabel("Категория сферы услуг", this);
        domainCategoryComboBox = new ComboBox<>();
        domainCategoryComboBox.addStyleName("v-combobox");
        domainCategoryComboBox.setItems(restClientServiceProvider.getDomainCategories());
        domainCategoryComboBox.setTextInputAllowed(false);
        domainCategoryComboBox.setWidth("100%");
        domainCategoryComboBox.setPlaceholder("Выбрать категорию сферы услуг");
        domainCategoryComboBox.setItemCaptionGenerator(DomainCategory::getName);
        domainCategoryComboBox.setEmptySelectionAllowed(false);
        domainCategoryComboBox.addValueChangeListener(event -> classCategoryTextField.setEnabled(true));
        addComponent(domainCategoryComboBox);
        new ErrorLabel( this);
    }

    private void setClassCategoryField() {
        new CustomLabel("Категория вида услуг", this);
        classCategoryTextField = new AddTextField("Укажите категорию вида услуг", false);
        classCategoryTextField.addValueChangeListener(e -> {
            errorLabel.hideError();
            classCategoryTextField.hideError();
            if (!classCategoryTextField.isEmpty()) {
                saveButton.setButtonEnable();
            } else {
                saveButton.setButtonDisable();
            }
        });
        addComponent(classCategoryTextField);
        errorLabel = new ErrorLabel( this);
    }

    public void setSaveButton(Layout rootLayout, Layout replacedLayout, Component ... removeComponents) {
        saveButton = new SaveButton(false);
        addComponent(saveButton);
        setComponentAlignment(saveButton, Alignment.BOTTOM_RIGHT);
        saveButton.addClickListener(e -> {
            Long domainCategoryId = domainCategoryComboBox.getValue().getId();
            ClassCategoryMapper classCategoryMapper = new ClassCategoryMapper(
                    classCategoryTextField.getValue());
            ResponseEntity response = restClientServiceProvider.saveClassCategory(domainCategoryId, classCategoryMapper);
            if (response.getStatusCode() == HttpStatus.CREATED) {
                rootLayout.replaceComponent(replacedLayout,
                        new SavedLayout(domainCategoryComboBox.getValue().getName(),
                                classCategoryTextField.getValue(),
                                "Значения сохранены! "));
                Arrays.stream(removeComponents).forEach(rootLayout::removeComponent);
            } else {
                classCategoryTextField.showError();
                errorLabel.showError();
            }
        });
    }
}
