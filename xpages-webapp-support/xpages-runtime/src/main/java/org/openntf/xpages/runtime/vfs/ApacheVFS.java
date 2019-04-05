package org.openntf.xpages.runtime.vfs;

import java.net.URL;
import java.util.List;
import java.util.regex.Pattern;

import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemException;

import com.ibm.commons.util.StringUtil;
import com.ibm.commons.vfs.VFS;
import com.ibm.commons.vfs.VFSException;
import com.ibm.commons.vfs.VFSFile;
import com.ibm.commons.vfs.VFSFilter.IFilter;
import com.ibm.commons.vfs.VFSFolder;

/**
 * Implementation of IBM Commons VFS using Apache Commons VFS, mixed with the local classpath
 * 
 * @author Jesse Gallagher
 * @since 1.0.0
 */
public class ApacheVFS extends VFS {
	private final FileObject root;
	
	/**
	 * Pattern matcher for local XSP classes, assumed to be in the "xsp" package.
	 */
	private static final Pattern XSP_CLASS = Pattern.compile("^xsp/[^/\\.]+\\.class$");
	
	// TODO split into a true ApacheVFS + ClasspathVFS and provide combined view
	public ApacheVFS(FileObject root) {
		this.root = root;
	}

	@Override
	protected FileEntry doCreateFileEntry(VFSFile file) {
		try {
			long mod = ((ApacheVFSFile)file).getFileObject().getContent().getLastModifiedTime();
			return new ApacheFileEntry(this, file, mod);
		} catch (FileSystemException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected FolderEntry doCreateFolderEntry(VFSFolder folder) {
		try {
			long mod = ((ApacheVFSFolder)folder).getFileObject().getContent().getLastModifiedTime();
			return new ApacheFolderEntry(this, folder, mod);
		} catch (FileSystemException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected VFSFile doCreateVFSFile(String fileName) {
		String localPath = localResolve(fileName);
		if(isBadClassResource(localPath)) {
			return new NopVFSFile(this, fileName);
		}
		URL uri = Thread.currentThread().getContextClassLoader().getResource(localPath);
		return new UrlVFSFile(this, fileName, uri);
	}

	@Override
	protected VFSFolder doCreateVFSFolder(String folderName) {
		try {
			FileObject file = org.apache.commons.vfs2.VFS.getManager().resolveFile(folderName);
			return new ApacheVFSFolder(this, folderName, file);
		} catch (FileSystemException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	protected boolean doIsReadonly() throws VFSException {
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doReadEntries(VFS vfs, String path, @SuppressWarnings("rawtypes") List result) {
		// Can't assume
//		try {
//			FileObject folder = root.resolveFile(path);
//			if(folder.isFolder()) {
//				for(FileObject child : folder.getChildren()) {
//					if(child.isFolder()) {
//						result.add(doCreateFolderEntry(doCreateVFSFolder(child.getName().toString())));
//					} else if(child.isFile()) {
//						result.add(doCreateFileEntry(doCreateVFSFile(child.getName().toString())));
//					}
//				}
//			}
//		} catch (FileSystemException e) {
//			throw new RuntimeException(e);
//		}
	}

	@SuppressWarnings("unchecked")
	@Override
	protected void doReadResources(String path, @SuppressWarnings("rawtypes") List result, IFilter filter) {
//		try {
//			FileObject folder = root.resolveFile(path);
//			if(folder.isFolder()) {
//				for(FileObject child : folder.getChildren()) {
//					if(child.isFolder()) {
//						result.add(doCreateVFSFolder(child.getName().toString()));
//					} else if(child.isFile()) {
//						result.add(doCreateVFSFile(child.getName().toString()));
//					}
//				}
//			}
//		} catch (FileSystemException e) {
//			throw new RuntimeException(e);
//		}
	}
	
	@Override
	public boolean hasEntryCache() {
		return true;
	}
	@Override
	protected Entry findEntry(String path) {
		String localPath = localResolve(path);
		if(isBadClassResource(path)) {
			return null;
		}
		return super.findEntry(localPath);
	}
	@Override
	protected FileEntry findFileEntry(String path) {
		String localPath = localResolve(path);
		if(isBadClassResource(path)) {
			return null;
		}
		return super.findFileEntry(localPath);
	}
	@Override
	protected FolderEntry findFolderEntry(String path) {
		// Special support for expected in-app resources
		URL uri = Thread.currentThread().getContextClassLoader().getResource(localResolve(path));
		try {
			FileObject file = org.apache.commons.vfs2.VFS.getManager().resolveFile(uri);
			return doCreateFolderEntry(new ApacheVFSFolder(this, path, file));
		} catch (FileSystemException e) {
			throw new RuntimeException(e);
		}
	}
	
	@Override
	public synchronized void refresh() {
		// NOP
	}
	
	@Override
	protected void doClose() {
		try {
			this.root.close();
		} catch (FileSystemException e) {
			e.printStackTrace();
		}
	}
	
	// *******************************************************************************
	// * Internal utility methods
	// *******************************************************************************
	
	// TODO determine if this is needed. It's here to try to get around Badly formed URI "res://WebContent/WEB-INF/classes/xsp/Layout.class", but that is
	//   not successful
	private String localResolve(String path) {
		String p = StringUtil.toString(path);
		if("WebContent/WEB-INF/classes".equals(p)) {
			return ".";
		} else if(p.startsWith("WebContent/WEB-INF/classes/")) {
			return p.substring("WebContent/WEB-INF/classes/".length());
		} else {
			return p;
		}
	}
	
	private boolean isBadClassResource(String path) {
		return path.endsWith(".class") && !XSP_CLASS.matcher(path).matches();
	}

	// *******************************************************************************
	// * Implementation support classes
	// *******************************************************************************
	
	private static class ApacheFileEntry extends FileEntry {
		public ApacheFileEntry(VFS vfs, VFSFile file, long modificationDate) {
			super(vfs, file, modificationDate);
		}
	}
	
	private static class ApacheFolderEntry extends FolderEntry {

		public ApacheFolderEntry(VFS vfs, VFSFolder folder, long modificationDate) {
			super(vfs, folder, modificationDate);
		}
		
	}
}
