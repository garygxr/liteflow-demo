package github.garygan.liteflow.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SexTagContext extends TagContext {
    /**
     * 当前Tag
     */
    private String tagName="女学员";

    private String tagId = "female_tag";
}
