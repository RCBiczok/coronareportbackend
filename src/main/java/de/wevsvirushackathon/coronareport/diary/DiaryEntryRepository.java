package de.wevsvirushackathon.coronareport.diary;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.wevsvirushackathon.coronareport.user.Client;

@Repository
public interface DiaryEntryRepository
        extends CrudRepository<DiaryEntry, Long> {
    @Query("SELECT d FROM DiaryEntry d WHERE d.client.healthDepartmentId = :healthDepartmentId AND d.transmittedToHealthDepartment = false")
    Collection<DiaryEntry> findAllByHealthDepartmentIdNotTransmitted(@Param("healthDepartmentId") String healthDepartmentId);

    List<DiaryEntry> findAllByClientOrderByDateTimeDesc(Client client);
}