package org.kubo.demo.controller;

import com.alibaba.fastjson2.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.codec.multipart.FilePart;
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

    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, value = "/ptz/{id}/status/detect")
    public Mono<JSONObject> addPtzStatusByFile(@PathVariable(value = "id") String id, @RequestPart(value = "file", required = false) List<FilePart> file,
                                               @RequestPart(value = "desc", required = false) String desc, @RequestPart(value = "status", required = false) String status) {
        log.info(status);
        log.info("status");
        JSONObject data = new JSONObject();
        data.put("res","success");
        return Mono.just(data);
    }
}
