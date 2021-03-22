package hd.hospital.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Code {

    @ManyToOne
    @JoinColumn(name = "codeGroup")
    private CodeGroup codeGroup;

    @Id
    @Column(length = 10)
    private String code;
    @Column(length = 10)
    private String codeName;

    @Builder
    public Code(CodeGroup codeGroup, String code, String codeName) {
        this.codeGroup = codeGroup;
        this.code = code;
        this.codeName = codeName;
    }

    public void setCodeGroup(CodeGroup codeGroup) {
        this.codeGroup = codeGroup;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }
}
