# b3multi-reproducer
To demonstrate the B3 propagation with the azure applicationinsights-java agent. 

## prerequisites

- An active azure subscription and a [Application Insights](https://docs.microsoft.com/en-us/azure/azure-monitor//app/app-insights-overview) instance
- The current version of java and maven installed on your machine

## run as jar
- SET APPLICATIONINSIGHTS_CONNECTION_STRING env variable for your AI instance.
- SET OTEL_PROPAGATORS="tracecontext,b3multi,baggage" as env variable.
- mvn package
- java -javaagent:"<path-to>/applicationinsights-agent-3.3.0-BETA-SNAPSHOT.jar" -jar target/b3multi-reproducer-0.0.1-SNAPSHOT.jar


## send requests with b3 headers
See at the trace.http file.

### B3-multi header request
Here you can see that the passed trace id is different from the trace id determined from the context. 

 ```
{
    "b3TraceId": "63ac35c9f6413ad48485a3953bb6124",
    "insightsTraceId": "b244004e33e42b44b67c9b105238014f"
}
 ```

### B3-single header
Here is the responding trace id equalant to the part of the b3 header.

Header <br>
b3: **80f198ee56343ba864fe8b2a57d3eff7**-e457b5a2e4d86bd1-1-05e3ac9a4f6e3b90
 ```
{
    "b3TraceId": null,
    "insightsTraceId": "80f198ee56343ba864fe8b2a57d3eff7"
}
 ```



