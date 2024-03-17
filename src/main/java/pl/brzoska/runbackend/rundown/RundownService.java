package pl.brzoska.runbackend.rundown;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data
public class RundownService {

    private final RundownRepository repository;

    public Integer uploadRundown(MultipartFile file) {
        List<Rundown> rundownDates = parseCsv(file);
        repository.saveAll(rundownDates);
        return rundownDates.size();
    }

    private List<Rundown> parseCsv(MultipartFile file) {

        List<Rundown> data = new ArrayList<>();
        BufferedReader br;
        System.out.println(data);

        try {
            String line;
            String[] splitLine;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                splitLine = line.split(",");
                data.add(new Rundown(0L, splitLine[0], splitLine[1], splitLine[2]));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return data;
    }

    public void deleteAll(){repository.deleteAll();}

    public List<Rundown> getAll() {
        return repository.findAll();
    }
}


