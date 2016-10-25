package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "family_data_mapping")
public class RationFamilyData {

	@Id
	@Column(name = "family_id")
	int familyId = 0;
	@Column(name = "family_age")
	int familyAge = 0;
	@OneToOne
	@JoinColumn(name = "ration_id")
	RationMasterData rationId = null;
	@Column(name = "family_name")
	String familyName = null;
	@Column(name = "family_gender")
	String familyGender = null;

	public int getFamilyId() {
		return familyId;
	}

	public void setFamilyId(int familyId) {
		this.familyId = familyId;
	}

	public int getFamilyAge() {
		return familyAge;
	}

	public void setFamilyAge(int familyAge) {
		this.familyAge = familyAge;
	}

	public RationMasterData getRationId() {
		return rationId;
	}

	public void setRationId(RationMasterData rationId) {
		this.rationId = rationId;
	}

	public String getFamilyName() {
		return familyName;
	}

	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFamilyGender() {
		return familyGender;
	}

	public void setFamilyGender(String familyGender) {
		this.familyGender = familyGender;
	}

}
