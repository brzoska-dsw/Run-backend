package pl.brzoska.runbackend.rundown;

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
public class Rundown {

    @Id
    @GeneratedValue
    private Long id;
    private String vanning;
    private String loading;
    private String unloading;

}

