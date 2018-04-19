package by.spf.vaadindemo.mapping;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class ClassCategoryMapper {
    @NotEmpty(message = "\'Name\' for domain category must not be empty")
    @Pattern(regexp = "\\D+", message = "\'Name\' should not contain digits")
    @Size(max = 30, message = "\'Name\' for domain category must has length less or equal 30")
    private String name;

    public ClassCategoryMapper(String name) {
        this.name = name;
    }
}
