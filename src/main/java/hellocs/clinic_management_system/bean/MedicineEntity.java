/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.bean;

import java.io.Serializable;
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

import hellocs.clinic_management_system.data.UnitEnum;

/**
 * [OVERVIEW] Medicine Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "Medicine")
public class MedicineEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_id")
    @SerializedName("medicine_id")
    @JsonProperty("medicine_id")
    private Integer medicineId;

    @Column(name = "medicine_name")
    @SerializedName("medicine_name")
    @JsonProperty("medicine_name")
    private String medicineName;

    @Column(name = "quantity_acquired")
    @SerializedName("quantity_acquired")
    @JsonProperty("quantity_acquired")
    private Integer quantityAcquired;

    @Column(name = "unit")
    @SerializedName("unit")
    @JsonProperty("unit")
    private Integer unit;

    @Column(name = "quantity_in_stock")
    @SerializedName("quantity_in_stock")
    @JsonProperty("quantity_in_stock")
    private Integer quantityInStock;

    @Column(name = "quantity_per_unit")
    @SerializedName("quantity_per_unit")
    @JsonProperty("quantity_per_unit")
    private Integer quantityPerUnit;

    @Column(name = "note")
    @SerializedName("note")
    @JsonProperty("note")
    private String note;

    @Column(name = "acquired_date")
    @SerializedName("acquired_date")
    @JsonProperty("acquired_date")
    private Date acquiredDate;

    @Column(name = "acquired_price_per_count", columnDefinition = "double default 0")
    @SerializedName("acquired_price_per_count")
    @JsonProperty("acquired_price_per_count")
    private Double acquiredPricePerCount;

    @Column(name = "sell_price_per_count", columnDefinition = "double default 0")
    @SerializedName("sell_price_per_count")
    @JsonProperty("sell_price_per_count")
    private Double sellPricePerCount;

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getQuantityAcquired() {
        return quantityAcquired;
    }

    public void setQuantityAcquired(Integer quantityAcquired) {
        this.quantityAcquired = quantityAcquired;
    }

    public UnitEnum getUnit() {
        return UnitEnum.parse(this.unit);
    }

    @JsonGetter("unit")
    public Integer getUnitValue() {
        return this.unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public void setUnit(UnitEnum unit) {
        this.unit = unit.value();
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getQuantityPerUnit() {
        return quantityPerUnit;
    }

    public void setQuantityPerUnit(Integer quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getAcquiredDate() {
        return acquiredDate;
    }

    public void setAcquiredDate(Date acquiredDate) {
        this.acquiredDate = acquiredDate;
    }

    public Double getAcquiredPricePerCount() {
        return acquiredPricePerCount;
    }

    public void setAcquiredPricePerCount(Double acquiredPricePerCount) {
        this.acquiredPricePerCount = acquiredPricePerCount;
    }

    public Double getSellPricePerCount() {
        return sellPricePerCount;
    }

    public void setSellPricePerCount(Double sellPricePerCount) {
        this.sellPricePerCount = sellPricePerCount;
    }

    public MedicineEntity(Integer medicineId, String medicineName, Integer quantityAcquired, Integer unit, Integer quantityInStock, Integer quantityPerUnit,
            String note, Date acquiredDate, Double acquiredPricePerCount, Double sellPricePerCount) {
        super();
        this.medicineId = medicineId;
        this.medicineName = medicineName;
        this.quantityAcquired = quantityAcquired;
        this.unit = unit;
        this.quantityInStock = quantityInStock;
        this.quantityPerUnit = quantityPerUnit;
        this.note = note;
        this.acquiredDate = acquiredDate;
        this.acquiredPricePerCount = acquiredPricePerCount;
        this.sellPricePerCount = sellPricePerCount;
    }

    public MedicineEntity() {
        super();
    }

}
