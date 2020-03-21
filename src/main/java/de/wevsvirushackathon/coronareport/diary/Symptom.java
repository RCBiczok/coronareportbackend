package de.wevsvirushackathon.coronareport.diary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Symptom {

	@Id
	private int id;
	private String name;

	boolean isCharacteristic; 

}
