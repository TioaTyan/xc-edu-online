package dev.tioachan.filesystem.dao;

import dev.tioachan.framework.domain.filesystem.FileSystem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FileSystemRepository extends MongoRepository<FileSystem,String> {
}
