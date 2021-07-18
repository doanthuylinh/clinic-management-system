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
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Prescription Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "Prescription")
public class PrescriptionEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id")
    @SerializedName("prescription_id")
    @JsonProperty("prescription_id")
    private Integer prescriptionId;

    @Column(name = "diagnostic_id")
    @SerializedName("diagnostic_id")
    @JsonProperty("diagnostic_id")
    private Integer diagnosticId;

    @Column(name = "from_date")
    @SerializedName("from_date")
    @JsonProperty("from_date")
    private Date fromDate;

    @Column(name = "to_date")
    @SerializedName("to_date")
    @JsonProperty("to_date")
    private Date toDate;

    @Column(name = "total_price")
    @SerializedName("total_price")
    @JsonProperty("total_price")
    private Double totalPrice;

    @ManyToMany
    @JoinColumn(name = "medicine_id")
    @SerializedName("medicines")
    @JsonProperty("medicines")
    private List<MedicineEntity> medicineEntities;
    
    @ManyToMany
    @JoinColumn(name = "service_id")
    @SerializedName("services")
    @JsonProperty("services")
    private List<ServiceEntity> serviceEntities;

    @ManyToOne
    @JoinColumn(name = "diagnostic_id", insertable = false, updatable = false)
    @JsonProperty("diagnostic")
    @JsonInclude(Include.NON_NULL)
    private DiagnosticEntity diagnosticEntity;

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getDiagnosticId() {
        return diagnosticId;
    }

    public void setDiagnosticId(Integer diagnosticId) {
        this.diagnosticId = diagnosticId;
    }

    public Date getFromDate() {
        return fromDate;
    }

    @JsonGetter("from_date")
    public String getFromDateFormatted() {
        if (fromDate == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateValue = dateFormat.format(fromDate);
        return dateValue;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    @JsonGetter("to_date")
    public String getToDateFormatted() {
        if (toDate == null) {
            return null;
        }

        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String dateValue = dateFormat.format(toDate);
        return dateValue;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public DiagnosticEntity getDiagnosticEntity() {
        return diagnosticEntity;
    }

    public void setDiagnosticEntity(DiagnosticEntity diagnosticEntity) {
        this.diagnosticEntity = diagnosticEntity;
    }

    public PrescriptionEntity(Integer prescriptionId, Integer diagnosticId, Date fromDate, Date toDate, Double totalPrice, DiagnosticEntity diagnosticEntity) {
        super();
        this.prescriptionId = prescriptionId;
        this.diagnosticId = diagnosticId;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.totalPrice = totalPrice;
        this.diagnosticEntity = diagnosticEntity;
    }

    public PrescriptionEntity() {
        super();
    }

}
