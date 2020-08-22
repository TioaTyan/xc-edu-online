package dev.tioachan.manage_cms.service;

import dev.tioachan.framework.domain.system.SysDictionary;

public interface DictionaryService {
	SysDictionary getByType(String type);
}
