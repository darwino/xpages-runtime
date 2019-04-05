package org.openntf.xpages.runtime.vfs;

import java.io.File;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import com.ibm.commons.vfs.VFS;
import com.ibm.commons.vfs.VFSException;
import com.ibm.commons.vfs.VFSFolder;

public class ApacheVFSFolder extends VFSFolder {
	private final FileObject file;

	protected ApacheVFSFolder(VFS vfs, String folderName, FileObject file) {
		super(vfs, folderName);
		this.file = file;
	}

	@Override
	protected boolean doMkDir() throws VFSException {
		try {
			file.createFolder();
			return true;
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected File doGetSystemFile() {
		return null;
	}

	@Override
	protected boolean doExists() throws VFSException {
		try {
			return file.exists();
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected boolean doIsReadOnly() throws VFSException {
		return true;
	}

	@Override
	protected long doGetLastModificationDate() throws VFSException {
		try {
			return file.getContent().getLastModifiedTime();
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected void doSetLastModificationDate(long date) throws VFSException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected List<?> doDelete() throws VFSException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected String doRename(String name) throws VFSException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Object getPeer() {
		return null;
	}

	public FileObject getFileObject() {
		return file;
	}
}
