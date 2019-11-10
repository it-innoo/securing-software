package sec.calculator;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add(@RequestParam Integer first, @RequestParam Integer second) {
        return String.valueOf(first + second);
    }

    @RequestMapping(value = "/multiply", method = RequestMethod.GET)
    @ResponseBody
    public String multiply(@RequestParam Integer first, @RequestParam Integer second) {
        return String.valueOf(first * second);
    }
}
