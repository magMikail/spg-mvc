package udm.spg.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by magMikail on 4/21/2019.
 **/
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
