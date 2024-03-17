package pl.brzoska.runbackend.prodplan;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Prodplan {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private String prodValue;

}
