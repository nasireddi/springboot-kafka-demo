package com.example.demo.producer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Naresh
 *
 */
@RestController
public class MessageProducerController {
	@Autowired
    private Sender sender;
	/**
	 * For testing producer
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "test", method = RequestMethod.GET,
			produces = { "application/json", "application/xml" })
	public Map testMessage(@RequestParam("message") String message) {
		Map map=new HashMap<>();
		map.put("message",message);
		sender.send(message);
		return map;
	}

}
