package pl.brzoska.runbackend.rundown;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
@CrossOrigin(origins = "http://localhost:3000")
public class RundownController {

    private final RundownService rundownService;

    @GetMapping("rundown")
    public List<Rundown> getAll() {
        return rundownService.getAll();
    }

    @PostMapping(value = "rundown", consumes = {"multipart/form-data"})
    public Integer uploadRundown(@RequestPart("file") MultipartFile file) throws IOException {
        rundownService.deleteAll();
        return rundownService.uploadRundown(file);
    }

    @DeleteMapping(value = "rundown/delete")
    public ResponseEntity<String> delete() {
        rundownService.deleteAll();
        return ResponseEntity.ok("Wszystko ok...");
    }



}
