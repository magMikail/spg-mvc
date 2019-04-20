package udm.spg.mvc.controllers;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Mikhail Mahutsiy on 4/21/2019.
 **/

public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
