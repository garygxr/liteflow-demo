package github.garygan.liteflow.dto;


import com.yomahub.liteflow.slot.DefaultContext;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserContext extends DefaultContext {
    /**
     * 性别
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 是否退休
     */
    private boolean retire;

    /**
     * 命中的标签id
     */
    private List<String> tags;

    @Override
    public String toString() {
        return "UserContext{" +
                "性别=" + sex +
                ", 年龄=" + age +
                ", 退休=" + retire +
                ", 标签=" + tags +
                '}';
    }
}
