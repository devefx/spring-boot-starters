package org.devefx.spring.boot.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

/**
 * TimeController
 *
 * @author Yoke
 * @since 1.0
 */
@RestController
public class TimeController {

    @ResponseBody
    @GetMapping("/now")
    public LocalDate now() {
        return LocalDate.now();
    }
}
