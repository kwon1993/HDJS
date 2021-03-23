package hd.hospital.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;

    @ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;

    private Date receptionDate;
    @Column(length = 10)
    private String statusCode;

    @Builder
    public Visit(Hospital hospital, Patient patient, Date receptionDate, String statusCode) {
        this.hospital = hospital;
        this.patient = patient;
        this.receptionDate = receptionDate;
        this.statusCode = statusCode;
    }

    public void setHospitalId(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setPatientId(Patient patient) {
        this.patient = patient;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }
}
