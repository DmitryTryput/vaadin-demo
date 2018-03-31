package by.spf.vaadindemo.domain;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;



@Data
@EqualsAndHashCode(exclude = {"domainCategory"})
@ToString(exclude = {"domainCategory"})
@NoArgsConstructor
public class ClassCategory {


    private Long id;

    private String name;

    private DomainCategory domainCategory;

    public ClassCategory(String name, DomainCategory domainCategory) {
        this.name = name;
        this.domainCategory = domainCategory;
    }
}
