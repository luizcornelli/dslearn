package com.devsuperior.dslearnbds.entities;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EnrollmentPK enrollmentPK = new EnrollmentPK();

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant enrollMoment;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant refundMoment;
    private boolean available;
    private boolean onlyUpdate;

    public Enrollment(){
    }

    public Enrollment(User user, Offer offer,Instant enrollMoment, Instant refundMoment, boolean available, boolean onlyUpdate) {
        this.enrollmentPK.setUser(user);
        this.enrollmentPK.setOffer(offer);
        this.enrollMoment = enrollMoment;
        this.refundMoment = refundMoment;
        this.available = available;
        this.onlyUpdate = onlyUpdate;
    }

    public User getStudent() {
        return enrollmentPK.getUser();
    }

    public void setStudent(User user) {
        enrollmentPK.setUser(user);
    }

    public Offer getOffer() {
        return enrollmentPK.getOffer();
    }

    public void setOffer(Offer offer) {
        enrollmentPK.setOffer(offer);
    }

    public Instant getEnrollMoment() {
        return enrollMoment;
    }

    public void setEnrollMoment(Instant enrollMoment) {
        this.enrollMoment = enrollMoment;
    }

    public Instant getRefundMoment() {
        return refundMoment;
    }

    public void setRefundMoment(Instant refundMoment) {
        this.refundMoment = refundMoment;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isOnlyUpdate() {
        return onlyUpdate;
    }

    public void setOnlyUpdate(boolean onlyUpdate) {
        this.onlyUpdate = onlyUpdate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Enrollment that = (Enrollment) o;
        return enrollmentPK.equals(that.enrollmentPK);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enrollmentPK);
    }
}
