package net.class101.classmate.interfaces;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LifeCycleController {

    @GetMapping("/health")
    @ResponseStatus(code = HttpStatus.OK)
    public void health() {
    }
}
