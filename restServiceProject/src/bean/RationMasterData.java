package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ration_card_details")
public class RationMasterData {

	@Id
	@Column(name = "ration_card_id")
	int rationCardId = 0;
	@Column(name = "holder_age")
	int holderAge = 0;
	@Column(name = "ard_code")
	String ardCode = null;
	@Column(name = "holder_address")  
	String holderAddress = null;
	@Column(name = "holder_name")
	String holderName = null;
	@Column(name = "holder_gender")
	String holderGender = null;

	public int getRationCardId() {
		return rationCardId;
	}

	public void setRationCardId(int rationCardId) {
		this.rationCardId = rationCardId;
	}

	public int getHolderAge() {
		return holderAge;
	}

	public void setHolderAge(int holderAge) {
		this.holderAge = holderAge;
	}

	public String getArdCode() {
		return ardCode;
	}

	public void setArdCode(String ardCode) {
		this.ardCode = ardCode;
	}

	public String getHolderAddress() {
		return holderAddress;
	}

	public void setHolderAddress(String holderAddress) {
		this.holderAddress = holderAddress;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getHolderGender() {
		return holderGender;
	}

	public void setHolderGender(String holderGender) {
		this.holderGender = holderGender;
	}

}
