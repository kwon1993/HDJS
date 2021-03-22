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
    @JoinColumn(name = "hospitalId")
    private Hospital hospitalId;

    @ManyToOne
    @JoinColumn(name = "patientId")
    private Patient patientId;

    private Date receptionDate;
    @Column(length = 10)
    private String statueCode;

    @Builder
    public Visit(Hospital hospitalId, Patient patientId, Date receptionDate, String statueCode) {
        this.hospitalId = hospitalId;
        this.patientId = patientId;
        this.receptionDate = receptionDate;
        this.statueCode = statueCode;
    }

    public void setHospitalId(Hospital hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setPatientId(Patient patientId) {
        this.patientId = patientId;
    }

    public void setReceptionDate(Date receptionDate) {
        this.receptionDate = receptionDate;
    }

    public void setStatueCode(String statueCode) {
        this.statueCode = statueCode;
    }
}
