/////////////////////////////////////////////////////////////////////////////
//
// © 2020 VNEXT TRAINING
//
/////////////////////////////////////////////////////////////////////////////

package hellocs.clinic_management_system.bean;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

/**
 * [OVERVIEW] Service Entity.
 *
 * @author: LinhDT
 * @version: 1.0
 * @History
 * [NUMBER]  [VER]     [DATE]          [USER]             [CONTENT]
 * --------------------------------------------------------------------------
 * 001       1.0       2021/07/18      LinhDT             Create new
*/
@Entity
@Table(name = "Service")
public class ServiceEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    @SerializedName("service_id")
    @JsonProperty("service_id")
    private Integer serviceId;

    @Column(name = "service_name")
    @SerializedName("service_name")
    @JsonProperty("service_name")
    private String serviceName;

    @Column(name = "note")
    @SerializedName("note")
    @JsonProperty("note")
    private String note;

    @Column(name = "acquired_price", columnDefinition = "double default 0")
    @SerializedName("acquired_price")
    @JsonProperty("acquired_price")
    private Double acquiredPrice;

    @Column(name = "sell_price", columnDefinition = "double default 0")
    @SerializedName("sell_price")
    @JsonProperty("sell_price")
    private Double sellPrice;

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Double getAcquiredPrice() {
        return acquiredPrice;
    }

    public void setAcquiredPrice(Double acquiredPrice) {
        this.acquiredPrice = acquiredPrice;
    }

    public Double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(Double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public ServiceEntity(Integer serviceId, String serviceName, String note, Double acquiredPrice, Double sellPrice) {
        super();
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.note = note;
        this.acquiredPrice = acquiredPrice;
        this.sellPrice = sellPrice;
    }

    public ServiceEntity() {
        super();
    }

}
