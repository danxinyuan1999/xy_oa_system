package com.dan.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * 部门节点
 *
 * @author dan
 */
@Getter
@Setter
@ToString
public class SysDepartNode extends SysDepart {
    /**
     * 部门节点
     */
    List<SysDepartNode> children;
}
