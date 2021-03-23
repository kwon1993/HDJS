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
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 45)
    private String hospitalName;
    @Column(length = 20)
    private String hospitalNumber;
    @Column(length = 10)
    private String hospitalHeadName;

    @OneToMany(mappedBy = "hospital")
    private List<Patient> patientList;

    @OneToMany(mappedBy = "hospital")
    private List<Visit> visitList;

    @Builder
    public Hospital(String hospitalName, String hospitalNumber, String hospitalHeadName) {
        this.hospitalName = hospitalName;
        this.hospitalNumber = hospitalNumber;
        this.hospitalHeadName = hospitalHeadName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void setHospitalNumber(String hospitalNumber) {
        this.hospitalNumber = hospitalNumber;
    }

    public void setHospitalHeadName(String hospitalHeadName) {
        this.hospitalHeadName = hospitalHeadName;
    }
}
