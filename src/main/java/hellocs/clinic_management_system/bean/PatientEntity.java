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
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Patient Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "Patient")
public class PatientEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id")
    @SerializedName("patient_id")
    @JsonProperty("patient_id")
    private Integer patientId;

    @Column(name = "patient_name")
    @SerializedName("patient_name")
    @JsonProperty("patient_name")
    private String patientName;

    @Column(name = "address")
    @SerializedName("address")
    @JsonProperty("address")
    private String address;

    @Column(name = "phone")
    @SerializedName("phone")
    @JsonProperty("phone")
    private Integer phone;

    @Column(name = "date_of_birth")
    @SerializedName("date_of_birth")
    @JsonProperty("date_of_birth")
    private Date dateOfBirth;

    @Column(name = "age")
    @SerializedName("age")
    @JsonProperty("age")
    private Integer age;

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    @JsonGetter("date_of_birth")
    public String getDateOfBirthFormatted() {
        if (dateOfBirth == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateValue = dateFormat.format(dateOfBirth);
        return dateValue;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public PatientEntity(Integer patientId, String patientName, String address, Integer phone, Date dateOfBirth, Integer age) {
        super();
        this.patientId = patientId;
        this.patientName = patientName;
        this.address = address;
        this.phone = phone;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
    }

    public PatientEntity() {
        super();
    }

}
