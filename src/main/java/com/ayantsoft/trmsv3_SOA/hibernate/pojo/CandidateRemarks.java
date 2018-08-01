package com.ayantsoft.trmsv3_SOA.hibernate.pojo;
// Generated 23 Jun, 2017 5:01:16 PM by Hibernate Tools 4.3.5.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CandidateRemarks generated by hbm2java
 */
@Entity
@Table(name = "candidate_remarks", catalog = "ayant_trmsv2")
public class CandidateRemarks implements java.io.Serializable {

	private Integer id;
	private String description;
	private Integer orderIndex;
	private String statusType;
	private Set<Candidate> candidates = new HashSet<Candidate>(0);

	public CandidateRemarks() {
	}

	public CandidateRemarks(String description, Integer orderIndex, String statusType, Set<Candidate> candidates) {
		this.description = description;
		this.orderIndex = orderIndex;
		this.statusType = statusType;
		this.candidates = candidates;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "order_index")
	public Integer getOrderIndex() {
		return this.orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	@Column(name = "status_type", length = 45)
	public String getStatusType() {
		return this.statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "candidateRemarks")
	public Set<Candidate> getCandidates() {
		return this.candidates;
	}

	public void setCandidates(Set<Candidate> candidates) {
		this.candidates = candidates;
	}

}
