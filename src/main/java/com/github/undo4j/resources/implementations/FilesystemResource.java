package com.github.undo4j.resources.implementations;

import com.github.undo4j.common.LockManager;
import com.github.undo4j.resources.InternalResource;
import com.github.undo4j.resources.ResourceState;
import com.github.undo4j.resources.StatelessResource;

public class FilesystemResource extends StatelessResource<FilesystemInterface> {

	public FilesystemResource(InternalResource<FilesystemInterface> resource,
			LockManager lockManager) {
		super(resource, lockManager);
	}

	@Override
	public void rollback() {
		InternalResource<FilesystemInterface> internalResource = getInternalResource();
		try {
			ResourceState<FilesystemInterface> resourceState = internalResource
					.buildState();
			FilesystemInterface dataObject = resourceState.get();
			dataObject.rollback();
		} catch (Exception e) {
			throw new RuntimeException("rollback failed", e);
		}
	}

}
