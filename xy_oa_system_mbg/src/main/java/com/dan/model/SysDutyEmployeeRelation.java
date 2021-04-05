package com.dan.model;

import java.io.Serializable;

public class SysDutyEmployeeRelation implements Serializable {
    private Long id;

    /**
     * 职务主键
     *
     * @mbg.generated
     */
    private Long dutyId;

    /**
     * 员工主键
     *
     * @mbg.generated
     */
    private Long userId;

    /**
     * 部门主键
     *
     * @mbg.generated
     */
    private Long departId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDutyId() {
        return dutyId;
    }

    public void setDutyId(Long dutyId) {
        this.dutyId = dutyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getDepartId() {
        return departId;
    }

    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", dutyId=").append(dutyId);
        sb.append(", userId=").append(userId);
        sb.append(", departId=").append(departId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}