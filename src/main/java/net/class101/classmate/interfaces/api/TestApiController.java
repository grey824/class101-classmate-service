package net.class101.classmate.interfaces.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class TestApiController {

    @ResponseBody
    @GetMapping("/test")
    public String test() {
        return "success";
    }
}
