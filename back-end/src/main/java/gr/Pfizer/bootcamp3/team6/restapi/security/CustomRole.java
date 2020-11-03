package gr.Pfizer.bootcamp3.team6.restapi.security;

public enum CustomRole {
    ROLE_NA("n/a"),
    ROLE_PATIENT("patient"),
    ROLE_DOCTOR("doctor"),
    ROLE_CHIEF_DOCTOR("chiefDoctor");

    private final String roleName;

    CustomRole(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public static CustomRole getRoleValue(String roleParameter) {
        for (CustomRole role : CustomRole.values()) {
            if (roleParameter.equals(role.getRoleName()))
                return role;
        }
        return ROLE_NA;
    }
}
