package com.web.application.dom;
import jakarta.persistence.*;
import lombok.*;
import javax.persistence.NamedQuery;


@Entity
@Data
@ToString
//@NoArgsConstructor
@AllArgsConstructor
@Table(name= "register" ,
        uniqueConstraints = {@UniqueConstraint(columnNames = "id") ,
                @UniqueConstraint(columnNames = "username")})

@EqualsAndHashCode(callSuper = false)  // Calls equals/hashCode from BaseEntity

@NamedQuery(
        name = "Register.findByRegister",
        query = "FROM Register e WHERE e.department = :department"
)


//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Register extends AbstractRegister {

}