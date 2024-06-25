package hw2_gradle.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@Autowired
	public SampleController(HelloWorldService helloWorldService){
		this.helloWorldService = helloWorldService;
	}

	private final HelloWorldService helloWorldService;

	private Logger logger = LoggerFactory.getLogger(SampleController.class);

	@RequestMapping("/")
	@ResponseBody
	public String helloWorld() {
		logger.info("Кто-то вызвал контроллер hello world на gradle");
		return this.helloWorldService.getHelloMessage();
	}
}