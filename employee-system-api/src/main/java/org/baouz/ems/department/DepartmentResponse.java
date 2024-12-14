package org.baouz.ems.department;

public record DepartmentResponse(
        String id,
        String name,
        String description,
        String location
) {
    public static DepartmentResponseBuilder builder() {
        return new DepartmentResponseBuilder();
    }

    public static class DepartmentResponseBuilder {
        private String id;
        private String name;
        private String description;
        private String location;

        DepartmentResponseBuilder() {
        }

        public DepartmentResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public DepartmentResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public DepartmentResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public DepartmentResponseBuilder location(String location) {
            this.location = location;
            return this;
        }

        public DepartmentResponse build() {
            return new DepartmentResponse(this.id, this.name, this.description, this.location);
        }

        public String toString() {
            return "DepartmentResponse.DepartmentResponseBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", location=" + this.location + ")";
        }
    }
}
