package hd.hospital.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class CodeGroup {

    @Id
    @Column(length = 10)
    private String codeGroup;

    @Column(length = 10)
    private String codeGroupName;
    @Column(length = 10)
    private String explanation;

    @OneToMany(mappedBy = "codeGroup")
    private List<Code> codeList;

    @Builder
    public CodeGroup(String codeGroup, String codeGroupName, String explanation) {
        this.codeGroup = codeGroup;
        this.codeGroupName = codeGroupName;
        this.explanation = explanation;
    }

    public void setCodeGroup(String codeGroup) {
        this.codeGroup = codeGroup;
    }

    public void setCodeGroupName(String codeGroupName) {
        this.codeGroupName = codeGroupName;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
