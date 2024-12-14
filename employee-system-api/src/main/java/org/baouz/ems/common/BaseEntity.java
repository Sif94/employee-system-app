package org.baouz.ems.common;


import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @CreatedDate
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdDate;
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModifiedDate;
    @CreatedBy
    @Column(nullable = false, updatable = false)
    private String createdBy;
    @LastModifiedBy
    @Column(insertable = false)
    private String lastModifiedBy;

    public BaseEntity(LocalDateTime createdDate, LocalDateTime lastModifiedDate, String createdBy, String lastModifiedBy) {
        this.createdDate = createdDate;
        this.lastModifiedDate = lastModifiedDate;
        this.createdBy = createdBy;
        this.lastModifiedBy = lastModifiedBy;
    }

    public BaseEntity() {
    }

    protected BaseEntity(BaseEntityBuilder<?, ?> b) {
        this.createdDate = b.createdDate;
        this.lastModifiedDate = b.lastModifiedDate;
        this.createdBy = b.createdBy;
        this.lastModifiedBy = b.lastModifiedBy;
    }

    public static BaseEntityBuilder<?, ?> builder() {
        return new BaseEntityBuilderImpl();
    }

    public LocalDateTime getCreatedDate() {
        return this.createdDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return this.lastModifiedDate;
    }

    public String getCreatedBy() {
        return this.createdBy;
    }

    public String getLastModifiedBy() {
        return this.lastModifiedBy;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public static abstract class BaseEntityBuilder<C extends BaseEntity, B extends BaseEntityBuilder<C, B>> {
        private LocalDateTime createdDate;
        private LocalDateTime lastModifiedDate;
        private String createdBy;
        private String lastModifiedBy;

        public B createdDate(LocalDateTime createdDate) {
            this.createdDate = createdDate;
            return self();
        }

        public B lastModifiedDate(LocalDateTime lastModifiedDate) {
            this.lastModifiedDate = lastModifiedDate;
            return self();
        }

        public B createdBy(String createdBy) {
            this.createdBy = createdBy;
            return self();
        }

        public B lastModifiedBy(String lastModifiedBy) {
            this.lastModifiedBy = lastModifiedBy;
            return self();
        }

        protected abstract B self();

        public abstract C build();

        public String toString() {
            return "BaseEntity.BaseEntityBuilder(createdDate=" + this.createdDate + ", lastModifiedDate=" + this.lastModifiedDate + ", createdBy=" + this.createdBy + ", lastModifiedBy=" + this.lastModifiedBy + ")";
        }
    }

    private static final class BaseEntityBuilderImpl extends BaseEntityBuilder<BaseEntity, BaseEntityBuilderImpl> {
        private BaseEntityBuilderImpl() {
        }

        protected BaseEntityBuilderImpl self() {
            return this;
        }

        public BaseEntity build() {
            return new BaseEntity(this);
        }
    }
}
