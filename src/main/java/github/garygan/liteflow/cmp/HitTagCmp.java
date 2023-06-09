package github.garygan.liteflow.cmp;


import com.yomahub.liteflow.core.NodeComponent;
import github.garygan.liteflow.dto.UserContext;
import github.garygan.liteflow.dto.tag.TagContext;
import org.springframework.stereotype.Component;

import java.util.List;


@Component("hit")
public class HitTagCmp extends NodeComponent {

    @Override
    public void process() throws Exception {
        // 获取当前的tagId
        TagContext tagContext = (TagContext) this.getSlot().getContextBeanList().get(1);
        String tagDesc = tagContext.getTagName();

        // 获取当前的用户
        UserContext contextBean = this.getContextBean(UserContext.class);
        System.out.println(contextBean + "命中标签" + tagDesc);
        List<String> tags = contextBean.getTags();

        tags.add(tagDesc);
        contextBean.setTags(tags);
    }
}
