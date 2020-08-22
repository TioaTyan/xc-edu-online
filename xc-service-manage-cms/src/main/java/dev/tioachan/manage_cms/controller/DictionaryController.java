package dev.tioachan.manage_cms.controller;

import dev.tioachan.api.course.SysDictionaryControllerApi;
import dev.tioachan.framework.domain.system.SysDictionary;
import dev.tioachan.manage_cms.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/dictionary")
public class DictionaryController implements SysDictionaryControllerApi {
	@Autowired
	DictionaryService dictionaryService;

	@Override
	@GetMapping("/get/{type}")
	public SysDictionary getByType(@PathVariable String type) {
		return dictionaryService.getByType(type);
	}
}
