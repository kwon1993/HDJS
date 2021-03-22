package hd.hospital.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "hospitalId")
    private Hospital hospitalId;

    @Column(length = 45)
    private String patientName;
    @Column(length = 13)
    private String registrationNumber;
    @Column(length = 10)
    private String genderCode;
    @Column(length = 10)
    private String birth;
    @Column(length = 20)
    private String phoneNumber;

    @OneToMany(mappedBy = "patientId")
    private List<Visit> visitList;

    @Builder
    public Patient(Hospital hospitalId, String patientName, String registrationNumber, String genderCode, String birth, String phoneNumber) {
        this.hospitalId = hospitalId;
        this.patientName = patientName;
        this.registrationNumber = registrationNumber;
        this.genderCode = genderCode;
        this.birth = birth;
        this.phoneNumber = phoneNumber;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setGenderCode(String genderCode) {
        this.genderCode = genderCode;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
