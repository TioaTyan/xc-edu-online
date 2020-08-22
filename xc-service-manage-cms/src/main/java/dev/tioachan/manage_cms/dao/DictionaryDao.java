package dev.tioachan.manage_cms.dao;

import dev.tioachan.framework.domain.system.SysDictionary;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DictionaryDao extends MongoRepository<SysDictionary, String> {
	SysDictionary findBydType(String type);

}
