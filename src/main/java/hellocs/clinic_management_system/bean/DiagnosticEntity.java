/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.bean;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Diagnostic Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "Diagnostic")
public class DiagnosticEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "diagnostic_id")
    @SerializedName("diagnostic_id")
    @JsonProperty("diagnostic_id")
    private Integer diagnosticId;

    @Column(name = "patient_id")
    @SerializedName("patient_id")
    @JsonProperty("patient_id")
    private Integer patientId;

    @Column(name = "symptoms")
    @SerializedName("symptoms")
    @JsonProperty("symptoms")
    private String symptoms;

    @Column(name = "diagnostics")
    @SerializedName("diagnostics")
    @JsonProperty("diagnostics")
    private String diagnostics;

    @Column(name = "health_check_date")
    @SerializedName("health_check_date")
    @JsonProperty("health_check_date")
    private Date healthCheckDate;

    @Column(name = "doctor_note")
    @SerializedName("doctor_note")
    @JsonProperty("doctor_note")
    private String doctorNote;

    //    @SerializedName("prescription_entities")
    //    @Transient
    //    @JsonIgnore
    //    private List<PrescriptionEntity> prescriptionEntities;

    @ManyToOne
    @JoinColumn(name = "patient_id", insertable = false, updatable = false)
    @JsonProperty("patient")
    @JsonInclude(Include.NON_NULL)
    private PatientEntity patientEntity;

    public Integer getDiagnosticId() {
        return diagnosticId;
    }

    public void setDiagnosticId(Integer diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getDiagnostics() {
        return diagnostics;
    }

    public void setDiagnostics(String diagnostics) {
        this.diagnostics = diagnostics;
    }

    public Date getHealthCheckDate() {
        return healthCheckDate;
    }

    @JsonGetter("health_check_date")
    public String getHealthCheckDateFormatted() {
        if (healthCheckDate == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateValue = dateFormat.format(healthCheckDate);
        return dateValue;
    }

    public void setHealthCheckDate(Date healthCheckDate) {
        this.healthCheckDate = healthCheckDate;
    }

    public String getDoctorNote() {
        return doctorNote;
    }

    public void setDoctorNote(String doctorNote) {
        this.doctorNote = doctorNote;
    }

    public PatientEntity getPatientEntity() {
        return patientEntity;
    }

    public void setPatientEntity(PatientEntity patientEntity) {
        this.patientEntity = patientEntity;
    }

    public DiagnosticEntity(Integer diagnosticId, Integer patientId, String symptoms, String diagnostics, Date healthCheckDate, String doctorNote) {
        super();
        this.diagnosticId = diagnosticId;
        this.patientId = patientId;
        this.symptoms = symptoms;
        this.diagnostics = diagnostics;
        this.healthCheckDate = healthCheckDate;
        this.doctorNote = doctorNote;
    }

    public DiagnosticEntity() {
        super();
    }

}
