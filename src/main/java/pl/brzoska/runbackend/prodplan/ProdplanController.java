package pl.brzoska.runbackend.prodplan;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:3000")
public class ProdplanController {

    private final ProdplanService prodplanService;

    @GetMapping("prodplan")
    public List<Prodplan> getAll() {
        return prodplanService.getAll();
    }

    @PostMapping(value = "prodplan", consumes = {"multipart/form-data"})
    public String uploadProdplan(@RequestPart("file") MultipartFile file) throws IOException {
        prodplanService.deleteAll();
        prodplanService.uploadProdplan(file);
        return file.getName();
    }

    @DeleteMapping(value = "prodplan/delete")
    public ResponseEntity<String> delete() {
        prodplanService.deleteAll();
        return ResponseEntity.ok("Wszystko ok...");
    }

}
