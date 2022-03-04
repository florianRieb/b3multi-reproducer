package com.example.b3multireproducer.web;

import io.opentelemetry.api.trace.Span;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Slf4j
@RequestMapping("b3")
@RestController
public class Controller {

  @GetMapping
  public Mono<TraceResponse> getTraceId(@RequestHeader("X-B3-TraceId") Optional<String> b3traceId) {

    log.info("Received b3 trace id {}", b3traceId.orElse(null));

    var traceId = Span.current().getSpanContext().getTraceId();
    return Mono.just(new TraceResponse(b3traceId.orElse(null), traceId));

  }

}
