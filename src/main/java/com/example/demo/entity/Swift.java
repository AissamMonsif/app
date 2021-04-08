package com.example.demo.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



@Entity
public class Swift {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_swift")
	private int idSwift;

	@Column(name = "sens")
	private String sens;

	@Column(name = "message_swift", columnDefinition = "text")
	private String messageSwift;

	@ManyToOne
	@JoinColumn(name = "id_type_swift")
	private TypeSwift typeSwift;

	@Column(name = "date_insertion")
	private Date dateInsertion;

	@OneToMany(mappedBy = "swift", cascade = CascadeType.ALL)
	private List<SwiftDetails> details;
	
	String block4 = "";

	public Swift() {
		super();
	}

	public int getIdSwift() {
		return idSwift;
	}

	public void setIdSwift(int idSwift) {
		this.idSwift = idSwift;
	}

	public String getSens() {
		return sens;
	}

	public void setSens(String sens) {
		this.sens = sens;
	}

	public String getMessageSwift() {
		return messageSwift;
	}

	public void setMessageSwift(String messageSwift) {
		this.messageSwift = messageSwift;
	}

	public TypeSwift getTypeSwift() {
		return typeSwift;
	}

	public void setTypeSwift(TypeSwift typeSwift) {
		this.typeSwift = typeSwift;
	}

	public Date getDateInsertion() {
		return dateInsertion;
	}

	public void setDateInsertion(Date dateInsertion) {
		this.dateInsertion = dateInsertion;
	}

	public List<SwiftDetails> getDetails() {
		return details;
	}

	public void setDetails(List<SwiftDetails> details) {
		this.details = details;
	}

	@Override
	public String toString() {
		return "Swift [idSwift=" + idSwift + ", sens=" + sens + ", typeSwift=" + typeSwift + ", dateInsertion="
				+ dateInsertion + "]";
	}

	
}
