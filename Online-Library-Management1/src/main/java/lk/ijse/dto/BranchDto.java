package lk.ijse.dto;
public class BranchDto {


    private Long branchId;

    private String branchName;

    private String location;

    private String manager;

    private String contactInformation;


 public BranchDto(){}
    public BranchDto(Long branchId, String branchName, String location, String manager, String contactInformation) {
        this.branchId = branchId;
        this.branchName = branchName;
        this.location = location;
        this.manager = manager;
        this.contactInformation = contactInformation;

    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public void setContactInformation(String contactInformation) {
        this.contactInformation = contactInformation;
    }


    public Long getBranchId() {
        return branchId;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getLocation() {
        return location;
    }

    public String getManager() {
        return manager;
    }

    public String getContactInformation() {
        return contactInformation;
    }
    @Override
    public String toString() {
        return "Branch{" +
                "branchId=" + branchId +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                ", manager='" + manager + '\'' +
                ", contactInformation='" + contactInformation + '\'' +
                '}';
    }
}
