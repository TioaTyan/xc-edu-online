package dev.tioachan.manage_cms.service.impl;

import dev.tioachan.framework.domain.system.SysDictionary;
import dev.tioachan.manage_cms.dao.DictionaryDao;
import dev.tioachan.manage_cms.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {
	@Autowired
	DictionaryDao dictionaryDao;

	@Override
	public SysDictionary getByType(String type) {
		return dictionaryDao.findBydType(type);
	}
}
