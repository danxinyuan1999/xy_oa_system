package com.dan.dto;

import com.dan.model.SysMenu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 菜单节点类
 *
 * @author dan
 */
@Getter
@Setter
public class SysMenuNode extends SysMenu {
    List<SysMenuNode> children;
}
