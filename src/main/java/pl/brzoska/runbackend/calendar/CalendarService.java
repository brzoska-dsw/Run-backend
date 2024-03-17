package pl.brzoska.runbackend.calendar;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CalendarService {

    private final CalendarRepository repository;


    public Integer uploadStudents(MultipartFile file) throws IOException {
        Set<Calendar> calendar = parseCsv(file).stream()
                .sorted(Comparator.comparing(Calendar::getDate))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        repository.saveAll(calendar);
        return calendar.size();
    }

    private Set<Calendar> parseCsv(MultipartFile file) throws IOException {
        try (Reader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            HeaderColumnNameMappingStrategy<CalendarCsvRepresentation> strategy = new HeaderColumnNameMappingStrategy<>();

            strategy.setType(CalendarCsvRepresentation.class);

            CsvToBean<CalendarCsvRepresentation> csvToBean = new CsvToBeanBuilder<CalendarCsvRepresentation>(reader)
                    .withMappingStrategy(strategy)
                    .withIgnoreEmptyLine(true)
                    .withIgnoreLeadingWhiteSpace(true)
                    .build();

            return csvToBean.parse().stream().map(csvLine -> Calendar.builder().date(csvLine.getDday()).vanning(csvLine.getVday()).production(csvLine.getPday()).build()).collect(Collectors.toSet());
        }
    }

    public List<Calendar> getAll() {
        return repository.findAll();
    }
    public void deleteAll(){
        repository.deleteAll();
    }
}
