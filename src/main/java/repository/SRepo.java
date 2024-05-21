package repository;

import entity.SensorEntity;
import org.springframework.data.repository.CrudRepository;

public interface SRepo extends CrudRepository<SensorEntity, Long> {
}
