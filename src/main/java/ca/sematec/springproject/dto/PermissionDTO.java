package ca.sematec.springproject.dto;

public class PermissionDTO {
    private Long id;
    private String name;

    public PermissionDTO() {
    }

    public PermissionDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
