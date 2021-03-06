/*!COPYRIGHT HEADER! 
 *
 */

package com.darwino.xsp.ios.app;

import com.darwino.jsonstore.extensions.DefaultExtensionRegistry;
import com.darwino.jsonstore.impl.DarwinoInfCursorFactory;
import com.darwino.jsonstore.local.DefaultDatabaseACLFactory;

/**
 * Database Business logic - event handlers.
 */
public  class AppDBBusinessLogic extends DefaultExtensionRegistry {
	
	@SuppressWarnings("unused")
	public AppDBBusinessLogic() {
		// Add here the database events to register to the JSON store
//		registerDocumentEvents("<My Database Id>", "<My Store Id>", new DocumentEvents() {
//			@Override
//			public void querySaveDocument(Document doc) throws JsonException {
//			}
//		});
		
		// Use a query factory
		setQueryFactory(new DarwinoInfCursorFactory(getClass()));
		
		// Default database ACL factory read the design element coming from Domino
		if(false) {
			setDatabaseACLFactory(new DefaultDatabaseACLFactory());
		}
	}
}
