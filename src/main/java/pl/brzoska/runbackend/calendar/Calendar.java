package pl.brzoska.runbackend.calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Calendar {

    @Id
    @GeneratedValue
    private Long id;
    private String date;
    private Integer vanning;
    private Integer production;
}
