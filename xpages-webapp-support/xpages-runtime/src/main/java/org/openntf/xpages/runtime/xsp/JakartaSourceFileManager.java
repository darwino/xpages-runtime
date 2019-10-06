package org.openntf.xpages.runtime.xsp;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject.Kind;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.extlib.javacompiler.JavaSourceClassLoader;
import com.ibm.xsp.extlib.javacompiler.impl.JavaFileObjectClass;
import com.ibm.xsp.extlib.javacompiler.impl.SourceFileManager;

public class JakartaSourceFileManager extends SourceFileManager {
	private final JavaFileManager fileManager;
	
	public JakartaSourceFileManager(JavaFileManager fileManager, JavaSourceClassLoader classLoader, String[] classPath, boolean resolve) {
		super(fileManager, classLoader, classPath, resolve);
		this.fileManager = fileManager;
	}
	
	@Override
	public Iterable<JavaFileObject> list(Location location, String packageName, Set<Kind> kinds, boolean recurse)
			throws IOException {
		Iterable<JavaFileObject> sup = fileManager.list(location, packageName, kinds, recurse);
		if(sup.iterator().hasNext()) {
			return sup;
		} else {
			return getClasses().stream()
				.filter(c -> c.binaryName().startsWith(packageName + "."))
				.collect(Collectors.toList());
		}
	}
	
	private List<JavaFileObjectClass> classes;
	
	private List<JavaFileObjectClass> getClasses() {
		if(classes == null) {
			try {
				List<JavaFileObjectClass> list = new LinkedList<>();
				for(URL url : Collections.list(Thread.currentThread().getContextClassLoader().getResources("/"))) {
					String protocol = StringUtil.toString(url.getProtocol());
					if("file".equals(protocol)) {
						File dir = new File(url.toURI());
						if(dir.isDirectory()) {
							for(File file : dir.listFiles()) {
								if(file.isFile() && file.getName().endsWith(".class")) {
									dir.toPath().relativize(file.toPath());
									list.add(new JavaFileObjectClass(file.toURI(), removeClassExtension(dir.toPath().relativize(file.toPath()).toString())));
								}
							}
						}
					} else if(protocol.contains("jar")) {
						String jarUrl = url.toString();
						jarUrl = jarUrl.substring(0, jarUrl.indexOf("!/"));
						try(InputStream is = new URL(jarUrl).openStream()) {
							try(ZipInputStream jis = new ZipInputStream(is)) {
								ZipEntry entry = jis.getNextEntry();
								while(entry != null) {
									String name = entry.getName();
									if(name.endsWith(JavaSourceClassLoader.CLASS_EXTENSION)) {
										URI uri = new URI(jarUrl + "!/" + name);
										String binaryName = removeClassExtension(StringUtil.replace(name, '/' , '.'));
										list.add(new JavaFileObjectClass(uri, binaryName));
									}
									
									entry = jis.getNextEntry();
								}
							}
						}
					}
				}
				this.classes = list;
			} catch(IOException | URISyntaxException e) {
				throw new RuntimeException(e);
			}
		}
		return classes;
	}
	
	private static String removeClassExtension(String s) {
		return s.substring(0, s.length()-JavaSourceClassLoader.CLASS_EXTENSION.length());
	}
}
