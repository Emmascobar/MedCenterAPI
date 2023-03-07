package com.emmanuelescobar.medcenterapi.services.impl;

import com.emmanuelescobar.medcenterapi.model.scores.BloodPressureRegistry;
import com.emmanuelescobar.medcenterapi.model.scores.Comorbility;
import com.emmanuelescobar.medcenterapi.model.users.Patient;
import com.emmanuelescobar.medcenterapi.repository.scores.BloodPressureRegistryRepository;
import com.emmanuelescobar.medcenterapi.repository.users.DoctorRepository;
import com.emmanuelescobar.medcenterapi.repository.users.PatientRepository;
import com.emmanuelescobar.medcenterapi.repository.users.UserRepository;
import com.emmanuelescobar.medcenterapi.services.interfaces.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class DoctorServiceImpl implements DoctorService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BloodPressureRegistryRepository bloodPressureRegistryRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    String encodedPassword;


    /** METHODS **/
    public List<Patient> findAllPatients() {
        return patientRepository.findAll();
    }

    public Optional<Patient> findPatientById(Integer id) {
        return patientRepository.findById(id);
    }

    public Optional<Patient> findPatientByNameOrSurname(String name) {
        return patientRepository.findPatientByNameOrSurName(name);
    }
    public Optional<Patient> findPatientDNI(String DNI) {
        return patientRepository.findPatientByDNI(DNI);
    }

    public Patient addNewPatient(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }


    /**--- BUSINESS LOGIC ---**/
    // To get the Classification you need have PAD & PAS average.
    // Controlled the pressure during 7 days, get the results and set the average.
    public OptionalDouble averageCalculator(double... numbers){
        OptionalDouble average = Arrays.stream(numbers).average() ;
        return average;
    }
    // Now will can classified the symptom.
    public void BPClassification(Integer PatientId, BloodPressureRegistry bloodPressureRegistry)  {
        Optional<Patient> optionalPatient = patientRepository.findById(PatientId);
        if (!optionalPatient.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Patient not found");
        } else {
            //Risk Values Classification:
            boolean normal = (bloodPressureRegistry.getAveragePAD() < 80 && bloodPressureRegistry.getAveragePAS() < 120);
            boolean risk = (bloodPressureRegistry.getAveragePAD() > 80 && bloodPressureRegistry.getAveragePAD() < 89 && bloodPressureRegistry.getAveragePAS() > 120 && bloodPressureRegistry.getAveragePAS() < 139);
            boolean HBP1 = (bloodPressureRegistry.getAveragePAD() > 90 && bloodPressureRegistry.getAveragePAD() < 99 && bloodPressureRegistry.getAveragePAS() > 140 && bloodPressureRegistry.getAveragePAS() < 159);
            boolean HBP2 = (bloodPressureRegistry.getAveragePAD() >= 100 && bloodPressureRegistry.getAveragePAS() > 160);

            if (normal) {
                bloodPressureRegistry.setClassification("NORMAL BLOOD PRESSURE");
            } else if (risk) {
                bloodPressureRegistry.setClassification("HIGH RISK OF HIGH BLOOD PRESSURE");
            } else if (HBP1) {
                bloodPressureRegistry.setClassification("HIGH BLOOD PRESSURE GRADE I");
            } else if (HBP2) {
                bloodPressureRegistry.setClassification("HIGH BLOOD PRESSURE GRADE II");
            }

            // Treatment suggested from the results and COMORBILITY:
            if (bloodPressureRegistry.getClassification().equals(HBP1) || bloodPressureRegistry.getClassification().equals(HBP2) && bloodPressureRegistry.getComorbility().equals(Comorbility.CARDIAC_DISEASE)) {
                bloodPressureRegistry.setSuggestedTreatment("Can considerate: Diuretics, BB, IECAs, ARAsII and SPIROLACTONE");
            }
            if (bloodPressureRegistry.getClassification().equals(HBP1) || bloodPressureRegistry.getClassification().equals(HBP2) && bloodPressureRegistry.getComorbility().equals(Comorbility.IAM_DISEASE)) {
                bloodPressureRegistry.setSuggestedTreatment("Can considerate: BB, IECAs and SPIROLACTONE");
            }
            if (bloodPressureRegistry.getClassification().equals(HBP1) || bloodPressureRegistry.getClassification().equals(HBP2) && bloodPressureRegistry.getComorbility().equals(Comorbility.CORONARY_DISEASE)) {
                bloodPressureRegistry.setSuggestedTreatment("Can considerate: Diuretics, BB and IECAs");
            }
            if (bloodPressureRegistry.getClassification().equals(HBP1) || bloodPressureRegistry.getClassification().equals(HBP2) && bloodPressureRegistry.getComorbility().equals(Comorbility.DIABETES)) {
                bloodPressureRegistry.setSuggestedTreatment("Can considerate: Diuretics, BB, IECAs, Calcio-Antagonist and ARAsII");
            }
            if (bloodPressureRegistry.getClassification().equals(HBP1) || bloodPressureRegistry.getClassification().equals(HBP2) && bloodPressureRegistry.getComorbility().equals(Comorbility.CHRONIC_RENAL_FAILURE)) {
                bloodPressureRegistry.setSuggestedTreatment("Can considerate: IECAs or ARAsII");
            }
            if (bloodPressureRegistry.getClassification().equals(risk) && bloodPressureRegistry.getComorbility() == (Comorbility.NONE)) {
                bloodPressureRegistry.setSuggestedTreatment("Considerate a prevent treatment with: IECAs or Diuretics");
            }
            //Save on BD.
            patientRepository.save(optionalPatient.get());
        }
    }

}

