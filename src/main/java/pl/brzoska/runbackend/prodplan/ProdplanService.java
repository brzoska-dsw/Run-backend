package pl.brzoska.runbackend.prodplan;

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
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Data
public class ProdplanService {

    private final ProdplanRepository repository;

    public Integer uploadProdplan(MultipartFile file) {
        List<Prodplan> prodplans = parseCsv(file);
        repository.saveAll(prodplans);
        return prodplans.size();
    }

    private List<Prodplan> parseCsv(MultipartFile file) {

        List<Prodplan> data = new ArrayList<>();
        BufferedReader br;

        try {
            String line;
            String[] splitLine;
            InputStream is = file.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));

            while ((line = br.readLine()) != null) {

                splitLine = line.split(",");
                data.add(new Prodplan(0L, splitLine[0], splitLine[1]));
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        
        return data;
    }

    public void deleteAll(){repository.deleteAll();}

    public List<Prodplan> getAll() {
        return repository.findAll();
    }
}
