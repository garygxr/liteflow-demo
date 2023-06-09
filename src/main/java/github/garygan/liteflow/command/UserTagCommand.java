package github.garygan.liteflow.command;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import github.garygan.liteflow.dto.UserContext;
import github.garygan.liteflow.dto.tag.AgeTagContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;

@Component
public class UserTagCommand implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        UserContext userContext = new UserContext(0, 60, true, new ArrayList<>(1));
        AgeTagContext ageTagContext = new AgeTagContext();
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("userTag1", null, userContext, ageTagContext);
        UserContext newUsercontextBean = liteflowResponse.getContextBean(UserContext.class);
        System.out.println(newUsercontextBean);
    }


}
