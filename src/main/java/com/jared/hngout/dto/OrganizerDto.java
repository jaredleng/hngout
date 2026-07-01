package com.jared.hngout.dto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrganizerDto {
    private Long id;
    private String name;
    private String email;
    private String contactNumber;
    private String companyRegNumber;
    public OrganizerDto(Long id,String name,String email,String contactNumber,String companyRegNumber){
        this.id=id;
        this.name=name;
        this.email=email;
        this.contactNumber=contactNumber;
        this.companyRegNumber=companyRegNumber;
    }

}
