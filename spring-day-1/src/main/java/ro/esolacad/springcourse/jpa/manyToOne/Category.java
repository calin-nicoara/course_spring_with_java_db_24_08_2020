package ro.esolacad.springcourse.jpa.manyToOne;

import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ro.esolacad.springcourse.jpa.Product;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean active;

//    @OneToMany
//    @JoinColumn(name = "category_id")
//    private Set<Product> productSet;
}
