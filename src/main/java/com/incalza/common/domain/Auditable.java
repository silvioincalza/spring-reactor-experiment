package com.incalza.common.domain;

import org.springframework.data.domain.Persistable;

import java.io.Serializable;
import java.time.Instant;

public interface Auditable<U, ID extends Serializable> extends Persistable<ID> {

	U getCreatedBy();

	void setCreatedBy(final U createdBy);

	Instant getCreatedDate();

	void setCreatedDate(final Instant creationDate);

	U getLastModifiedBy();

	void setLastModifiedBy(final U lastModifiedBy);

	Instant getLastModifiedDate();

	void setLastModifiedDate(final Instant lastModifiedDate);
}