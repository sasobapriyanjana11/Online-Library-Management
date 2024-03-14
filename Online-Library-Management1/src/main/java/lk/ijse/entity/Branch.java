package lk.ijse.entity;
import lombok.Getter;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


    @Entity
    @Table(name = "library_branches")
    public class Branch{

        @Getter
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "branchId")
        private Long branchId;

        @Getter
        @Column(name = "branchName")
        private String branchName;

        @Getter
        @Column(name = "location")
        private String location;

        @Getter
        @Column(name = "manager")
        private String manager;

        @Getter
        @Column(name = "contactInformation")
        private String contactInformation;

//        @ManyToOne
//        @JoinColumn(name = "admin_id")
//        private Admin Admin;


        // @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//    private List<Transaction> transactions;

        public Branch(){}
        public Branch(Long branchId, String branchName, String location, String manager, String contactInformation) {
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

