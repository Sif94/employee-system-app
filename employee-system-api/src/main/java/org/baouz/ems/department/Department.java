package org.baouz.ems.department;

import jakarta.persistence.*;
import org.baouz.ems.common.BaseEntity;

import static jakarta.persistence.GenerationType.UUID;

@Entity
@Table(
        name = "departments",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "departments_unique_constraints_name",
                        columnNames = {"name"}
                )
        }
)
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = UUID)
    private String id;
    private String name;
    private String description;
    private String location;

    public Department(String id, String name, String description, String location) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
    }

    public Department() {
    }

    protected Department(DepartmentBuilder<?, ?> b) {
        super(b);
        this.id = b.id;
        this.name = b.name;
        this.description = b.description;
        this.location = b.location;
    }

    public static DepartmentBuilder<?, ?> builder() {
        return new DepartmentBuilderImpl();
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getLocation() {
        return this.location;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public static abstract class DepartmentBuilder<C extends Department, B extends DepartmentBuilder<C, B>> extends BaseEntityBuilder<C, B> {
        private String id;
        private String name;
        private String description;
        private String location;

        public B id(String id) {
            this.id = id;
            return self();
        }

        public B name(String name) {
            this.name = name;
            return self();
        }

        public B description(String description) {
            this.description = description;
            return self();
        }

        public B location(String location) {
            this.location = location;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "Department.DepartmentBuilder(super=" + super.toString() + ", id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", location=" + this.location + ")";
        }
    }

    private static final class DepartmentBuilderImpl extends DepartmentBuilder<Department, DepartmentBuilderImpl> {
        private DepartmentBuilderImpl() {
        }

        protected DepartmentBuilderImpl self() {
            return this;
        }

        public Department build() {
            return new Department(this);
        }
    }
}
