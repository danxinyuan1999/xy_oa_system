package com.dan.dto;

import com.dan.model.SysDepart;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * 部门节点封装
 * @author dan
 */
@Getter
@Setter
public class SysDepartNode extends SysDepart {
    List<SysDepartNode> children;
}
