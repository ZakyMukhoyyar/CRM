package com.agit.crm.domain.crm;

import com.agit.crm.shared.object.EntityObject;
import com.agit.crm.shared.state.LowonganState;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author 3AD
 */
public class RiwayatApplyEvent implements EntityObject<RiwayatApplyEvent> {

    long id;

    private String idRiwayatApplyEvent;
    private String idRiwayatEvent;
    private String idUserRiwayat;
    private String namaEvent;
    private String namaPelamar;
    private LowonganState lowonganState;
    private String createdBy;
    private Date createdDate;
    private String modifiedBy;
    private Date modifiedDate;

    public RiwayatApplyEvent() {
    }

    public RiwayatApplyEvent(String idRiwayatApplyEvent, String idRiwayatEvent, String idUserRiwayat, String namaEvent, String namaPelamar, LowonganState lowonganState, String createdBy, Date createdDate, String modifiedBy, Date modifiedDate) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
        this.idRiwayatEvent = idRiwayatEvent;
        this.idUserRiwayat = idUserRiwayat;
        this.namaEvent = namaEvent;
        this.namaPelamar = namaPelamar;
        this.lowonganState = lowonganState;
        this.createdBy = createdBy;
        this.createdDate = createdDate;
        this.modifiedBy = modifiedBy;
        this.modifiedDate = modifiedDate;
    }

    public void assignNewRiwayatEvent(RiwayatApplyEvent riwayatApplyEvent) {
        this.idRiwayatApplyEvent = riwayatApplyEvent.idRiwayatApplyEvent;
        this.idRiwayatEvent = riwayatApplyEvent.idRiwayatEvent;
        this.idUserRiwayat = riwayatApplyEvent.idUserRiwayat;
        this.namaEvent = riwayatApplyEvent.namaEvent;
        this.namaPelamar = riwayatApplyEvent.namaPelamar;
        this.lowonganState = riwayatApplyEvent.lowonganState;
        this.modifiedBy = riwayatApplyEvent.modifiedBy;
        this.modifiedDate = riwayatApplyEvent.modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdRiwayatApplyEvent() {
        return idRiwayatApplyEvent;
    }

    public void setIdRiwayatApplyEvent(String idRiwayatApplyEvent) {
        this.idRiwayatApplyEvent = idRiwayatApplyEvent;
    }

    public String getIdRiwayatEvent() {
        return idRiwayatEvent;
    }

    public void setIdRiwayatEvent(String idRiwayatEvent) {
        this.idRiwayatEvent = idRiwayatEvent;
    }

    public String getIdUserRiwayat() {
        return idUserRiwayat;
    }

    public void setIdUserRiwayat(String idUserRiwayat) {
        this.idUserRiwayat = idUserRiwayat;
    }

    public String getNamaEvent() {
        return namaEvent;
    }

    public void setNamaEvent(String namaEvent) {
        this.namaEvent = namaEvent;
    }

    public String getNamaPelamar() {
        return namaPelamar;
    }

    public void setNamaPelamar(String namaPelamar) {
        this.namaPelamar = namaPelamar;
    }

    public LowonganState getLowonganState() {
        return lowonganState;
    }

    public void setLowonganState(LowonganState lowonganState) {
        this.lowonganState = lowonganState;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.idRiwayatApplyEvent);
        hash = 11 * hash + Objects.hashCode(this.idRiwayatEvent);
        hash = 11 * hash + Objects.hashCode(this.idUserRiwayat);
        hash = 11 * hash + Objects.hashCode(this.namaEvent);
        hash = 11 * hash + Objects.hashCode(this.namaPelamar);
        hash = 11 * hash + Objects.hashCode(this.lowonganState);
        hash = 11 * hash + Objects.hashCode(this.createdBy);
        hash = 11 * hash + Objects.hashCode(this.createdDate);
        hash = 11 * hash + Objects.hashCode(this.modifiedBy);
        hash = 11 * hash + Objects.hashCode(this.modifiedDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RiwayatApplyEvent other = (RiwayatApplyEvent) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public boolean sameIdentityAs(RiwayatApplyEvent other) {
        return this.equals(other);
    }

}
