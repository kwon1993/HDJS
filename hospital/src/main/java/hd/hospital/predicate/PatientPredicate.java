package hd.hospital.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import hd.hospital.domain.QPatient;

public class PatientPredicate {
    public static Predicate search(String patientName, String registrationNumber, String birth) {
        QPatient patient = QPatient.patient;

        BooleanBuilder booleanBuilder = new BooleanBuilder();
        if (patientName != null) {
            booleanBuilder.and(patient.patientName.eq(patientName));
        }
        if (registrationNumber != null) {
            booleanBuilder.and(patient.registrationNumber.eq(registrationNumber));
        }
        if (birth != null) {
            booleanBuilder.and(patient.birth.eq(birth));
        }
        return booleanBuilder;
    }
}
