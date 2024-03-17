package pl.brzoska.runbackend.calendar;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
//@CrossOrigin(origins = "http://localhost:80")
public class CalendarController {

    private final CalendarService service;

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping("calendar")
    public ResponseEntity<List<Calendar>> findAllRecordOfCalendar() {
        return ResponseEntity.ok(service.getAll());
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(value = "calendar", consumes = {"multipart/form-data"})
    public ResponseEntity<String> uploadFiles(
            @RequestPart("file") MultipartFile file
    ) throws IOException {
        return ResponseEntity.ok("Załadowano  " + service.uploadStudents(file) + "  rekordów");
    }

    @DeleteMapping("delete-all")
    public void deleteAll() {
        service.deleteAll();
    }
}
