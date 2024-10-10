package pl.kwojcik.project_lab.user;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import pl.kwojcik.project_lab.user.model.UserEntity;

import java.math.BigDecimal;

// #Zadanie_3__1
//start L3 Podstawienia Liskov w 3 klasach
@Entity
public class CustomerUserEntity extends UserEntity {
    @Getter
    @Setter
    public BigDecimal discount;
}
