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
 * [OVERVIEW] Prescription Service Details Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT       Create new
*/
@Entity
@Table(name = "PrescriptionServiceDetails")
public class PrescriptionServiceDetailsEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "prescription_id")
    private Integer prescriptionId;

    @Id
    @Column(name = "service_id")
    private Integer serviceId;

    @Column(name = "service_note")
    @SerializedName("service_note")
    @JsonProperty("service_note")
    private String serviceNote;

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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceNote() {
        return serviceNote;
    }

    public void setServiceNote(String serviceNote) {
        this.serviceNote = serviceNote;
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

    public PrescriptionServiceDetailsEntity(Integer prescriptionId, Integer serviceId, String serviceNote, Integer sellQuantity, Double itemPrice) {
        super();
        this.prescriptionId = prescriptionId;
        this.serviceId = serviceId;
        this.serviceNote = serviceNote;
        this.sellQuantity = sellQuantity;
        this.itemPrice = itemPrice;
    }

    public PrescriptionServiceDetailsEntity() {
        super();
        // TODO Auto-generated constructor stub
    }

}
