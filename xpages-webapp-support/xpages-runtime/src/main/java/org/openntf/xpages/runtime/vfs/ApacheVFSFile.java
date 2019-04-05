package org.openntf.xpages.runtime.vfs;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import com.ibm.commons.vfs.VFSException;
import com.ibm.commons.vfs.VFSFile;

public class ApacheVFSFile extends VFSFile {
	private final FileObject file;

	protected ApacheVFSFile(ApacheVFS vfs, String fileName, FileObject file) {
		super(vfs, fileName);
		this.file = file;
	}

	@Override
	protected InputStream doGetInputStream() throws VFSException {
		try {
			return file.getContent().getInputStream();
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected OutputStream doGetOutputStream(boolean var1) throws VFSException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected long doGetSize() throws VFSException {
		try {
			return file.getContent().getSize();
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected List<?> doDelete() throws VFSException {
		throw new UnsupportedOperationException();
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
	protected long doGetLastModificationDate() throws VFSException {
		try {
			return file.getContent().getLastModifiedTime();
		} catch (FileSystemException e) {
			throw new VFSException(e, "Encountered VFS exception");
		}
	}

	@Override
	protected File doGetSystemFile() {
		return null;
	}

	@Override
	protected boolean doIsReadOnly() throws VFSException {
		return true;
	}

	@Override
	protected String doRename(String name) throws VFSException {
		throw new UnsupportedOperationException();
	}

	@Override
	protected void doSetLastModificationDate(long date) throws VFSException {
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
