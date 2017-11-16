#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.handler;

import ${package}.model.ExampleResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
@CrossOrigin
public class ExampleController {

	@RequestMapping("/hello/{name}")
	@ResponseBody
	public ExampleResponse parse(@PathVariable String name)
	{
		ExampleResponse response = new ExampleResponse(name);
		return response;
	}
}
