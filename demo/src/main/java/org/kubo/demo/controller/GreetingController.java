package org.kubo.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@Slf4j
public class GreetingController {

    @PostMapping(value = "/111")
    public Mono<Object> updateMultiPtzStatus() {
        log.info("ok");
        return Mono.just("ok");
    }

    @PostMapping(value = "/{id}/status/detect")
    public Mono<String> addPtzStatusByFile(@PathVariable(value = "id") String id, @RequestPart(value = "file", required = false) List<MultipartFile> file,
                                                   @RequestPart(value = "desc", required = false) String desc, @RequestPart(value = "status", required = false) String status) {
        return Mono.just("success");
    }
}
