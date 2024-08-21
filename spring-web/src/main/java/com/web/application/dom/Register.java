package com.web.dom;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//@Data
@Entity
@Table(name= "register" ,
        uniqueConstraints = {@UniqueConstraint(columnNames = "id") ,
                @UniqueConstraint(columnNames = "username")})

@EqualsAndHashCode(callSuper = false)  // Calls equals/hashCode from BaseEntity
//@Cacheable
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Register extends AbstractRegister {

}