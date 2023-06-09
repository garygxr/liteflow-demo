package github.garygan.liteflow.dto.tag;

import com.yomahub.liteflow.slot.DefaultContext;
import lombok.Data;

@Data
public abstract class TagContext extends DefaultContext {
    private String tagName;

    private String tagId;
}
