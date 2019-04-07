/**
 * Copyright © 2019 Jesse Gallagher
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openntf.xpages.runtime.osgi;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.*;

import org.openntf.xpages.runtime.util.XSPUtil;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleException;
import org.osgi.framework.ServiceReference;

import com.ibm.commons.util.PathUtil;

public class MockBundle implements Bundle {

    private final Object context;
    private BundleContext bundleContext;

    public MockBundle(Object context) {
        this.context = context;
    }

    @Override
    public URL getResource(String s) {
		return XSPUtil.getResource(context.getClass().getClassLoader(), s);
    }

    @Override
    public URL getEntry(String s) {
        return getResource(s);
    }

    @Override
    public Class<?> loadClass(String s) throws ClassNotFoundException {
        return Thread.currentThread().getContextClassLoader().loadClass(s);
    }

    @Override
    public Enumeration<URL> getResources(String s) throws IOException {
		return XSPUtil.getResources(context.getClass().getClassLoader(), s);
    }

    @Override
    public Enumeration<String> getEntryPaths(String s) {
        return null;
    }

    @Override
    public Enumeration<URL> findEntries(String s, String s1, boolean b) {
    	try {
	    	// Not a perfect version, but it'll do
	    	String path = PathUtil.concat(s, s1, '/');
			return getResources(path);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
    }

    @Override
    public BundleContext getBundleContext() {
        return bundleContext;
    }
    
    public void setBundleContext(BundleContext bundleContext) {
		this.bundleContext = bundleContext;
	}
    
    // *******************************************************************************
	// * Stubbed methods
	// *******************************************************************************

    @Override
    public long getLastModified() {
        return 0;
    }

    @Override
    public int getState() {
        return 0;
    }

    @Override
    public void start(int i) throws BundleException {

    }

    @Override
    public void start() throws BundleException {

    }

    @Override
    public void stop(int i) throws BundleException {

    }

    @Override
    public void stop() throws BundleException {

    }

    @Override
    public void update(InputStream inputStream) throws BundleException {

    }

    @Override
    public void update() throws BundleException {

    }

    @Override
    public void uninstall() throws BundleException {

    }

    @Override
    public Dictionary<String, String> getHeaders() {
        return new Hashtable<>();
    }

    @Override
    public long getBundleId() {
        return 0;
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public ServiceReference<?>[] getRegisteredServices() {
        return new ServiceReference[0];
    }

    @Override
    public ServiceReference<?>[] getServicesInUse() {
        return new ServiceReference[0];
    }

    @Override
    public boolean hasPermission(Object o) {
        return false;
    }

    @Override
    public Dictionary<String, String> getHeaders(String s) {
        return new Hashtable<>();
    }

    @Override
    public String getSymbolicName() {
        return null;
    }

    @Override
    public Map<X509Certificate, List<X509Certificate>> getSignerCertificates(int i) {
        return null;
    }

    @Override
    public org.osgi.framework.Version getVersion() {
        return null;
    }

    @Override
    public <A> A adapt(Class<A> aClass) {
        return null;
    }

    @Override
    public File getDataFile(String s) {
        return null;
    }

    @Override
    public int compareTo(Bundle o) {
        return 0;
    }

}
