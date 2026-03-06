package model;

import jakarta.persistence.*;

@Entity
@Table(name = "employer")
public class Employer {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String socialReason;
	private String activity;
	
	public Employer() {
		
	}
	public Employer(String socialReason , String activity) {
		this.socialReason = socialReason;
		this.activity =activity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSocialReason() {
		return socialReason;
	}

	public void setSocialReason(String socialReason) {
		this.socialReason = socialReason;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "Employer [id=" + id + ", socialReason=" + socialReason + ", activity=" + activity + "]";
	}
}
