package pl.brzoska.runbackend.calendar;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CalendarCsvRepresentation {

    @CsvBindByName(column = "date")
    private String dday;
    @CsvBindByName(column = "vanning")
    private Integer vday;
    @CsvBindByName(column = "production")
    private Integer pday;
}
