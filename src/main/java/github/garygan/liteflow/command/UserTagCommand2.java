package github.garygan.liteflow.command;

import cn.hutool.core.bean.BeanUtil;
import com.yomahub.liteflow.core.FlowExecutor;
import com.yomahub.liteflow.flow.LiteflowResponse;
import com.yomahub.liteflow.parser.sql.exception.ELSQLException;
import com.yomahub.liteflow.parser.sql.vo.SQLParserVO;
import com.yomahub.liteflow.property.LiteflowConfig;
import com.yomahub.liteflow.property.LiteflowConfigGetter;
import github.garygan.liteflow.dto.UserContext;
import github.garygan.liteflow.dto.tag.AgeTagContext;
import github.garygan.liteflow.dto.tag.OldRetireTagContext;
import github.garygan.liteflow.dto.tag.SexTagContext;
import github.garygan.liteflow.dto.tag.TagContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

@Component
public class UserTagCommand2 implements CommandLineRunner {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Resource
    private FlowExecutor flowExecutor;

    @Override
    public void run(String... args) throws Exception {

        flushTag();

        Thread.sleep(5000L);
        // 模拟修改配置文件
        changeScriptData();
        // 刷新规则
        flowExecutor.reloadRule();
        Thread.sleep(2000L);

        flushTag();
    }

    private void flushTag() {
        // 模拟从数据库中取出用户集合
        UserContext userContext = new UserContext(0, 60, true, new ArrayList<>(1));
        UserContext userContext1 = new UserContext(1, 40, true, new ArrayList<>(1));
        UserContext[] userContexts = {userContext, userContext1};

        // 模拟从数据库中取出的标签配置
        TagContext ageTagContext = new AgeTagContext();
        TagContext sexTagContext = new SexTagContext();
        TagContext oldRetairTagContext = new OldRetireTagContext();
        TagContext[] tagContexts = {ageTagContext, sexTagContext, oldRetairTagContext};

        for (TagContext tagContext : tagContexts) {
            for (int i = 0; i < userContexts.length; i++) {
                UserContext tempUserContext = userContexts[i];
                LiteflowResponse liteflowResponse = flowExecutor.execute2Resp(tagContext.getTagId(), null, tempUserContext, tagContext);
                userContexts[i] = liteflowResponse.getContextBean(UserContext.class);
            }
        }


        // 模拟将userContext录入数据库
        Arrays.stream(userContexts).forEach(System.out::println);
    }

    /**
     * 修改数据库数据
     */
    private void changeScriptData() {
        LiteflowConfig liteflowConfig = LiteflowConfigGetter.get();
        SQLParserVO sqlParserVO = BeanUtil.mapToBean(liteflowConfig.getRuleSourceExtDataMap(), SQLParserVO.class, true);
        Connection connection;
        try {
            connection = DriverManager.getConnection(sqlParserVO.getUrl(), sqlParserVO.getUsername(),
                    sqlParserVO.getPassword());
            Statement statement = connection.createStatement();
            statement.executeUpdate(
                    "UPDATE SCRIPT SET script_data='getAge(userContext)>30' WHERE SCRIPT_ID='old_man'");
            System.out.println("规则修改了");
        } catch (SQLException e) {
            throw new ELSQLException(e.getMessage());
        }
    }

}
