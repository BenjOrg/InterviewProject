package pers.benjamin.stream;

import java.time.LocalDate;

import com.google.common.base.Objects;

public class Certification {

    private String certName;

    private LocalDate gatherDate;

    private String certAuthority;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certification that = (Certification) o;
        return Objects.equal(certName, that.certName) &&
                Objects.equal(gatherDate, that.gatherDate) &&
                Objects.equal(certAuthority, that.certAuthority);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(certName, gatherDate, certAuthority);
    }

    public String getCertName() {
        return certName;
    }

    public void setCertName(String certName) {
        this.certName = certName;
    }

    public LocalDate getGatherDate() {
        return gatherDate;
    }

    public void setGatherDate(LocalDate gatherDate) {
        this.gatherDate = gatherDate;
    }

    public String getCertAuthority() {
        return certAuthority;
    }

    public void setCertAuthority(String certAuthority) {
        this.certAuthority = certAuthority;
    }
}
