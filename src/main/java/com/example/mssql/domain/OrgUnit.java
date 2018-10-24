package com.example.mssql.domain;

public class OrgUnit {

    private int OrgUnitId;
    private int ParentOrgUnitId;
    private String OrgUnitName;
    private boolean Deleted;


    public int getOrgUnitId() {
        return OrgUnitId;
    }

    public void setOrgUnitId(int orgUnitId) {
        OrgUnitId = orgUnitId;
    }

    public int getParentOrgUnitId() {
        return ParentOrgUnitId;
    }

    public void setParentOrgUnitId(int parentOrgUnitId) {
        ParentOrgUnitId = parentOrgUnitId;
    }

    public String getOrgUnitName() {
        return OrgUnitName;
    }

    public void setOrgUnitName(String orgUnitName) {
        OrgUnitName = orgUnitName;
    }

    public boolean isDeleted() {
        return Deleted;
    }

    public void setDeleted(boolean deleted) {
        Deleted = deleted;
    }
}
