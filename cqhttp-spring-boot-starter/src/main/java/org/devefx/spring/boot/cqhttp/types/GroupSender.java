package org.devefx.spring.boot.cqhttp.types;

import lombok.Data;
import org.devefx.spring.boot.cqhttp.enums.Role;

@Data
public class GroupSender extends Sender {

    /**
     * 群名片／备注
     */
    private String card;

    /**
     * 地区
     */
    private String area;

    /**
     * 成员等级
     */
    private String level;

    /**
     * 角色
     */
    private Role role;

    /**
     * 专属头衔
     */
    private String title;
}
