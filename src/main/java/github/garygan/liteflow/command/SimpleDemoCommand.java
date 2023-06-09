package github.garygan.liteflow.command;

import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class SimpleDemoCommand implements CommandLineRunner {
    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {
        LiteflowResponse liteflowResponse = flowExecutor.execute2Resp("chain1", null);
    }
}
