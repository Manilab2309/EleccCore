/**
 * Util class 
 */
package com.elecc.util;

/**
 * @author Ramón Cigüenza Fuster
 *
 */
public class Constants {
	
	/** Constants utilities	*/
	
	/** Empty string	*/
	public static final String EMPTY = "";
	
	/** Space string	*/
	public static final String SPACE = " ";
	
	/** Role users	*/
	public static final String ADMIN = "admin";
	public static final String NORMAL = "normal";
	
	public class MsgExceptions {
		
		/** Not Allowed User	*/
		public static final String MSG_ERROR_USER_NOT_AUTHORIZED = "User not authorized";
		
		/** Encrypt Module Error	*/
		public static final String MSG_ERROR_ENCRYPT_MODULE = "Encrypt module error";
		
		/** Bad Credentials	*/
		public static final String MSG_ERROR_BAD_CREDENTIALS = "Credentials error";
		
	}
	
	public class MsgDebugOperations {
		
		/** Debug Message User Not Authorized	*/
		public static final String DEBUG_PREFIX_MSG_DEBUG = "[EleccCore] - ";
		
		/** Debug Message User Not Authorized	*/
		public static final String DEBUG_MSG_ERROR_USER_NOT_AUTHORIZED = "User not authorized";
		
		
	}
	
	public class ModelFields {
		
		/** Field identification from citizen collection	*/
		public static final String FIELD_CTZ_IDENTIFICATION = "ident";
		
		/** Field name from citizen collection	*/
		public static final String FIELD_CTZ_NAME = "name";
		
		/** Field surname from citizen collection	*/
		public static final String FIELD_CTZ_SURNAME = "surname";
		
		/** Field province from citizen collection	*/
		public static final String FIELD_CTZ_PROVINCE = "province";
		
	}

}
