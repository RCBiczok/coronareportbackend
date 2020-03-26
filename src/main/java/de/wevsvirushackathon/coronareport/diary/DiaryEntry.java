package de.wevsvirushackathon.coronareport.diary;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import de.wevsvirushackathon.coronareport.contactperson.ContactPerson;
import de.wevsvirushackathon.coronareport.symptomes.Symptom;
import de.wevsvirushackathon.coronareport.user.Client;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DiaryEntry {
    @Id
    @GeneratedValue
    @Getter
    private Long id;

    @ManyToOne
    @JoinColumn(name="client_id", nullable=false)
    private Client client;
    @Getter
    private Timestamp dateTime;
    @Getter
    private float bodyTemperature;
    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Symptom> symptoms;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<ContactPerson> contactPersons;

    private boolean transmittedToHealthDepartment;
}
