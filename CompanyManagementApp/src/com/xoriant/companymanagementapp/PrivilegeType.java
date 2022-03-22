package com.xoriant.companymanagementapp;

public enum PrivilegeType {
	SILVER(15), GOLD(25), PLATINUM(30);

    private final int privilegeType;

    private PrivilegeType(int privilegeType) {
        this.privilegeType = privilegeType;
    }

    public static PrivilegeType getPrivilegeTypeName(int privilegeType) {
    	for (PrivilegeType ePrivilegeType : PrivilegeType.values()) {
			if (privilegeType == ePrivilegeType.privilegeType) {
				return ePrivilegeType;
			}
    	}
		return null;
    }
}
