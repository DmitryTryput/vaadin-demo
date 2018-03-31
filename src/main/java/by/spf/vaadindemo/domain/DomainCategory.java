package by.spf.vaadindemo.domain;



import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Data
@NoArgsConstructor
public class DomainCategory {


    private Long id;


    private String name;

    private Set<ClassCategory> classCategories = new HashSet<>();

    public DomainCategory(String name) {
        this.name = name;
    }
}
