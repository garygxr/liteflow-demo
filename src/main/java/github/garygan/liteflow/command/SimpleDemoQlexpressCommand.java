package github.garygan.liteflow.command;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.slot.DefaultContext;
import com.yomahub.liteflow.util.JsonUtil;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class SimpleDemoQlexpressCommand implements CommandLineRunner {
    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        DefaultContext defaultContext = new DefaultContext();
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain1",null, defaultContext);
        DefaultContext context = liteflowResponse.getFirstContextBean();
        System.out.println(JsonUtil.toJsonString(context.getData("s1")));
    }
}
