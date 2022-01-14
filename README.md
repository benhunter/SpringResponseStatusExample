# ResponseStatus Annotation

-  [Docs](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/ResponseStatus.html)

# Do not use for REST APIs

From docs:

**Warning**: when using this annotation on an exception class, or when setting the `reason` attribute of this annotation, the `HttpServletResponse.sendError` method will be used.

With `HttpServletResponse.sendError`, the response is considered complete and should not be written to any further. Furthermore, the Servlet container will typically write an HTML error page therefore making the use of a `reason` unsuitable for REST APIs. For such cases it is preferable to use a [`ResponseEntity`](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/http/ResponseEntity.html "class in org.springframework.http") as a return type and avoid the use of `@ResponseStatus` altogether.

## Baeldung

https://www.baeldung.com/spring-response-status

Note, that when we mark an _Exception_ class with _@ResponseStatus_, Spring always calls _HttpServletResponse.sendError()__,_ whether we set _reason_ or not.

# Example

```java
import org.springframework.web.bind.annotation.ResponseStatus;  
  
@ResponseStatus(HttpStatus.NOT_FOUND)  
public class TodoNotFoundException extends RuntimeException {
```
