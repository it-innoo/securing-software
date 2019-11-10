package sec.notebook;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class NotebookController {

    private final List<String> notes;

    public NotebookController() {
        this.notes = new ArrayList<>();
    }
    
    @RequestMapping("/")
    public String home(Model model, @RequestParam(required = false) String content) {
        if (content != null && !content.trim().isEmpty()) {
            this.notes.add(content.trim());
        }

        if (notes.size() > 10) {
            model.addAttribute("notes", notes.subList(notes.size()-10, notes.size()));
        } else {
            model.addAttribute("notes", notes);
        }

        return "index";
    }
}
