package github.garygan.liteflow.dto.tag;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgeTagContext extends TagContext {
    /**
     * 当前Tag
     */
    private String tagName="老年人";


    private String tagId="old_man_tag";
}
