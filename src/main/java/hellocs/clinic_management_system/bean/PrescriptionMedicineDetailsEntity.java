/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Prescription Medicine Details.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "PrescriptionMedicineDetails")
public class PrescriptionMedicineDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prescription_id")
    private Integer prescriptionId;

    @Id
    @Column(name = "medicine_id")
    private Integer medicineId;

    @Column(name = "dosage")
    @SerializedName("dosage")
    @JsonProperty("dosage")
    private String dosage;

    @Column(name = "sell_quantity")
    @SerializedName("sell_quantity")
    @JsonProperty("sell_quantity")
    private Integer sellQuantity;

    @Column(name = "item_price")
    @SerializedName("item_price")
    @JsonProperty("item_price")
    private Double itemPrice;

    public Integer getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(Integer prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(Integer sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public PrescriptionMedicineDetailsEntity(Integer prescriptionId, Integer medicineId, String dosage, Integer sellQuantity, Double itemPrice) {
        super();
        this.prescriptionId = prescriptionId;
        this.medicineId = medicineId;
        this.dosage = dosage;
        this.sellQuantity = sellQuantity;
        this.itemPrice = itemPrice;
    }

    public PrescriptionMedicineDetailsEntity() {
        super();

    }

}
